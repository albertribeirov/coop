package br.com.cooperativa.rn;

import br.com.cooperativa.dao.EstoqueDAO;
import br.com.cooperativa.model.Estoque;
import br.com.cooperativa.model.MovimentacaoEstoque;

import javax.persistence.EntityManager;

public class RNIncluirMaterialEstoqueAndMovimentacaoEstoque {

    private static RNIncluirMaterialEstoqueAndMovimentacaoEstoque regraDeNegocio = new RNIncluirMaterialEstoqueAndMovimentacaoEstoque();

    public static RNIncluirMaterialEstoqueAndMovimentacaoEstoque getInstance() {
        if (regraDeNegocio == null) {
            regraDeNegocio = new RNIncluirMaterialEstoqueAndMovimentacaoEstoque();
        }
        return regraDeNegocio;
    }

    public void incluir(MovimentacaoEstoque movimentacaoEstoque, EstoqueDAO estoqueDAO, EntityManager entityManager) {

        try {
            Estoque estoque = estoqueDAO.consultarEstoquePorIdMaterial(movimentacaoEstoque.getMaterial().getId());
            estoque.setQuantidadeEmKg(estoque.getQuantidadeEmKg() + movimentacaoEstoque.getQuantidade().intValue());

            entityManager.persist(movimentacaoEstoque);
            entityManager.merge(estoque);

        } catch (Exception exception) {
            throw exception;
        }
    }
}
