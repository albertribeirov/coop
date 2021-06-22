package br.com.cooperativa.ejb;

import br.com.cooperativa.model.Estoque;
import br.com.cooperativa.model.Log;
import br.com.cooperativa.model.Material;

import javax.ejb.Local;

@Local
public interface ControladorEstoqueMaterial {

    void inserirMaterialAndEstoqueInicialZerado(Material material) throws Exception;
    void persistir();
    void inserirQuantidadeMaterialEmEstoque(Estoque estoque) throws Exception;
    void inserirLog(Log log);
}
