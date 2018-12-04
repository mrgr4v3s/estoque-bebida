package jhonnatan.estoquebebida.exceptions;

import org.springframework.http.HttpStatus;

public class EstoqueBebidaException extends RuntimeException {
    private String mensagem;
    private HttpStatus status = HttpStatus.PRECONDITION_FAILED;
    private String instrucao;

    public EstoqueBebidaException(String mensagem) {
        super(mensagem);
        this.mensagem = mensagem;
    }

    public EstoqueBebidaException(HttpStatus status, String mensagem) {
        super(mensagem);
        this.mensagem = mensagem;
        this.status = status;
    }

    public EstoqueBebidaException(HttpStatus status, String mensagem, String instrucao) {
        super(mensagem);
        this.mensagem = mensagem;
        this.status = status;
        this.instrucao = instrucao;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public String getMessage() {
        return this.mensagem;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getInstrucao() {
        return instrucao;
    }

    public void setInstrucao(String instrucao) {
        this.instrucao = instrucao;
    }
}
