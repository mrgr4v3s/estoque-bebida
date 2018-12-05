package jhonnatan.estoquebebida.repository;

import jhonnatan.estoquebebida.entities.Secao;
import jhonnatan.estoquebebida.entities.TipoBebida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IEstoqueRepository extends JpaRepository<Secao, Long> {
    @Query(value = "select u from Secao u where u.tipoBebida = ?1 or u.tipoBebida is null ")
    List<Secao> findSecaoLivre(TipoBebida tipoBebida);

    @Query(value = "select u from Secao u where u.tipoBebida = ?1")
    List<Secao> findAllByTipoBebida(TipoBebida tipoBebida);
}
