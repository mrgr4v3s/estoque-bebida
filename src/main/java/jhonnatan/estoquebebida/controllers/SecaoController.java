package jhonnatan.estoquebebida.controllers;

import jhonnatan.estoquebebida.entities.payloads.SecaoPayload;
import jhonnatan.estoquebebida.entities.responses.SecaoResponse;
import jhonnatan.estoquebebida.interfaces.ISecaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/secao")
public class SecaoController {
    @Autowired
    private ISecaoService secaoService;

    @RequestMapping(value = "/bebida/entrada", method = RequestMethod.POST)
    @ResponseBody
    public SecaoResponse incluirBebidaSecao(@RequestBody SecaoPayload payload) {
        payload.isValid();
        return secaoService.inserirBebidaSecao(payload);
    }

    @RequestMapping(value = "/bebida/venda")
    @ResponseBody
    public SecaoResponse venderBebidaSecao (@RequestBody SecaoPayload payload) {
        payload.isValid();
        return null;
    }

    @RequestMapping(value = "/bebida", method = RequestMethod.POST)
    public SecaoResponse consultarBebidaSecao(@RequestBody SecaoPayload payload) {
        return secaoService.consultarBebidaSecao(payload);
    }
}
