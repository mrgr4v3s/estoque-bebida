package jhonnatan.estoquebebida.services;

import jhonnatan.estoquebebida.entities.TipoBebida;
import jhonnatan.estoquebebida.entities.payloads.TipoBebidaPayload;
import jhonnatan.estoquebebida.entities.responses.TipoBebidaResponse;
import jhonnatan.estoquebebida.exceptions.EstoqueBebidaException;
import jhonnatan.estoquebebida.interfaces.ITipoBebidaService;
import jhonnatan.estoquebebida.repository.ITipoBebidaRepository;
import jhonnatan.estoquebebida.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;

@Service
public class TipoBebidaService implements ITipoBebidaService {

    @Autowired
    private ITipoBebidaRepository tipoBebidaRepository;

    @Override
    public TipoBebidaResponse consultarTipoBebida(Long tipoBebidaId) {
        TipoBebida tipoBebida = tipoBebidaRepository.findById(tipoBebidaId)
                .orElse(null);

        if (Utils.isNull(tipoBebida))
            throw new EstoqueBebidaException(HttpStatus.NOT_FOUND, "Tipo Bebida não encontrada", "Por favor informe um Tipo Bebida válido");

        return montarRespostaGet(tipoBebida);
    }

    @Override
    public TipoBebidaResponse criarTipoBebida(TipoBebidaPayload payload) {
        TipoBebida tipoBebida = new TipoBebida();

        tipoBebida.setNome(payload.getNome());
        tipoBebida.setVolume(payload.getVolume());

        tipoBebidaRepository.save(tipoBebida);

        return montarRespostaGet(tipoBebida);
    }

    @Override
    public TipoBebidaResponse alterarTipoBebida(Long tipoBebidaId, TipoBebidaPayload payload) {
        if (tipoBebidaId == 1L || tipoBebidaId == 2L)
            throw new EstoqueBebidaException(HttpStatus.PRECONDITION_FAILED, "Não é possível alterar Tipo Bebida do tipo \"Alcóolicas\" ou \"Não Alcoólicas\"");

        if (payload.getVolume() == 0L)
            throw new EstoqueBebidaException(HttpStatus.PRECONDITION_FAILED, "Volume não pode ser igual a \"0\"");

        TipoBebida tipoBebida = tipoBebidaRepository.findById(tipoBebidaId).orElse(null);

        if (Utils.isNull(tipoBebida))
            throw new EstoqueBebidaException(HttpStatus.NOT_FOUND, "Tipo bebida não encontrado");

        if (!Utils.isNull(payload.getNome()))
            tipoBebida.setNome(payload.getNome());

        if (!Utils.isNull(payload.getVolume()))
            tipoBebida.setVolume(payload.getVolume());

        tipoBebidaRepository.save(tipoBebida);

        return montarRespostaGet(tipoBebida);
    }

    @Override
    public TipoBebidaResponse removerTipoBebida(Long tipoBebidaId) {
        TipoBebida tipoBebida = tipoBebidaRepository.findById(tipoBebidaId).orElse(null);

        if (Utils.isNull(tipoBebida))
            throw new EstoqueBebidaException(HttpStatus.NOT_FOUND, "Tipo Bebida não encontrado");

        tipoBebidaRepository.delete(tipoBebida);

        TipoBebidaResponse response = new TipoBebidaResponse();

        response.setMensagem(MessageFormat.format("Tipo bebida {0} removido com sucesso", tipoBebidaId));

        return response;
    }

    private TipoBebidaResponse montarRespostaGet(TipoBebida tipoBebida) {
        TipoBebidaResponse response = new TipoBebidaResponse();

        response.setId(tipoBebida.getId());
        response.setNome(tipoBebida.getNome());
        response.setVolume(tipoBebida.getVolume());

        return response;
    }
}
