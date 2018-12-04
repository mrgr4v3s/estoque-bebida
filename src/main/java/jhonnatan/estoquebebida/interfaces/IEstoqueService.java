package jhonnatan.estoquebebida.interfaces;

import jhonnatan.estoquebebida.entities.responses.SecaoDisponivelResponse;
import jhonnatan.estoquebebida.entities.responses.VolumeTotalResponse;

import java.util.List;

public interface IEstoqueService {
    List<VolumeTotalResponse> consultarVolumeTotalTipoBebidaSecao();

    List<SecaoDisponivelResponse> consultarSecaoDisponivelEntrada(Long tipoBebidaId);

    List<SecaoDisponivelResponse> consultarSecaoDisponivelVenda(Long tipoBebidaId);
}
