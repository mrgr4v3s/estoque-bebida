package jhonnatan.estoquebebida.repository;

import jhonnatan.estoquebebida.entities.Historico;
import jhonnatan.estoquebebida.entities.Secao;
import jhonnatan.estoquebebida.entities.TipoBebida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IHistoricoRepository extends JpaRepository<Historico, Long> {
    @Query(value = "select u from Historico u where u.secao = ?1")
    List<Historico> findAllBySecao(Secao secao);

    @Query(value = "select u from Historico u where u.tipoBebida = ?1")
    List<Historico> findAllByTipoBebida(TipoBebida tipoBebida);
}
