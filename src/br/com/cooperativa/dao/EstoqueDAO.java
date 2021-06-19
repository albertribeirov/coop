package br.com.cooperativa.dao;

import br.com.cooperativa.model.Estoque;

import java.util.List;

@SuppressWarnings("unchecked")
public class EstoqueDAO extends DAO {

    public List<Estoque> listarEstoque() {
        return criarQuery("SELECT e FROM Estoque e ORDER BY e.tipoMaterial.nome, e.material.nome").getResultList();
    }

    public List<Estoque> consultarEstoquePorNomeMaterial(String nomeMaterial) {
        String consulta = "SELECT e FROM Estoque e WHERE e.material.nome LIKE %:nome%";
        return criarQuery(consulta).setParameter(NOME, nomeMaterial).getResultList();
    }

    public List<Estoque> consultarEstoquePorNomeTipoMaterial(String nomeTipoMaterial) {
        String consulta = "SELECT e FROM Estoque e WHERE e.nome LIKE %:nome%";
        return criarQuery(consulta).setParameter(NOME, nomeTipoMaterial).getResultList();
    }

    public Estoque consultarEstoquePorIdMaterial(Integer id) {
        String consulta = "SELECT e FROM Estoque e WHERE e.nome LIKE %:id%";
        return (Estoque) criarQuery(consulta).setParameter(ID, id).getSingleResult();
    }

    public List<Estoque> existeMaterialEstoque(Integer idTipoMaterial) {
        String consulta = "SELECT e FROM Estoque e WHERE e.tipoMaterial.id = :id";
        return criarQuery(consulta).setParameter(ID, idTipoMaterial).getResultList();
    }

    public List<Estoque> consultarMaterialPorNomeTipoMaterial(String nomeTipoMaterial) {
        String consulta = "SELECT e FROM Estoque e WHERE e.tipoMaterial.nome = :nome";
        return criarQuery(consulta).setParameter(NOME, nomeTipoMaterial).getResultList();
    }

    public int deleteEstoqueByIdMaterial(Integer id) {
        return criarQuery("DELETE FROM Estoque e WHERE e.material.id = :id").setParameter(ID, id).executeUpdate();
    }

}
