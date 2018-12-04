package jhonnatan.estoquebebida.entities.responses;

import jhonnatan.estoquebebida.entities.vo.HistoricoVo;

import java.util.List;

public class HistoricoResponse {
    private List<HistoricoVo> historicos;

    public HistoricoResponse(List<HistoricoVo> historicos) {
        this.historicos = historicos;
    }

    public List<HistoricoVo> getHistoricos() {
        return historicos;
    }

    public void setHistoricos(List<HistoricoVo> historicos) {
        this.historicos = historicos;
    }
}
