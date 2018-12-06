package jhonnatan.estoquebebida.controllers;

import jhonnatan.estoquebebida.entities.payloads.SecaoPayload;
import jhonnatan.estoquebebida.entities.responses.SecaoResponse;
import jhonnatan.estoquebebida.interfaces.ISecaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/secao")
public class SecaoController {
    @Autowired
    private ISecaoService secaoService;

    @RequestMapping(value = "/bebida/entrada", method = RequestMethod.POST)
    public ResponseEntity<SecaoResponse> incluirBebidaSecao(@RequestBody SecaoPayload payload) {
        payload.isValid();

        SecaoResponse response = secaoService.inserirBebidaSecao(payload);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/bebida/venda")
    public ResponseEntity<SecaoResponse> venderBebidaSecao(@RequestBody SecaoPayload payload) {
        payload.isValid();

        SecaoResponse response = secaoService.venderBebidaSecao(payload);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/bebida", method = RequestMethod.POST)
    public ResponseEntity<SecaoResponse> consultarBebidaSecao(@RequestBody SecaoPayload payload) {
        SecaoResponse response = secaoService.consultarBebidaSecao(payload);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
