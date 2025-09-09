package jhonnatan.estoquebebida.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "TIPO_BEBIDA")
@SequenceGenerator(name = "TIPO_BEBIDA_SEQ_ID", sequenceName = "TIPO_BEBIDA_SEQ_ID", allocationSize = 1)
public class TipoBebida {
    @Id
    @GeneratedValue(generator = "TIPO_BEBIDA_SEQ_ID", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "NOME", nullable = false)
    private String nome;

    @Column(name = "VOLUME", nullable = false)
    private Long volume;

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

    public Long getVolume() {
        return volume;
    }

    public void setVolume(Long volume) {
        this.volume = volume;
    }
}
