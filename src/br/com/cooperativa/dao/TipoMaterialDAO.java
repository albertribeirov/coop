package br.com.cooperativa.dao;

import br.com.cooperativa.model.TipoMaterial;

import javax.persistence.Query;
import java.util.List;

@SuppressWarnings("unchecked")
public class TipoMaterialDAO extends DAO {

    public List<TipoMaterial> listarTiposMaterial() {
        return criarQuery("SELECT tm FROM TipoMaterial tm").getResultList();
    }

    public TipoMaterial consultarTipoMaterialPorNome(String nome) {
        String consulta = "SELECT tm FROM TipoMaterial tm WHERE tm.nome = :nome";
        return (TipoMaterial) criarQuery(consulta).setParameter(NOME, nome).getSingleResult();
    }

    public boolean existeTipoMaterialComNome(String nome) {
        String consulta = "SELECT tm FROM TipoMaterial tm WHERE tm.nome = :nome";
        Query query =  criarQuery(consulta).setParameter(NOME, nome);
        return !query.getResultList().isEmpty();
    }

}
