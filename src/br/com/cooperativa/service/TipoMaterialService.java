package br.com.cooperativa.service;

import br.com.cooperativa.TipoMensagem;
import br.com.cooperativa.dao.TipoMaterialDAO;
import br.com.cooperativa.ejb.ControladorEstoqueMaterial;
import br.com.cooperativa.exception.ValidationException;
import br.com.cooperativa.model.Log;
import br.com.cooperativa.model.TipoMaterial;
import br.com.cooperativa.util.Constantes;

import javax.ejb.EJB;
import javax.inject.Inject;
import java.time.LocalDateTime;
import java.util.List;

public class TipoMaterialService extends Service {

    @Inject
    private TipoMaterialDAO tipoMaterialDAO;

    @Inject
    private LogService logService;

    public TipoMaterial findById(Integer id) {
        return tipoMaterialDAO.findById(TipoMaterial.class, id);
    }

    public TipoMaterial consultarTipoMaterialPorId(Integer id) {
        return tipoMaterialDAO.findById(TipoMaterial.class, id);
    }

    public TipoMaterial consultarMaterialPorNomeTipoMaterial(String nome) {
        return tipoMaterialDAO.consultarTipoMaterialPorNome(nome);
    }

    public List<TipoMaterial> listarTiposMaterial() {
        return tipoMaterialDAO.listarTiposMaterial();
    }

    public void inserir(TipoMaterial tipoMaterial) throws Exception {
        try {
            beginTransaction();

            if (tipoMaterialDAO.existeTipoMaterialComNome(tipoMaterial.getNome())) {
                throw new ValidationException(Constantes.MSG_ERRO_EXISTE_TIPO_MATERIAL_MESMO_NOME);
            }

            Integer idTipoMaterial = tipoMaterialDAO.salvar(tipoMaterial);
            logService.log("Inserido Tipo de Material de id: " + idTipoMaterial.toString(), TipoMensagem.INFO);
            commitTransaction();
        } catch (RuntimeException exception) {
            rollbackTransaction();
            throw exception;
        }
    }

    public void atualizar(TipoMaterial tipoMaterial) throws ValidationException {
        try {
            beginTransaction();

            if (tipoMaterialDAO.existeTipoMaterialComNome(tipoMaterial.getNome())) {
                throw new ValidationException(Constantes.MSG_ERRO_EXISTE_TIPO_MATERIAL_MESMO_NOME);
            }

            tipoMaterialDAO.alterar(tipoMaterial);
            logService.log("Alterado Tipo de Material de id: " + tipoMaterial.getId(), TipoMensagem.INFO);

            commitTransaction();

        } catch (RuntimeException exception) {
            rollbackTransaction();
            throw exception;
        }
    }

    public void excluir(Integer id) {
        try {
            beginTransaction();

            TipoMaterial material = tipoMaterialDAO.findById(TipoMaterial.class, id);
            tipoMaterialDAO.excluir(material);
            logService.log("Excluído Tipo de Material de id: " + id, TipoMensagem.INFO);

            commitTransaction();

        } catch (RuntimeException exception) {
            rollbackTransaction();
            throw exception;
        }
    }

}
