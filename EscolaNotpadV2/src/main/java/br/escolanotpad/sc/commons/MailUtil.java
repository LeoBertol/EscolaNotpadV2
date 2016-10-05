package br.escolanotpad.sc.commons;

import javax.mail.Session;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;

public abstract class MailUtil {
	
	private static Session configurarSessao(){
		Properties props = new Properties();
		//Parâmetros de configuração da conexão com o Hotmail
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.host", "smtp.live.com");
		props.put("mail.smtp.socketFactory.port", "587");
		props.put("mail.smtp.socketFactory.fallback", "false");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "587");
		
		Session session = Session.getDefaultInstance(props,
				new JavaMailAuthenticator());
		
		return session;
	}
	
	public static void enviarEmail(String para, String assunto, String mensagem) {
		Session session = configurarSessao();
		
		Message message = new MimeMessage(session);
		
		try {
			InternetAddress from = new InternetAddress("exemploenviosenai@hotmail.com");
			message.setFrom(from);
			
			InternetAddress[] to = InternetAddress.parse(para);
			message.setRecipients(Message.RecipientType.TO, to);
			
			message.setSubject(assunto);
			
			message.setText(mensagem);
			
			//Aqui o e-mail é enviado
			Transport.send(message);
			
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
