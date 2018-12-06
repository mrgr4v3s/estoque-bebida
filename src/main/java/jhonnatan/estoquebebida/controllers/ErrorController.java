package jhonnatan.estoquebebida.controllers;

import jhonnatan.estoquebebida.entities.responses.ErrorResponse;
import jhonnatan.estoquebebida.exceptions.EstoqueBebidaException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorController {
    @ExceptionHandler(EstoqueBebidaException.class)
    public ResponseEntity<ErrorResponse> estoqueBebidaExceptionHandler(EstoqueBebidaException ex) {
        ErrorResponse error = new ErrorResponse();

        error.setMensagem(ex.getMensagem());
        error.setInstrucao(ex.getInstrucao());

        ex.printStackTrace();

        return new ResponseEntity<>(error, ex.getStatus());
    }
}
