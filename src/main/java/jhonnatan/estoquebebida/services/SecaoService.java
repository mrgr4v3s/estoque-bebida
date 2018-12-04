package jhonnatan.estoquebebida.services;

import jhonnatan.estoquebebida.entities.Historico;
import jhonnatan.estoquebebida.entities.Secao;
import jhonnatan.estoquebebida.entities.TipoBebida;
import jhonnatan.estoquebebida.entities.enums.MovimentoEnum;
import jhonnatan.estoquebebida.entities.payloads.SecaoPayload;
import jhonnatan.estoquebebida.entities.responses.SecaoResponse;
import jhonnatan.estoquebebida.exceptions.EstoqueBebidaException;
import jhonnatan.estoquebebida.interfaces.ISecaoService;
import jhonnatan.estoquebebida.repository.IHistoricoRepository;
import jhonnatan.estoquebebida.repository.ISecaoRepository;
import jhonnatan.estoquebebida.repository.ITipoBebidaRepository;
import jhonnatan.estoquebebida.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.Date;

@Service
public class SecaoService implements ISecaoService {
    @Autowired
    private ISecaoRepository secaoRepository;

    @Autowired
    private ITipoBebidaRepository tipoBebidaRepository;

    private IHistoricoRepository historicoRepository;

    @Override
    public SecaoResponse inserirBebidaSecao(SecaoPayload payload) {
        Secao secao = secaoRepository.findById(payload.getSecaoId()).orElse(null);

        if (Utils.isNull(secao))
            throw new EstoqueBebidaException(HttpStatus.NOT_FOUND, "Seção não encontrada");

        TipoBebida tipoBebida = tipoBebidaRepository.findById(payload.getTipoBebidaId()).orElse(null);
        if (Utils.isNull(tipoBebida))
            throw new EstoqueBebidaException(HttpStatus.NOT_FOUND, "Tipo Bebida não encontrado");

        if (!Utils.isNull(secao.getTipoBebida()) && !secao.getTipoBebida().equals(tipoBebida))
            throw new EstoqueBebidaException(HttpStatus.PRECONDITION_FAILED,
                    MessageFormat.format("Tipo Bebida {0} inválido. Estoque aceita somente {1}",
                                            payload.getTipoBebidaId(),
                                            tipoBebida.getId()));

        if (somarVolumes(payload.getVolume(), secao.getQuantidadePreenchida()) > tipoBebida.getVolume())
            throw new EstoqueBebidaException(HttpStatus.PRECONDITION_FAILED,
                    MessageFormat.format("Limite de volume do estoque atingido. Volume máximo é de {0}, volume atual do estoque é de {1}",
                            tipoBebida.getVolume(),
                            secao.getQuantidadePreenchida()));

        secao.setQuantidadePreenchida(somarVolumes(secao.getQuantidadePreenchida(), payload.getVolume()));
        secao.setTipoBebida(tipoBebida);

        secaoRepository.save(secao);

        gravarHistorico(MovimentoEnum.ENTRADA, secao, payload);

        return montarResponseEntrada(payload, tipoBebida, secao);
    }

    private void gravarHistorico(MovimentoEnum tipoMovimento, Secao secao, SecaoPayload payload) {
        Historico historico = new Historico();

        historico.setSecao(secao);
        historico.setTipoBebida(secao.getTipoBebida());
        historico.setTipoMovimento(tipoMovimento);
        historico.setVolumeMovimentado(payload.getVolume());
        historico.setDataMovimento(new Date());
        historico.setResponsavelMovimento(payload.getResponsavelMovimento());

        historicoRepository.save(historico);
    }

    @Override
    public SecaoResponse consultarBebidaSecao(SecaoPayload payload) {
        if (Utils.isNull(payload.getSecaoId()))
            throw new EstoqueBebidaException(HttpStatus.PRECONDITION_FAILED, "Campo \"secaoId\" está nulo");

        Secao secao = secaoRepository.findById(payload.getSecaoId()).orElse(null);

        if (Utils.isNull(secao))
            throw new EstoqueBebidaException(HttpStatus.PRECONDITION_FAILED, "Seção não encontrada");

        SecaoResponse secaoResponse = new SecaoResponse();

        secaoResponse.setMensagem(MessageFormat.format("Seção: {0}. Tipo bebida: {1}. Volume atual: {2}",
                secao.getNome(),
                secao.getTipoBebida().getId(),
                secao.getQuantidadePreenchida()));

        return secaoResponse;
    }

    @Override
    public SecaoResponse venderBebidaSecao(SecaoPayload payload) {
        Secao secao = secaoRepository.findById(payload.getSecaoId()).orElse(null);

        if (Utils.isNull(secao))
            throw new EstoqueBebidaException(HttpStatus.NOT_FOUND, "Seção não encontrada");

        TipoBebida tipoBebida = tipoBebidaRepository.findById(payload.getTipoBebidaId()).orElse(null);
        if (Utils.isNull(tipoBebida))
            throw new EstoqueBebidaException(HttpStatus.NOT_FOUND, "Tipo Bebida não encontrado");

        if (!Utils.isNull(secao.getTipoBebida()) && !secao.getTipoBebida().equals(tipoBebida))
            throw new EstoqueBebidaException(HttpStatus.PRECONDITION_FAILED,
                    MessageFormat.format("Tipo Bebida {0} inválido. Estoque aceita somente {1}",
                            payload.getTipoBebidaId(),
                            tipoBebida.getId()));

        if (somarVolumes(payload.getVolume(), secao.getQuantidadePreenchida()) > tipoBebida.getVolume())
            throw new EstoqueBebidaException(HttpStatus.PRECONDITION_FAILED,
                    MessageFormat.format("Limite de volume do estoque atingido. Volume máximo é de {0}, volume atual do estoque é de {1}",
                            tipoBebida.getVolume(),
                            secao.getQuantidadePreenchida()));

        secao.setQuantidadePreenchida(subtrairVolumes(secao.getQuantidadePreenchida(), payload.getVolume()));
        secao.setTipoBebida(tipoBebida);

        secaoRepository.save(secao);

        gravarHistorico(MovimentoEnum.SAIDA, secao, payload);

        return montarResponseSaida(payload, tipoBebida, secao);
    }

    private Long somarVolumes(Long volumeAdicionado, Long volumeAtual) {
        return volumeAdicionado + volumeAtual;
    }

    // Caso a soma seja menor ou igual a 0, é retornado o valor "0"
    private Long subtrairVolumes(Long volumeVendido, Long volumeAtual) {
        return volumeAtual - volumeVendido > 0 ? volumeAtual - volumeVendido : 0L;
    }

    private SecaoResponse montarResponseEntrada(SecaoPayload payload, TipoBebida tipoBebida, Secao secao) {
        SecaoResponse response = new SecaoResponse();

        response.setMensagem(MessageFormat.format("{0}L de bebida do tipo {1} foram inseridas na secao {2}",
                payload.getVolume(),
                tipoBebida.getNome(),
                secao.getNome()));

        return response;
    }

    private SecaoResponse montarResponseSaida(SecaoPayload payload, TipoBebida tipoBebida, Secao secao) {
        SecaoResponse response = new SecaoResponse();

        response.setMensagem(MessageFormat.format("{0}L de bebida do tipo {1} foram vendidas na secao {2}",
                payload.getVolume(),
                tipoBebida.getNome(),
                secao.getNome()));

        return response;
    }
}
