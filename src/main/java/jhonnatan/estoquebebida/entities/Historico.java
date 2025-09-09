package jhonnatan.estoquebebida.entities;

import jhonnatan.estoquebebida.entities.enums.MovimentoEnum;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "HISTORICO")
@SequenceGenerator(name = "HISTORICO_SEQ_ID", sequenceName = "HISTORICO_SEQ_ID", allocationSize = 1)
public class Historico {
    @Id
    @GeneratedValue(generator = "HISTORICO_SEQ_ID", strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(referencedColumnName = "ID")
    private Secao secao;

    @Column(name = "TIPO_MOVIMENTO")
    @Enumerated(value = EnumType.ORDINAL)
    private MovimentoEnum tipoMovimento;

    @ManyToOne
    @JoinColumn(referencedColumnName = "ID")
    private TipoBebida tipoBebida;

    @Column(name = "RESPONSAVEL_MOVIMENTO")
    private String responsavelMovimento;

    @Column(name = "VOLUME_MOVIMENTADO")
    private Long volumeMovimentado;

    @Column(name = "DATA_MOVIMENTO")
    private Date dataMovimento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Secao getSecao() {
        return secao;
    }

    public void setSecao(Secao secao) {
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

    public String getResponsavelMovimento() {
        return responsavelMovimento;
    }

    public void setResponsavelMovimento(String responsavelMovimento) {
        this.responsavelMovimento = responsavelMovimento;
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
