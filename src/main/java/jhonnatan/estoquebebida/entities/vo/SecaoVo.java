package jhonnatan.estoquebebida.entities.vo;

import jhonnatan.estoquebebida.entities.Secao;

public class SecaoVo {
    private Long id;
    private String nome;

    public SecaoVo(Secao secao) {
        this.id = secao.getId();
        this.nome = secao.getNome();
    }

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
}
