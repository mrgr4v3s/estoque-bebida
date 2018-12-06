package jhonnatan.estoquebebida.controllers;

import jhonnatan.estoquebebida.entities.payloads.TipoBebidaPayload;
import jhonnatan.estoquebebida.entities.responses.TipoBebidaResponse;
import jhonnatan.estoquebebida.interfaces.ITipoBebidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tipo-bebida")
public class TipoBebidaController {
    @Autowired
    private ITipoBebidaService tipoBebidaService;

    @RequestMapping(value = "/{tipoBebidaId}", method = RequestMethod.GET)
    public ResponseEntity<TipoBebidaResponse> consultarTipoBebida(@PathVariable("tipoBebidaId") Long tipoBebidaId) {
        TipoBebidaResponse response = tipoBebidaService.consultarTipoBebida(tipoBebidaId);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<TipoBebidaResponse> criarTipoBebida(@RequestBody TipoBebidaPayload payload) {
        payload.isValid();

        TipoBebidaResponse response = tipoBebidaService.criarTipoBebida(payload);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{tipoBebidaId}", method = RequestMethod.PUT)
    public ResponseEntity<TipoBebidaResponse> alterarTipoBebida(@PathVariable("tipoBebidaId") Long tipoBebidaId,
                                                @RequestBody TipoBebidaPayload payload) {
        TipoBebidaResponse response = tipoBebidaService.alterarTipoBebida(tipoBebidaId, payload);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{tipoBebidaId}", method = RequestMethod.DELETE)
    public ResponseEntity<TipoBebidaResponse> deletarTipoBebida(@PathVariable("tipoBebidaId") Long tipoBebidaId) {
        TipoBebidaResponse response = tipoBebidaService.removerTipoBebida(tipoBebidaId);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
