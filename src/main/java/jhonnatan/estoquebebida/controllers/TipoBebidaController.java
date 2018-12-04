package jhonnatan.estoquebebida.controllers;

import jhonnatan.estoquebebida.entities.payloads.TipoBebidaPayload;
import jhonnatan.estoquebebida.entities.responses.TipoBebidaResponse;
import jhonnatan.estoquebebida.interfaces.ITipoBebidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tipo-bebida")
public class TipoBebidaController {
    @Autowired
    private ITipoBebidaService tipoBebidaService;

    @RequestMapping(value = "/{tipoBebidaId}", method = RequestMethod.GET)
    @ResponseBody
    public TipoBebidaResponse consultarTipoBebida(@PathVariable("tipoBebidaId") Long tipoBebidaId) {
        return tipoBebidaService.consultarTipoBebida(tipoBebidaId);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public TipoBebidaResponse criarTipoBebida(@RequestBody TipoBebidaPayload payload) {
        payload.isValid();
        return tipoBebidaService.criarTipoBebida(payload);
    }

    @RequestMapping(value = "/{tipoBebidaId}", method = RequestMethod.PUT)
    @ResponseBody
    public TipoBebidaResponse alterarTipoBebida(@PathVariable("tipoBebidaId") Long tipoBebidaId,
                                                @RequestBody TipoBebidaPayload payload) {
        return tipoBebidaService.alterarTipoBebida(tipoBebidaId, payload);
    }

    @RequestMapping(value = "/{tipoBebidaId}", method = RequestMethod.DELETE)
    @ResponseBody
    public TipoBebidaResponse deletarTipoBebida(@PathVariable("tipoBebidaId") Long tipoBebidaId) {
        return tipoBebidaService.removerTipoBebida(tipoBebidaId);
    }
}
