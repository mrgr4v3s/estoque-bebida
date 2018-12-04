package jhonnatan.estoquebebida.services;

import jhonnatan.estoquebebida.entities.Historico;
import jhonnatan.estoquebebida.entities.Secao;
import jhonnatan.estoquebebida.entities.TipoBebida;
import jhonnatan.estoquebebida.entities.payloads.HistoricoPayload;
import jhonnatan.estoquebebida.entities.responses.HistoricoResponse;
import jhonnatan.estoquebebida.entities.vo.HistoricoVo;
import jhonnatan.estoquebebida.entities.vo.SecaoVo;
import jhonnatan.estoquebebida.exceptions.EstoqueBebidaException;
import jhonnatan.estoquebebida.interfaces.IHistoricoService;
import jhonnatan.estoquebebida.repository.IHistoricoRepository;
import jhonnatan.estoquebebida.repository.ISecaoRepository;
import jhonnatan.estoquebebida.repository.ITipoBebidaRepository;
import jhonnatan.estoquebebida.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HistoricoService implements IHistoricoService {
    @Autowired
    private IHistoricoRepository historicoRepository;

    @Autowired
    private ITipoBebidaRepository tipoBebidaRepository;

    @Autowired
    private ISecaoRepository secaoRepository;

    @Override
    public HistoricoResponse consultaHistoricoPorBebida(HistoricoPayload payload) {
        if (Utils.isNull(payload.getTipoBebidaId()))
            throw new EstoqueBebidaException(HttpStatus.PRECONDITION_FAILED, "Campo \"tipoBebidaId\" está nulo");

        TipoBebida tipoBebida = tipoBebidaRepository.findById(payload.getTipoBebidaId()).orElse(null);

        if (Utils.isNull(tipoBebida))
            throw new EstoqueBebidaException(HttpStatus.NOT_FOUND, "Tipo Bebida não encontrado");

        List<Historico> historicos = historicoRepository.findAllByTipoBebida(tipoBebida);

        if (historicos.isEmpty())
            throw new EstoqueBebidaException(HttpStatus.NOT_FOUND, "Não existem movimentações com o Tipo Bebida informado");

        return montarResponse(historicos);
    }

    @Override
    public HistoricoResponse consultaHistoricoPorSecao(HistoricoPayload payload) {
        if (Utils.isNull(payload.getSecaoId()))
            throw new EstoqueBebidaException(HttpStatus.PRECONDITION_FAILED, "Campo \"secaoId\" está nulo");

        Secao secao = secaoRepository.findById(payload.getSecaoId()).orElse(null);

        if (Utils.isNull(secao))
            throw new EstoqueBebidaException(HttpStatus.NOT_FOUND, "Seção não encontrada");

        List<Historico> historicos = historicoRepository.findAllBySecao(secao);

        if (historicos.isEmpty())
            throw new EstoqueBebidaException(HttpStatus.NOT_FOUND, "Nenhuma movimentação foi encontrada com a Seção informada");

        return montarResponse(historicos);
    }

    private HistoricoResponse montarResponse(List<Historico> historicos) {
        List<HistoricoVo> historicoVos = new ArrayList<>();

        for (Historico historico : historicos) {
            HistoricoVo historicoVo = new HistoricoVo(historico);

            SecaoVo secaoVo = new SecaoVo(historico.getSecao());

            historicoVo.setSecao(secaoVo);

            historicoVos.add(historicoVo);
        }
        return new HistoricoResponse(historicoVos);
    }
}
