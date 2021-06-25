package br.com.cooperativa.service;


import br.com.cooperativa.TipoMensagem;
import br.com.cooperativa.dao.LogDAO;
import br.com.cooperativa.model.Log;

import javax.inject.Inject;
import java.time.LocalDateTime;

public class LogService extends Service {

    @Inject
    private LogDAO logDAO;

    public void log(String mensagem, TipoMensagem tipoMensagem) {
        logDAO.salvar(new Log(LocalDateTime.now(), tipoMensagem, mensagem));
    }
}