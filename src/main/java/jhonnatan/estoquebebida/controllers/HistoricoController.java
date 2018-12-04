package jhonnatan.estoquebebida.controllers;

import jhonnatan.estoquebebida.entities.payloads.HistoricoPayload;
import jhonnatan.estoquebebida.entities.responses.HistoricoResponse;
import jhonnatan.estoquebebida.interfaces.IHistoricoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/historico")
public class HistoricoController {
    @Autowired
    private IHistoricoService historicoService;

    @RequestMapping(value = "/bebida", method = RequestMethod.POST)
    @ResponseBody
    public HistoricoResponse consultarHistoricoPorBebida(@RequestBody HistoricoPayload payload) {
        return historicoService.consultaHistoricoPorBebida(payload);
    }

    @RequestMapping(value = "/secao", method = RequestMethod.POST)
    @ResponseBody
    public HistoricoResponse consultarPorSecao(@RequestBody HistoricoPayload payload) {
        return historicoService.consultaHistoricoPorSecao(payload);
    }
}
