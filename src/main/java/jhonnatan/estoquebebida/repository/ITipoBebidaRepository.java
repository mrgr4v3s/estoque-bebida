package jhonnatan.estoquebebida.repository;

import jhonnatan.estoquebebida.entities.TipoBebida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ITipoBebidaRepository extends JpaRepository<TipoBebida, Long> {
    @Query(value = "select u from TipoBebida u")
    List<TipoBebida> findAll();
}
