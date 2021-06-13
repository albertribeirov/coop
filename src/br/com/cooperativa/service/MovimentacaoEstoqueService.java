package br.com.cooperativa.service;

import br.com.cooperativa.TipoMensagem;
import br.com.cooperativa.dao.MovimentacaoEstoqueDAO;
import br.com.cooperativa.model.MovimentacaoEstoque;

import javax.inject.Inject;
import java.util.List;

public class MovimentacaoEstoqueService extends Service {

    @Inject
    private MovimentacaoEstoqueDAO movimentacaoEstoqueDAO;

    @Inject
    private LogService logService;

    /**
     * Carrega um movimentacaoEstoque cadastrado no banco de dados.
     *
     * @param id  Id da MovimentacaoEstoque que ser� buscada no banco de dados
     */
    public MovimentacaoEstoque findById(Integer id) {
        return movimentacaoEstoqueDAO.findById(MovimentacaoEstoque.class, id);
    }

    /**
     * Insere um novo MovimentacaoEstoque no banco de dados
     *
     * @param movimentacaoEstoque MovimentacaoEstoque a ser inserido
     */
    public void inserir(MovimentacaoEstoque movimentacaoEstoque)  {
        try {

            movimentacaoEstoqueDAO.salvar(movimentacaoEstoque);
            logService.log(String.format("MovimentacaoEstoque inserida -> Material: %s, TipoMaterial: %s, Qtd: %d",
                    movimentacaoEstoque.getMaterial().getNome(),
                    movimentacaoEstoque.getTipoMaterial().getNome(),
                    movimentacaoEstoque.getQuantidade()
            ), TipoMensagem.INFO);

        } catch (RuntimeException e) {
            rollbackTransaction();
            throw e;
        }
    }

    /**
     * Alter um MovimentacaoEstoque cadastrado no banco de dados.
     *
     * @param movimentacaoEstoque MovimentacaoEstoque que ser� alterado
     */
    public void atualizar(MovimentacaoEstoque movimentacaoEstoque) {
        try {

            movimentacaoEstoqueDAO.alterar(movimentacaoEstoque);
            logService.log(String.format("MovimentacaoEstoque alterada -> Material: %s, TipoMaterial: %s, Qtd: %d",
                    movimentacaoEstoque.getMaterial().getNome(),
                    movimentacaoEstoque.getTipoMaterial().getNome(),
                    movimentacaoEstoque.getQuantidade()
            ), TipoMensagem.INFO);


        } catch (RuntimeException e) {
            rollbackTransaction();
            throw e;
        }
    }

    /**
     * Exclui um MovimentacaoEstoque do banco de dados
     *
     * @param id N�mero de matr�cula do MovimentacaoEstoque a ser exclu�do
     */
    public void excluir(Integer id) {
        try {
            beginTransaction();

            MovimentacaoEstoque movimentacaoEstoque = movimentacaoEstoqueDAO.findById(MovimentacaoEstoque.class, id);
            movimentacaoEstoqueDAO.excluir(movimentacaoEstoque);
            logService.log("MovimentacaoEstoque exclu�da: " + id, TipoMensagem.INFO);

            commitTransaction();

        } catch (RuntimeException e) {
            rollbackTransaction();
            throw e;
        }
    }

    /**
     * L� todos os Apartamentos cadastrados no banco de dados
     *
     * @return Lista de Condom�nios cadastrados
     */
    public List<MovimentacaoEstoque> listarMovimentacaoEstoques() {
        return movimentacaoEstoqueDAO.listarMovimentacoesEstoque();
    }
}
