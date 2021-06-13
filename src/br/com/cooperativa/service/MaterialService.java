package br.com.cooperativa.service;

import br.com.cooperativa.TipoMensagem;
import br.com.cooperativa.dao.MaterialDAO;
import br.com.cooperativa.exception.ValidationException;
import br.com.cooperativa.model.Material;
import br.com.cooperativa.util.Constantes;

import javax.inject.Inject;
import java.util.List;

public class MaterialService extends Service {

    @Inject
    private MaterialDAO materialDAO;

    @Inject
    private LogService logService;

    public Material consultarMaterialPorId(Integer id) {
        return materialDAO.findById(Material.class, id);
    }

    public Material consultarMaterialPorNome(String nome) {
        return materialDAO.consultarMaterialPorNome(nome);
    }

    public List<Material> consultarMaterialPorIdTipoMaterial(Integer id) {
        return materialDAO.consultarMaterialPorIdTipoMaterial(id);
    }

    public List<Material> consultarMaterialPorNomeTipoMaterial(String nome) {
        return materialDAO.consultarMaterialPorNomeTipoMaterial(nome);
    }

    public List<Material> listarMateriais() {
        return materialDAO.listarMateriais();
    }

    /**
     * Insere um novo Material no banco de dados
     *
     * @param material Material a ser inserido
     * @throws ValidationException Exceção de validação
     */
    public void inserir(Material material) throws ValidationException {
        try {
            beginTransaction();

            if (materialDAO.existeMaterialComNome(material.getNome())) {
                throw new ValidationException(Constantes.MSG_ERRO_EXISTE_COOPERADO_NOME);
            }

            materialDAO.salvar(material);
            logService.log("Material inserido: " + material.getNome(), TipoMensagem.INFO);

            commitTransaction();

        } catch (RuntimeException e) {
            rollbackTransaction();
            throw e;
        }
    }

    /**
     * Alter um Material cadastrado no banco de dados.
     *
     * @param material Material que será alterado
     * @throws ValidationException Exceção de validação
     */
    public void atualizar(Material material) throws ValidationException {
        try {
            beginTransaction();

            if(materialDAO.existeMaterialComNome(material.getNome())) {
                // TODO Verificar excecoes
                throw new ValidationException(Constantes.MSG_ERRO_EXISTE_COOPERADO_NOME);
            }

            materialDAO.alterar(material);
            logService.log("Material alterado: " + material.getId(), TipoMensagem.INFO);

            commitTransaction();

        } catch (RuntimeException e) {
            rollbackTransaction();
            throw e;
        }
    }

    /**
     * Exclui um Material do banco de dados
     *
     * @param id Número de matrícula do Material a ser excluído
     */
    public void excluir(Integer id) {
        try {
            beginTransaction();

            Material material = materialDAO.findById(Material.class, id);
            materialDAO.excluir(material);
            logService.log("Material excluído: " + id, TipoMensagem.INFO);

            commitTransaction();

        } catch (RuntimeException e) {
            rollbackTransaction();
            throw e;
        }
    }

}
