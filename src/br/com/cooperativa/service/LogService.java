package br.com.cooperativa.service;


import br.com.cooperativa.TipoMensagem;
import br.com.cooperativa.dao.LogDAO;
import br.com.cooperativa.ejb.ControladorEstoqueMaterial;
import br.com.cooperativa.model.Log;

import javax.ejb.EJB;
import javax.inject.Inject;
import java.time.LocalDateTime;

public class LogService extends Service {

    @EJB
    private ControladorEstoqueMaterial controladorEstoqueMaterial;

    public void log(String mensagem, TipoMensagem tipoMensagem) {
        controladorEstoqueMaterial.inserirLog(new Log(LocalDateTime.now(), tipoMensagem, mensagem));
    }
}