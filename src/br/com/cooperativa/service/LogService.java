package br.com.cooperativa.service;


import br.com.cooperativa.TipoMensagem;
import br.com.cooperativa.dao.LogDAO;
import br.com.cooperativa.model.Log;

import javax.inject.Inject;
import java.time.LocalDateTime;

public class LogService extends Service {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Inject
    private LogDAO logDAO;

    /**
     * Insere uma nova mensagem de log no banco de dados
     *
     * @param mensagem Mensagem de log
     * @param tipoMensagem Enum de tipo da mensagem
     */
    public void log(String mensagem, TipoMensagem tipoMensagem) {
        try {
            beginTransaction();

            Log log = new Log();
            log.setData(LocalDateTime.now());
            log.setTipoMensagem(tipoMensagem);
            log.setMensagem(mensagem);
            logDAO.salvar(log);

            commitTransaction();

        } catch (RuntimeException e) {
            rollbackTransaction();
            throw e;
        }
    }
}