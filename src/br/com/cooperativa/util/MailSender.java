package br.com.cooperativa.util;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

public class MailSender {

	private static MailSender mailSender;
	private static String usuario = "";
	private static String senha = "";
	private static String destinatario = "";
	private static String remetente = "";
	private static String assunto = "";
	private static String corpoEmail = "";

	private MailSender() {

	}

	public static synchronized MailSender getInstance() {
		if (mailSender == null) {
			mailSender = new MailSender();
		}
		return mailSender;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		MailSender.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		MailSender.senha = senha;
	}

	public String getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(String destinatario) {
		MailSender.destinatario = destinatario;
	}

	public String getRemetente() {
		return remetente;
	}

	public void setRemetente(String remetente) {
		MailSender.remetente = remetente;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		MailSender.assunto = assunto;
	}

	public String getCorpoEmail() {
		return corpoEmail;
	}

	public void setCorpoEmail(String corpoEmail) {
		MailSender.corpoEmail = corpoEmail;
	}
	
	public Session autenticar(String usuario, String senha) {
		Properties props = new Properties();
		/* Parâmetros de conexão com servidor Gmail */
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		return Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(usuario, senha);
			}
		});
	}

	public void enviarEmail(
			String destinatario, 
			String assunto, 
			String corpoEmail,
			String caminhoArquivo, 
			String nomeArquivo,
			Session session) {

		// Ativa Debug para sessão
		// session.setDebug(true);

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("Lacqua")); // Remetente

			// Destinatários
			Address[] toUser = InternetAddress.parse(destinatario);

			message.setRecipients(Message.RecipientType.TO, toUser);
			message.setSubject(assunto);
			message.setText(corpoEmail);
			
			MimeBodyPart messageBodyPart = new MimeBodyPart();
			MimeMultipart multipart = new MimeMultipart();
			DataSource source = new FileDataSource(caminhoArquivo);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(nomeArquivo);
			multipart.addBodyPart(messageBodyPart);
			message.setContent(multipart);
			// Método para enviar a mensagem criada
			Transport.send(message);

		} catch (MessagingException exception) {
			throw new RuntimeException(exception);
		}
	}
}