package jhonnatan.estoquebebida.controllers;

import jhonnatan.estoquebebida.entities.Secao;
import jhonnatan.estoquebebida.entities.responses.SecaoDisponivelResponse;
import jhonnatan.estoquebebida.entities.responses.SecaoResponse;
import jhonnatan.estoquebebida.entities.responses.VolumeTotalResponse;
import jhonnatan.estoquebebida.interfaces.IEstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/estoque")
public class EstoqueController {

    @Autowired
    private IEstoqueService estoqueService;

    @RequestMapping(value = "/volume", method = RequestMethod.GET)
    public ResponseEntity<List<VolumeTotalResponse>> consultarVolumeTotalTipoBebidaSecao() {
        List<VolumeTotalResponse> response = estoqueService.consultarVolumeTotalTipoBebidaSecao();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/tipo-bebida/{tipoBebidaId}/entrada", method = RequestMethod.GET)
    public ResponseEntity<List<SecaoDisponivelResponse>> consultarSecaoDisponivelEntrada(@PathVariable("tipoBebidaId") Long tipoBebidaId) {
        List<SecaoDisponivelResponse> response = estoqueService.consultarSecaoDisponivelEntrada(tipoBebidaId);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/tipo-bebida/{tipoBebidaId}/venda", method = RequestMethod.GET)
    public ResponseEntity<List<SecaoDisponivelResponse>> consultarSecaoDisponivelVenda(@PathVariable("tipoBebidaId") Long tipoBebidaId) {
        List<SecaoDisponivelResponse> response = estoqueService.consultarSecaoDisponivelVenda(tipoBebidaId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
