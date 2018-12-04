package jhonnatan.estoquebebida.interfaces;

import jhonnatan.estoquebebida.entities.payloads.SecaoPayload;
import jhonnatan.estoquebebida.entities.responses.SecaoResponse;

public interface ISecaoService {
    SecaoResponse inserirBebidaSecao(SecaoPayload payload);

    SecaoResponse consultarBebidaSecao(SecaoPayload payload);

    SecaoResponse venderBebidaSecao(SecaoPayload payload);
}
