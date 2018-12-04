package jhonnatan.estoquebebida.entities.payloads;

import jhonnatan.estoquebebida.utils.BasePayload;

public class HistoricoPayload extends BasePayload {
    private Long tipoBebidaId;
    private Long secaoId;

    @Override
    public void isValid() {
    }

    public Long getTipoBebidaId() {
        return tipoBebidaId;
    }

    public void setTipoBebidaId(Long tipoBebidaId) {
        this.tipoBebidaId = tipoBebidaId;
    }

    public Long getSecaoId() {
        return secaoId;
    }

    public void setSecaoId(Long secaoId) {
        this.secaoId = secaoId;
    }
}
