package br.com.cooperativa.ejb;

import br.com.cooperativa.exception.ValidationException;
import br.com.cooperativa.model.Estoque;
import br.com.cooperativa.model.Material;

import javax.ejb.Local;

@Local
public interface ControladorEstoqueMaterial {

    void inserirMaterialAndEstoqueInicialZerado(Material material) throws Exception;
    void inserirQuantidadeMaterialEmEstoque(Estoque estoque) throws Exception;
    void removerMovimentacaoEstoque(Integer id) throws ValidationException;
}
