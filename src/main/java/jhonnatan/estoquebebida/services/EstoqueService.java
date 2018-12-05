package jhonnatan.estoquebebida.services;

import jhonnatan.estoquebebida.entities.Secao;
import jhonnatan.estoquebebida.entities.TipoBebida;
import jhonnatan.estoquebebida.entities.responses.SecaoDisponivelResponse;
import jhonnatan.estoquebebida.entities.responses.VolumeTotalResponse;
import jhonnatan.estoquebebida.exceptions.EstoqueBebidaException;
import jhonnatan.estoquebebida.interfaces.IEstoqueService;
import jhonnatan.estoquebebida.repository.IEstoqueRepository;
import jhonnatan.estoquebebida.repository.ITipoBebidaRepository;
import jhonnatan.estoquebebida.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EstoqueService implements IEstoqueService {
    @Autowired
    private IEstoqueRepository estoqueRepository;

    @Autowired
    private ITipoBebidaRepository tipoBebidaRepository;

    @Override
    public List<VolumeTotalResponse> consultarVolumeTotalTipoBebidaSecao() {
        List<VolumeTotalResponse> volumeTotalResponse = new ArrayList<>();

        List<TipoBebida> tipoBebidas = tipoBebidaRepository.findAll();

        for (TipoBebida tipoBebida : tipoBebidas) {
            VolumeTotalResponse response = new VolumeTotalResponse();
            response.setTipoBebidaId(tipoBebida.getId());

            List<Secao> secoes = estoqueRepository.findAllByTipoBebida(tipoBebida);

            response.setVolumeTotal(calcularVolumeTotal(secoes));

            volumeTotalResponse.add(response);
        }
        return volumeTotalResponse;
    }

    @Override
    public List<SecaoDisponivelResponse> consultarSecaoDisponivelEntrada(Long tipoBebidaId) {
        TipoBebida tipoBebida = tipoBebidaRepository.findById(tipoBebidaId).orElse(null);

        if (Utils.isNull(tipoBebida))
            throw new EstoqueBebidaException(HttpStatus.PRECONDITION_FAILED, "Tipo Bebida não encontrado");

        List<SecaoDisponivelResponse> secaoDisponivelResponses = new ArrayList<>();
        List<Secao> secoes = estoqueRepository.findSecaoLivre(tipoBebida);

        if (secoes.isEmpty())
            throw new EstoqueBebidaException(HttpStatus.NOT_FOUND, "Nenhuma Seção disponível para entrada");

        for (Secao secao : secoes) {
            if (Utils.isNull(secao.getTipoBebida())) {
                SecaoDisponivelResponse response = new SecaoDisponivelResponse();

                response.setSecaoId(secao.getId());
                response.setVolumeDisponivel(null);

                secaoDisponivelResponses.add(response);

                continue;
            }

            if (secao.getQuantidadePreenchida() < secao.getTipoBebida().getVolume()) {
                SecaoDisponivelResponse response = new SecaoDisponivelResponse();

                response.setSecaoId(secao.getId());
                response.setVolumeDisponivel(secao.getTipoBebida().getVolume() - secao.getQuantidadePreenchida());

                secaoDisponivelResponses.add(response);
            }
        }

        return secaoDisponivelResponses;
    }

    @Override
    public List<SecaoDisponivelResponse> consultarSecaoDisponivelVenda(Long tipoBebidaId) {
        TipoBebida tipoBebida = tipoBebidaRepository.findById(tipoBebidaId).orElse(null);

        if (Utils.isNull(tipoBebida))
            throw new EstoqueBebidaException(HttpStatus.PRECONDITION_FAILED, "Tipo Bebida não encontrado");

        List<SecaoDisponivelResponse> secaoDisponivelResponses = new ArrayList<>();
        List<Secao> secoes = estoqueRepository.findAllByTipoBebida(tipoBebida);

        if (secoes.isEmpty())
            throw new EstoqueBebidaException(HttpStatus.NOT_FOUND, "Nenhuma Seção disponível para venda");

        for (Secao secao : secoes) {
            if (secao.getQuantidadePreenchida() > secao.getTipoBebida().getVolume()) {
                SecaoDisponivelResponse response = new SecaoDisponivelResponse();

                response.setSecaoId(secao.getId());
                response.setVolumeDisponivel(secao.getQuantidadePreenchida());

                secaoDisponivelResponses.add(response);
            }
        }
        return secaoDisponivelResponses;
    }

    private Long calcularVolumeTotal(List<Secao> secoes) {
        Long total = 0L;

        for (Secao secao : secoes) {
            total = total + secao.getQuantidadePreenchida();
        }

        return total;
    }
}
