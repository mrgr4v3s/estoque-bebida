package jhonnatan.estoquebebida.entities.payloads;

import jhonnatan.estoquebebida.exceptions.EstoqueBebidaException;
import jhonnatan.estoquebebida.utils.BasePayload;
import jhonnatan.estoquebebida.utils.Utils;
import org.springframework.http.HttpStatus;

public class SecaoPayload extends BasePayload {
    private Long secaoId;
    private Long tipoBebidaId;
    private Long volume;
    private String responsavelMovimento;

    @Override
    public void isValid() {
        if (Utils.isNull(this.secaoId))
            throw new EstoqueBebidaException(HttpStatus.PRECONDITION_FAILED, "Campo \"secaoId\" está nulo", "Preencha o campo e tente novamente");

        if (Utils.isNull(this.tipoBebidaId))
            throw new EstoqueBebidaException(HttpStatus.PRECONDITION_FAILED, "Campo \"tipoBebidaId\" está vazio", "Preencha o campo e tente novamente");

        if (Utils.isNull(this.volume))
            throw new EstoqueBebidaException(HttpStatus.PRECONDITION_FAILED, "Campo \"volume\" está vazio", "Preencha o campo e tente novamente");

        if (Utils.isNull(this.responsavelMovimento))
            throw new EstoqueBebidaException(HttpStatus.PRECONDITION_FAILED, "Campo \"responsavelMovimento\" está vazio", "Preencha o campo e tente novamente");
    }

    public Long getSecaoId() {
        return secaoId;
    }

    public void setSecaoId(Long secaoId) {
        this.secaoId = secaoId;
    }

    public Long getTipoBebidaId() {
        return tipoBebidaId;
    }

    public void setTipoBebidaId(Long tipoBebidaId) {
        this.tipoBebidaId = tipoBebidaId;
    }

    public Long getVolume() {
        return volume;
    }

    public void setVolume(Long volume) {
        this.volume = volume;
    }

    public String getResponsavelMovimento() {
        return responsavelMovimento;
    }

    public void setResponsavelMovimento(String responsavelMovimento) {
        this.responsavelMovimento = responsavelMovimento;
    }
}
