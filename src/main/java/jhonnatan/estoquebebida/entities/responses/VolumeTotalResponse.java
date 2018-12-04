package jhonnatan.estoquebebida.entities.responses;

public class VolumeTotalResponse {
    private Long tipoBebidaId;
    private Long volumeTotal;

    public Long getTipoBebidaId() {
        return tipoBebidaId;
    }

    public void setTipoBebidaId(Long tipoBebidaId) {
        this.tipoBebidaId = tipoBebidaId;
    }

    public Long getVolumeTotal() {
        return volumeTotal;
    }

    public void setVolumeTotal(Long volumeTotal) {
        this.volumeTotal = volumeTotal;
    }
}
