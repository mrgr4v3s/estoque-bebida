package jhonnatan.estoquebebida.entities.responses;

public class SecaoDisponivelResponse {
    private Long secaoId;
    private Long volumeDisponivel;

    public Long getSecaoId() {
        return secaoId;
    }

    public void setSecaoId(Long secaoId) {
        this.secaoId = secaoId;
    }

    public Long getVolumeDisponivel() {
        return volumeDisponivel;
    }

    public void setVolumeDisponivel(Long volumeDisponivel) {
        this.volumeDisponivel = volumeDisponivel;
    }
}
