package br.com.cooperativa.service;

import br.com.cooperativa.TipoMensagem;
import br.com.cooperativa.dao.EstoqueDAO;
import br.com.cooperativa.ejb.ControladorEstoqueMaterial;
import br.com.cooperativa.exception.ValidationException;
import br.com.cooperativa.model.Estoque;

import javax.ejb.EJB;
import javax.inject.Inject;
import java.util.List;
import java.util.Objects;

public class EstoqueService extends Service {

    @EJB
    private ControladorEstoqueMaterial controladorEstoqueMaterial;

    @Inject
    private EstoqueDAO EstoqueDAO;

    @Inject
    private LogService logService;

    public Estoque consultarEstoquePorId(Integer id) {
        return EstoqueDAO.findById(Estoque.class, id);
    }

    public List<Estoque> consultarEstoquePorNomeMaterial(String nome) {
        return EstoqueDAO.consultarEstoquePorNomeMaterial(nome);
    }

    public List<Estoque> consultarMaterialPorNomeTipoMaterial(String nome) {
        return EstoqueDAO.consultarMaterialPorNomeTipoMaterial(nome);
    }

    public List<Estoque> listarEstoque() {
        return EstoqueDAO.listarEstoque();
    }

    public void inserir(Estoque estoque) throws Exception {

        if (Objects.isNull(estoque.getMaterial())) {
            throw new ValidationException("O material não foi informado");
        }

        if (estoque.getQuantidadeEmKg() < 0 || estoque.getQuantidadeEmKg() > 9999)  {
            throw new ValidationException("A quantidade informada é inválida");
        }

        controladorEstoqueMaterial.inserirQuantidadeMaterialEmEstoque(estoque);

    }

    public void atualizar(Estoque estoque) throws ValidationException {
        try {
            beginTransaction();

//            if (estoqueDAO.existeEstoqueComNome(Estoque.getNome())) {
//                // TODO Verificar excecoes
//                throw new ValidationException(Constantes.MSG_ERRO_EXISTE_COOPERADO_NOME);
//            }

            EstoqueDAO.alterar(estoque);
            logService.log("Estoque alterado: " + estoque.getId(), TipoMensagem.INFO);

            commitTransaction();

        } catch (RuntimeException e) {
            rollbackTransaction();
            throw e;
        }
    }

    public void excluir(Integer id) {
        try {
            beginTransaction();

            Estoque Estoque = EstoqueDAO.findById(Estoque.class, id);
            EstoqueDAO.excluir(Estoque);
            logService.log("Estoque excluído: " + id, TipoMensagem.INFO);

            commitTransaction();

        } catch (RuntimeException e) {
            rollbackTransaction();
            throw e;
        }
    }

}
