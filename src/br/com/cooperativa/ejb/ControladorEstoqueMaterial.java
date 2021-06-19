package br.com.cooperativa.ejb;

import br.com.cooperativa.model.Material;

import javax.ejb.Local;

@Local
public interface ControladorEstoqueMaterial {

    void inserirMaterialAndEstoqueInicialZerado(Material material) throws Exception;
}
