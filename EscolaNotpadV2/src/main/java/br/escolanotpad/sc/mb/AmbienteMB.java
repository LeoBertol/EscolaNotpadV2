package br.escolanotpad.sc.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.escolanotpad.sc.model.AmbienteRN;
import br.escolanotpad.sc.model.entity.Ambiente;

@ManagedBean
public class AmbienteMB {
	private List<Ambiente> listaAmbientes;
	private AmbienteRN ambienteRN;
	private Ambiente ambiente;
	private Long editarId;
	private List<Ambiente> listaAmbientesCadastrados;
	private int tamanho;
	
	@PostConstruct
	public void init(){
		ambienteRN = new AmbienteRN();
		ambiente = new Ambiente();		
	}
	
	public List<Ambiente> getListaAmbientes() {
		if(listaAmbientes == null){
			listaAmbientes = ambienteRN.listar();
		}
		return listaAmbientes;
	}
	
	public void setListaAmbientes(List<Ambiente> listaAmbientes) {
		this.listaAmbientes = listaAmbientes;
	}
	public AmbienteRN getAmbienteRN() {
		return ambienteRN;
	}
	public void setAmbienteRN(AmbienteRN ambienteRN) {
		this.ambienteRN = ambienteRN;
	}
	public Ambiente getAmbiente() {
		return ambiente;
	}
	public void setAmbiente(Ambiente ambiente) {
		this.ambiente = ambiente;
	}
	
	public Long getEditarId() {
		return editarId;
	}

	public void setEditarId(Long editarId) {
		this.editarId = editarId;
	}
	
	public List<Ambiente> getListaAmbientesCadastrados() {
		return listaAmbientesCadastrados;
	}

	public void setListaAmbientesCadastrados(List<Ambiente> listaAmbientesCadastrados) {
		this.listaAmbientesCadastrados = listaAmbientesCadastrados;
	}

	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

	public void carregarEdicao(){
		if(editarId != null && !FacesContext.getCurrentInstance().getPartialViewContext().isAjaxRequest()){
			ambiente = ambienteRN.buscarPorId(editarId);
		}		
	}
	
	public String voltarRelatorios(){
		return "/admin/relatorios";
	}
	
	public String ambientesCadastrados(){
		listaAmbientesCadastrados = ambienteRN.listar();
		tamanho = listaAmbientesCadastrados.size();
		return "/admin/resultadoRelatorioAmbientes";
	}
	
	public String salvar() throws Throwable{
		if(editarId == null){
			ambienteRN.salvar(ambiente);
			listaAmbientes = null;
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Ambiente cadastrado com sucesso!", "");
			FacesContext.getCurrentInstance().addMessage(null, message);
			ambiente = new Ambiente();
			return "";
		}else{
			ambienteRN.salvar(ambiente);
			listaAmbientes = null;
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Ambiente atualizado com sucesso!", "");
			FacesContext.getCurrentInstance().addMessage(null, message);
			ambiente = new Ambiente();
			return "";
		}
	}
	
	public String excluir(String id){
		Long idExcluir = Long.parseLong(id);
		ambienteRN.excluir(idExcluir);
		listaAmbientes = null;
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Ambiente removido com sucesso!", "");
		FacesContext.getCurrentInstance().addMessage(null, message);
		return"";
	}
	
	
	

}
