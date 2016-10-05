package br.escolanotpad.sc.commons;

import br.escolanotpad.sc.commons.MailUtil;

public class TesteEmail {

	public static void main(String[] args) {
		String texto = "Boa Noite!\n\nEsta mensagem está sendo enviada pelo Java.\n\nAtenciosamente,\nJava";
		MailUtil.enviarEmail("guilherme.bertol@hotmail.com", "Exemplo de Aula", texto);
		System.out.println("Email enviado!");
	}
	
}