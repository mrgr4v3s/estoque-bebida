package jhonnatan.estoquebebida.entities.vo;

import jhonnatan.estoquebebida.entities.Historico;
import jhonnatan.estoquebebida.entities.TipoBebida;
import jhonnatan.estoquebebida.entities.enums.MovimentoEnum;

import java.util.Date;

public class HistoricoVo {
    private Long id;
    private SecaoVo secao;
    private MovimentoEnum tipoMovimento;
    private TipoBebida tipoBebida;
    private String responsavel;
    private Long volumeMovimentado;
    private Date dataMovimento;

    public HistoricoVo(Historico historico) {
        this.id = historico.getId();
        this.tipoMovimento = historico.getTipoMovimento();
        this.tipoBebida = historico.getTipoBebida();
        this.responsavel = historico.getResponsavelMovimento();
        this.volumeMovimentado = historico.getVolumeMovimentado();
        this.dataMovimento = historico.getDataMovimento();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SecaoVo getSecao() {
        return secao;
    }

    public void setSecao(SecaoVo secao) {
        this.secao = secao;
    }

    public MovimentoEnum getTipoMovimento() {
        return tipoMovimento;
    }

    public void setTipoMovimento(MovimentoEnum tipoMovimento) {
        this.tipoMovimento = tipoMovimento;
    }

    public TipoBebida getTipoBebida() {
        return tipoBebida;
    }

    public void setTipoBebida(TipoBebida tipoBebida) {
        this.tipoBebida = tipoBebida;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public Long getVolumeMovimentado() {
        return volumeMovimentado;
    }

    public void setVolumeMovimentado(Long volumeMovimentado) {
        this.volumeMovimentado = volumeMovimentado;
    }

    public Date getDataMovimento() {
        return dataMovimento;
    }

    public void setDataMovimento(Date dataMovimento) {
        this.dataMovimento = dataMovimento;
    }
}
