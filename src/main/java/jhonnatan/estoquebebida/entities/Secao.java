package jhonnatan.estoquebebida.entities;

import javax.persistence.*;

@Entity
@Table(name = "SECAO")
@SequenceGenerator(name = "SECAO_SEQ_ID", sequenceName = "SECAO_SEQ_ID", allocationSize = 1)
public class Secao {
    @Id
    @GeneratedValue(generator = "SECAO_SEQ_ID", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "NOME", nullable = false)
    private String nome;

    @ManyToOne
    @JoinColumn(referencedColumnName = "ID")
    private TipoBebida tipoBebida;

    @Column(name = "QUANTIDADE_PREENCHIDA")
    private Long quantidadePreenchida;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoBebida getTipoBebida() {
        return tipoBebida;
    }

    public void setTipoBebida(TipoBebida tipoBebida) {
        this.tipoBebida = tipoBebida;
    }

    public Long getQuantidadePreenchida() {
        return quantidadePreenchida;
    }

    public void setQuantidadePreenchida(Long quantidadePreenchida) {
        this.quantidadePreenchida = quantidadePreenchida;
    }
}
