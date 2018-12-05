package jhonnatan.estoquebebida.controllers;

import jhonnatan.estoquebebida.entities.responses.SecaoDisponivelResponse;
import jhonnatan.estoquebebida.entities.responses.VolumeTotalResponse;
import jhonnatan.estoquebebida.interfaces.IEstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/estoque")
public class EstoqueController {

    @Autowired
    private IEstoqueService estoqueService;

    @RequestMapping(value = "/volume", method = RequestMethod.GET)
    @ResponseBody
    public List<VolumeTotalResponse> consultarVolumeTotalTipoBebidaSecao() {
        return estoqueService.consultarVolumeTotalTipoBebidaSecao();
    }

    @RequestMapping(value = "/tipo-bebida/{tipoBebidaId}/entrada", method = RequestMethod.GET)
    @ResponseBody
    public List<SecaoDisponivelResponse> consultarSecaoDisponivelEntrada(@PathVariable("tipoBebidaId") Long tipoBebidaId) {
        return estoqueService.consultarSecaoDisponivelEntrada(tipoBebidaId);
    }

    @RequestMapping(value = "/tipo-bebida/{tipoBebidaId}/venda", method = RequestMethod.GET)
    @ResponseBody
    public List<SecaoDisponivelResponse> consultarSecaoDisponivelVenda(@PathVariable("tipoBebidaId") Long tipoBebidaId) {
        return estoqueService.consultarSecaoDisponivelVenda(tipoBebidaId);
    }
}
