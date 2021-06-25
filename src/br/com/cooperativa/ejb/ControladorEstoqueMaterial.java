package br.com.cooperativa.ejb;

import br.com.cooperativa.model.Estoque;
import br.com.cooperativa.model.Log;
import br.com.cooperativa.model.Material;
import br.com.cooperativa.model.TipoMaterial;

import javax.ejb.Local;

@Local
public interface ControladorEstoqueMaterial {

    void inserirMaterialAndEstoqueInicialZerado(Material material) throws Exception;
    void inserirQuantidadeMaterialEmEstoque(Estoque estoque) throws Exception;
}
