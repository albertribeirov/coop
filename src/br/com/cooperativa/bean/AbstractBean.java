package br.com.cooperativa.bean;

import br.com.cooperativa.TipoMensagem;
import br.com.cooperativa.service.LogService;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

public class AbstractBean implements Serializable {

    public static final String ERRO = "Erro";
    public static final String MESSAGE = "message";
    public static final String SUCESSO = "Sucesso";

    @Inject
    private LogService logService;

    protected void handleException(Exception exception) {
        try {
            exception.printStackTrace();
            logService.log(exception.getMessage(), TipoMensagem.ERRO);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    protected void addMessageToRequest(String mensagem) {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
                .getRequest();
        request.setAttribute(MESSAGE, mensagem);
    }

    protected String redirect(String outcome) {
        return outcome + "?faces-redirect=true";
    }

    protected void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().addMessage(MESSAGE, new FacesMessage(severity, summary, detail));
    }
}