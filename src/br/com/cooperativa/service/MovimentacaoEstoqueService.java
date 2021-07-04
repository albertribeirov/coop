package br.com.cooperativa.service;

import br.com.cooperativa.TipoMensagem;
import br.com.cooperativa.dao.MovimentacaoEstoqueDAO;
import br.com.cooperativa.ejb.ControladorEstoqueMaterial;
import br.com.cooperativa.model.MovimentacaoEstoque;

import javax.ejb.EJB;
import javax.inject.Inject;
import java.util.List;

public class MovimentacaoEstoqueService extends Service {

    @EJB
    private ControladorEstoqueMaterial controladorEstoqueMaterial;

    @Inject
    private MovimentacaoEstoqueDAO movimentacaoEstoqueDAO;

    @Inject
    private LogService logService;

    public MovimentacaoEstoque findById(Integer id) {
        return movimentacaoEstoqueDAO.findById(MovimentacaoEstoque.class, id);
    }

    public void inserir(MovimentacaoEstoque movimentacaoEstoque)  {
        try {

            movimentacaoEstoqueDAO.salvar(movimentacaoEstoque);
            logService.log(String.format("MovimentacaoEstoque inserida -> Material: %s, TipoMaterial: %s, Qtd: %d",
                    movimentacaoEstoque.getMaterial().getNome(),
                    movimentacaoEstoque.getTipoMaterial().getNome(),
                    movimentacaoEstoque.getQuantidade()
            ), TipoMensagem.INFO);

        } catch (RuntimeException exception) {
            rollbackTransaction();
            throw exception;
        }
    }

    public void atualizar(MovimentacaoEstoque movimentacaoEstoque) {
        try {

            movimentacaoEstoqueDAO.alterar(movimentacaoEstoque);
            logService.log(String.format("MovimentacaoEstoque alterada -> Material: %s, TipoMaterial: %s, Qtd: %d",
                    movimentacaoEstoque.getMaterial().getNome(),
                    movimentacaoEstoque.getTipoMaterial().getNome(),
                    movimentacaoEstoque.getQuantidade()
            ), TipoMensagem.INFO);


        } catch (RuntimeException exception) {
            rollbackTransaction();
            throw exception;
        }
    }

    public void excluir(Integer id) throws Exception {
        try {

            controladorEstoqueMaterial.removerMovimentacaoEstoque(id);
            logService.log("MovimentacaoEstoque excluída: " + id, TipoMensagem.INFO);

        } catch (RuntimeException exception) {
            throw exception;
        }
    }

    public List<MovimentacaoEstoque> listarMovimentacaoEstoques() {
        return movimentacaoEstoqueDAO.listarMovimentacoesEstoque();
    }

    public List<MovimentacaoEstoque> consultarMovimentacoesPorMaterialAndTipoMaterialAndTipoMovimentacao(MovimentacaoEstoque movimentacaoEstoque) {
        return movimentacaoEstoqueDAO.consultarMovimentacoesPorMaterialAndTipoMaterialAndTipoMovimentacao(movimentacaoEstoque);
    }
}
