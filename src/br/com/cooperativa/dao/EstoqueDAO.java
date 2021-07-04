package br.com.cooperativa.dao;

import br.com.cooperativa.model.Estoque;

import java.util.List;

@SuppressWarnings("unchecked")
public class EstoqueDAO extends DAO {

    public static final String consultaEstoquePorIdMaterialAndIdTipoMaterial = "SELECT e from Estoque e WHERE e.material.id = :idMaterial AND e.tipoMaterial.id = :idTipoMaterial";
    public static final String consultaQuantidadeMaterialEstoque = "SELECT SUM(e.quantidadeEmKg) FROM Estoque e WHERE e.material.id = :id";
    public static final String consultarEstoquePorIdMaterial = "SELECT e FROM Estoque e WHERE e.material.id = :id";

    public List<Estoque> listarEstoque() {
        return criarQuery("SELECT e FROM Estoque e ORDER BY e.tipoMaterial.nome, e.material.nome")
                .getResultList();
    }

    public List<Estoque> consultarEstoquePorNomeMaterial(String nomeMaterial) {
        return criarQuery("SELECT e FROM Estoque e WHERE e.material.nome LIKE %:nome%")
                .setParameter(NOME, nomeMaterial).getResultList();
    }

    public List<Estoque> consultarEstoquePorNomeTipoMaterial(String nomeTipoMaterial) {
        return criarQuery("SELECT e FROM Estoque e WHERE e.nome LIKE %:nome%")
                .setParameter(NOME, nomeTipoMaterial).getResultList();
    }

    public Estoque consultarEstoquePorIdMaterial(Integer id) {
        return (Estoque) criarQuery(consultarEstoquePorIdMaterial)
                .setParameter(ID, id).getSingleResult();
    }

    public List<Estoque> existeMaterialEstoque(Integer idTipoMaterial) {
        return criarQuery("SELECT e FROM Estoque e WHERE e.tipoMaterial.id = :id")
                .setParameter(ID, idTipoMaterial).getResultList();
    }

    public List<Estoque> consultarMaterialPorNomeTipoMaterial(String nomeTipoMaterial) {
        return criarQuery("SELECT e FROM Estoque e WHERE e.tipoMaterial.nome = :nome")
                .setParameter(NOME, nomeTipoMaterial).getResultList();
    }

    public int deleteEstoqueByIdMaterial(Integer id) {
        return criarQuery("DELETE FROM Estoque e WHERE e.material.id = :id")
                .setParameter(ID, id).executeUpdate();
    }

}
