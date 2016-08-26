package br.escolanotpad.sc.commons;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.Part;

public class CompartilhamentoDeArquivoUtil {

	private static final Map<String, String> TIPOS_PERMITIDOS = new HashMap<String, String>();
	private static final String PASTA_UPLOADS = "/resources/compartilhamentoDeArquivo/";
	
	static{
		TIPOS_PERMITIDOS.put("image/jpeg",".jpg");
		TIPOS_PERMITIDOS.put("image/png",".png");
		TIPOS_PERMITIDOS.put("image/gif",".gif");
		TIPOS_PERMITIDOS.put("application/pdf", ".pdf");		
	}
	
	public static String moverArquivo(Part arquivoUploaded, String arquivoAntigo) throws IOException{
		if(arquivoUploaded == null){
			return arquivoAntigo;
		}
		
		String nome = gerarNome(arquivoUploaded);
		
		String caminhoAbsoluto = getCaminhoAbsoluto(nome);
		
		arquivoUploaded.write(caminhoAbsoluto);
		
		removerArquivo(arquivoAntigo);
		
		return nome;
		
	}
	
	private static String getCaminhoAbsoluto(String nome){
		ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance()
				.getExternalContext().getContext();
		return servletContext.getRealPath(PASTA_UPLOADS.concat(nome));
	}
	
	private static String gerarNome(Part uploadedDeArquivo){
		if(!TIPOS_PERMITIDOS.containsKey(uploadedDeArquivo.getContentType())){
			return null;
		}
		
		String novoNome = UUID.randomUUID().toString();
		return novoNome.concat(TIPOS_PERMITIDOS.get(uploadedDeArquivo.getContentType()));
				
	}
	
	public static void removerArquivo(String nome){
		if(nome == null || nome.isEmpty()){
			return;
		}
		
		String caminhoAbsoluto = getCaminhoAbsoluto(nome);
		
		File file = new File(caminhoAbsoluto);
		if(file.exists()){
			file.delete();
		}
		
	}
	
	
}
