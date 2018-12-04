package jhonnatan.estoquebebida.entities.responses;

import org.springframework.http.HttpStatus;

public class SecaoResponse {
    private HttpStatus status = HttpStatus.OK;
    private String mensagem;

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
