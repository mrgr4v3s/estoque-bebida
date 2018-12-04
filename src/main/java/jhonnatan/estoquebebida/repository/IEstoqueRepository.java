package jhonnatan.estoquebebida.repository;

import jhonnatan.estoquebebida.entities.Secao;
import jhonnatan.estoquebebida.entities.TipoBebida;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IEstoqueRepository extends CrudRepository<Secao, Long> {
    List<Secao> findAllByTipoBebidaAndTipoBebidaIsNull(TipoBebida tipoBebida);

    List<Secao> findAllByTipoBebida(TipoBebida tipoBebida);
}
