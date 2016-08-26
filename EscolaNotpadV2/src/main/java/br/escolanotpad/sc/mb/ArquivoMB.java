package br.escolanotpad.sc.mb;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;

import br.escolanotpad.sc.commons.CompartilhamentoDeArquivoUtil;
import br.escolanotpad.sc.model.ArquivoRN;
import br.escolanotpad.sc.model.entity.Arquivo;
import br.escolanotpad.sc.model.entity.Turma;
import br.escolanotpad.sc.model.entity.Usuario;

@ViewScoped
@ManagedBean
public class ArquivoMB {
	private List<Arquivo> listaArquivos;
	private ArquivoRN arquivoRN;
	private Arquivo arquivo;
	private Part arquivoUploaded;
	private Long editarId;	
	private Usuario usuarioQueUplou;
	private Turma turma;
		
	@PostConstruct
	public void init(){
		arquivoRN = new ArquivoRN();
		arquivo = new Arquivo();
		turma = new Turma();
	}

	public List<Arquivo> getListaArquivos() {
		if (listaArquivos == null){
			listaArquivos = arquivoRN.listar();
		}
		return listaArquivos;
	}
	
	public void setListaArquivos(List<Arquivo> listaArquivos) {
		this.listaArquivos = listaArquivos;
	}

	public ArquivoRN getArquivoRN() {
		return arquivoRN;
	}
	
	public void setArquivoRN(ArquivoRN arquivoRN) {
		this.arquivoRN = arquivoRN;
	}

	public Arquivo getArquivo() {
		return arquivo;
	}

	public void setArquivo(Arquivo arquivo) {
		this.arquivo = arquivo;
	}
	
	public Part getArquivoUploaded() {
		return arquivoUploaded;
	}

	public void setArquivoUploaded(Part arquivoUploaded) {
		this.arquivoUploaded = arquivoUploaded;
	}

	public Long getEditarId() {
		return editarId;
	}

	public void setEditarId(Long editarId) {
		this.editarId = editarId;
	}
	
	public Usuario getUsuarioQueUplou() {
		return usuarioQueUplou;
	}

	public void setUsuarioQueUplou(Usuario usuarioQueUplou) {
		this.usuarioQueUplou = usuarioQueUplou;
	}
	
	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public void carregarEdicao(){
		if(editarId != null && !FacesContext.getCurrentInstance().getPartialViewContext().isAjaxRequest()){
			arquivo = arquivoRN.buscarPorId(editarId);
		}		
	}
	
	public String salvar() throws Throwable{
		try {
			String arquivoSendoUploaded = CompartilhamentoDeArquivoUtil.moverArquivo(arquivoUploaded, arquivo.getNomeArquivo());
			
			arquivo.setNomeArquivo(arquivoSendoUploaded);
			arquivoRN.salvar(arquivo);
			listaArquivos = null;
						
			return "listaArquivo";
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
	}
	
	public String excluir(String id){
		
		Long idExcluir = Long.parseLong(id);		
		Arquivo arquivo = arquivoRN.buscarPorId(idExcluir);		
		CompartilhamentoDeArquivoUtil.removerArquivo(arquivo.getNomeArquivo());						
		arquivoRN.excluir(idExcluir);
		listaArquivos = null;				
		return "listaArquivo";	
		
	}	
	
	
	
}
