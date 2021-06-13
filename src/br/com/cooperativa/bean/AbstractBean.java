package br.com.cooperativa.bean;

import br.com.cooperativa.model.Log.TipoMensagem;
import br.com.cooperativa.service.LogService;

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

	/**
	 * Faz o log de erro da exceção no banco de dados e imprime a stack trace no
	 * console.
	 * 
	 * @param exception Exceção ocorrida
	 */
	protected void handleException(Exception exception) {
		try {
			exception.printStackTrace();
			logService.log(exception.toString(), TipoMensagem.ERRO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Adiciona uma mensagem ao request para ser exibida na tela.
	 */
	protected void addMessageToRequest(String mensagem) {
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
		request.setAttribute(MESSAGE, mensagem);
	}

	/**
	 * Usa faces-redirect para atualizar a tela.
	 */
	protected String redirect(String outcome) {
		return outcome + "?faces-redirect=true";
	}
}