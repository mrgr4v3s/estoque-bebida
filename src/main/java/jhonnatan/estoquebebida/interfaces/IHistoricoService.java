package jhonnatan.estoquebebida.interfaces;

import jhonnatan.estoquebebida.entities.payloads.HistoricoPayload;
import jhonnatan.estoquebebida.entities.responses.HistoricoResponse;

public interface IHistoricoService {
    HistoricoResponse consultaHistoricoPorBebida(HistoricoPayload payload);

    HistoricoResponse consultaHistoricoPorSecao(HistoricoPayload payload);
}
