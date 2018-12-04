package jhonnatan.estoquebebida.repository;

import jhonnatan.estoquebebida.entities.TipoBebida;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ITipoBebidaRepository extends CrudRepository<TipoBebida, Long> {
    @Query(value = "select * from TipoBebida")
    List<TipoBebida> findAll();
}
