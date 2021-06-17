package br.com.cooperativa.dao;

import br.com.cooperativa.model.Material;

import java.util.List;

@SuppressWarnings("unchecked")
public class MaterialDAO extends DAO {

    public List<Material> listarMateriais() {
        return criarQuery("SELECT m FROM Material m ORDER BY m.tipoMaterial.id, m.nome").getResultList();
    }

    public Material consultarMaterialPorNome(String nome) {
        String consulta = "SELECT m FROM Material m WHERE m.nome = :nome";
        return (Material) criarQuery(consulta).setParameter(NOME, nome).getSingleResult();
    }

    public boolean existeMaterialComNome(String nome) {
        String consulta = "SELECT m FROM Material m WHERE m.nome = :nome";
        return !criarQuery(consulta).setParameter(NOME, nome).getResultList().isEmpty();
    }

    public List<Material> consultarMaterialPorIdTipoMaterial(Integer idTipoMaterial) {
        String consulta = "SELECT m FROM Material m WHERE m.tipoMaterial.id = :id";
        return criarQuery(consulta).setParameter(ID, idTipoMaterial).getResultList();
    }

    public List<Material> consultarMaterialPorNomeTipoMaterial(String nomeTipoMaterial) {
        String consulta = "SELECT m FROM Material m WHERE m.tipoMaterial.nome = :nome";
        return criarQuery(consulta).setParameter(NOME, nomeTipoMaterial).getResultList();
    }

}
