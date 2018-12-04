package jhonnatan.estoquebebida.repository;

import jhonnatan.estoquebebida.entities.Historico;
import jhonnatan.estoquebebida.entities.Secao;
import jhonnatan.estoquebebida.entities.TipoBebida;
import jhonnatan.estoquebebida.entities.enums.MovimentoEnum;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IHistoricoRepository extends CrudRepository<Historico, Long> {
    List<Historico> findAllByTipoMovimento(MovimentoEnum tipoMovimento);

    List<Historico> findAllBySecao(Secao secao);

    List<Historico> findAllByTipoBebida(TipoBebida tipoBebida);
}
