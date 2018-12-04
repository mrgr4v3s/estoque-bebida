package jhonnatan.estoquebebida.interfaces;

import jhonnatan.estoquebebida.entities.payloads.TipoBebidaPayload;
import jhonnatan.estoquebebida.entities.responses.TipoBebidaResponse;

public interface ITipoBebidaService {
    TipoBebidaResponse consultarTipoBebida(Long tipoBebidaId);

    TipoBebidaResponse criarTipoBebida(TipoBebidaPayload payload);

    TipoBebidaResponse alterarTipoBebida(Long tipoBebidaId, TipoBebidaPayload payload);

    TipoBebidaResponse removerTipoBebida(Long tipoBebidaId);
}
