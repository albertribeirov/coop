package br.com.cooperativa.ejb;

import br.com.cooperativa.model.Cooperado;

import javax.ejb.Local;

@Local
public interface ControladorCooperado {

    Cooperado inserirCooperado(Cooperado cooperado);
    Cooperado alterarCooperado(Cooperado cooperado);
}
