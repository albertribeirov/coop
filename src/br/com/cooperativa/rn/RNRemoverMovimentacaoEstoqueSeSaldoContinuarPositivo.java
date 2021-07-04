package br.com.cooperativa.rn;

import br.com.cooperativa.dao.EstoqueDAO;
import br.com.cooperativa.exception.ValidationException;
import br.com.cooperativa.model.Estoque;
import br.com.cooperativa.model.MovimentacaoEstoque;
import org.hibernate.ObjectNotFoundException;

import javax.persistence.EntityManager;
import java.util.Objects;

import static br.com.cooperativa.dao.DAO.ID;

public class RNRemoverMovimentacaoEstoqueSeSaldoContinuarPositivo {

    private static RNRemoverMovimentacaoEstoqueSeSaldoContinuarPositivo regraDeNegocio = new RNRemoverMovimentacaoEstoqueSeSaldoContinuarPositivo();

    public static RNRemoverMovimentacaoEstoqueSeSaldoContinuarPositivo getInstance() {
        if (regraDeNegocio == null) {
            regraDeNegocio = new RNRemoverMovimentacaoEstoqueSeSaldoContinuarPositivo();
        }
        return regraDeNegocio;
    }

    public void executar(Integer id, EntityManager entityManager) throws ValidationException {
        Integer totalEstoque = 0;
        MovimentacaoEstoque movimentacao = entityManager.find(MovimentacaoEstoque.class, id);

        if (Objects.nonNull(movimentacao)) {
            totalEstoque = (Integer) entityManager.createQuery(EstoqueDAO.consultaQuantidadeMaterialEstoque)
                    .setParameter(ID, id)
                    .getSingleResult();
        } else {
            throw new ObjectNotFoundException(id, "Movimentação não encontrada");
        }

        if (movimentacao.getQuantidade() > totalEstoque) {
            throw new ValidationException("A movimentação não pode ser excluída porque o saldo do material ficaria negativo");
        }

        Estoque estoque = (Estoque) entityManager.createQuery(EstoqueDAO.consultarEstoquePorIdMaterial)
                .setParameter(ID, movimentacao.getMaterial().getId())
                .getSingleResult();

        estoque.setQuantidadeEmKg(estoque.getQuantidadeEmKg() - movimentacao.getQuantidade());

        entityManager.merge(estoque);
        entityManager.remove(movimentacao);
    }
}
