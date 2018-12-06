package jhonnatan.estoquebebida.controllers;

import jhonnatan.estoquebebida.entities.payloads.HistoricoPayload;
import jhonnatan.estoquebebida.entities.responses.HistoricoResponse;
import jhonnatan.estoquebebida.interfaces.IHistoricoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/historico")
public class HistoricoController {
    @Autowired
    private IHistoricoService historicoService;

    @RequestMapping(value = "/bebida", method = RequestMethod.POST)
    public ResponseEntity<HistoricoResponse> consultarHistoricoPorBebida(@RequestBody HistoricoPayload payload) {
        HistoricoResponse response = historicoService.consultaHistoricoPorBebida(payload);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/secao", method = RequestMethod.POST)
    public ResponseEntity<HistoricoResponse> consultarPorSecao(@RequestBody HistoricoPayload payload) {
        HistoricoResponse response = historicoService.consultaHistoricoPorSecao(payload);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
