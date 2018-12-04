package jhonnatan.estoquebebida.entities.payloads;

import jhonnatan.estoquebebida.exceptions.EstoqueBebidaException;
import jhonnatan.estoquebebida.utils.BasePayload;
import jhonnatan.estoquebebida.utils.Utils;
import org.springframework.http.HttpStatus;

public class TipoBebidaPayload extends BasePayload {
    private String nome;
    private Long volume;

    @Override
    public void isValid() {
        if (Utils.isNull(this.nome))
            throw new EstoqueBebidaException(HttpStatus.PRECONDITION_FAILED, "Campo \"nome\" está nulo", "Por favor, informe o nome do Tipo Bebida");

        if (Utils.isNull(this.volume))
            throw new EstoqueBebidaException(HttpStatus.PRECONDITION_FAILED, "Campo \"Volume\" está nulo", "Por favor, informe o volume do Tipo Bebida");
    }

    public String getNome() {
        return nome.trim();
    }

    public void setNome(String nome) {
        this.nome = nome.trim();
    }

    public Long getVolume() {
        return volume;
    }

    public void setVolume(Long volume) {
        this.volume = volume;
    }
}
