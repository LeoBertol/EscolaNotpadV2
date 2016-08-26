package br.escolanotpad.sc.mb;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.behavior.AjaxBehavior;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ComponentSystemEvent;

import br.escolanotpad.sc.model.ProvaRN;
import br.escolanotpad.sc.model.entity.Prova;
import br.escolanotpad.sc.model.entity.Turma;
import br.escolanotpad.sc.model.entity.Pergunta;

@ViewScoped
@ManagedBean
public class ProvaMB {
	private Prova prova;
	private ProvaRN provaRN;
	private Long editarId;
	private List<Prova> listaProvas;
	
	private Pergunta perguntaSelecionada;
	
	@PostConstruct
	public void initi(){
		provaRN = new ProvaRN();
		prova = new Prova();
		prova.setPerguntasProva(new ArrayList<Pergunta>());
	}
	
	public List<Prova> getListaProvas() {
		if (listaProvas == null){
			listaProvas = provaRN.listar();
		}
		return listaProvas;
	}
	
	public void setListaProvas(List<Prova> listaProvas) {
		this.listaProvas = listaProvas;
	}

	public void carregarEdicao(){
		if(editarId != null && !FacesContext.getCurrentInstance().getPartialViewContext().isAjaxRequest()){
			prova = provaRN.buscarPorId(editarId);
		}
	}
	
	
	public void excluirPergunta(AjaxBehaviorEvent event){
		Pergunta pergunta = (Pergunta) event.getComponent().getAttributes().get("idPergunta");
		prova.getPerguntasProva().remove(pergunta);
	}
	
	public String salvar() throws Throwable{
		try{
			provaRN.salvar(prova);
			listaProvas = null;
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Salvo", "Salvo Com Sucesso"));
			return "/prof/listaProva";
		} catch (IllegalArgumentException exception){
			exception.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro",exception.getMessage()));
		}catch (Exception e){
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", e.getMessage()));
		}
		return "";
	}
	
	public void carregarProva(ComponentSystemEvent event){
		if(editarId == null){
			return ;
		}
		
		prova = provaRN.buscarPorId(editarId);
	}
	
	public void adicionarPergunta(AjaxBehaviorEvent event){
		if(prova.getPerguntasProva().contains(perguntaSelecionada)){
			return;
		}
		prova.getPerguntasProva().add(perguntaSelecionada);
		perguntaSelecionada = null;
	}
	
	public String excluir(String id){
		Long idExcluir = Long.parseLong(id);
		provaRN.excluir(idExcluir);
		listaProvas = null;
		return "";
	}

	public Prova getProva() {
		return prova;
	}

	public void setProva(Prova prova) {
		this.prova = prova;
	}

	public ProvaRN getProvaRN() {
		return provaRN;
	}

	public void setProvaRN(ProvaRN provaRN) {
		this.provaRN = provaRN;
	}

	public Long getEditarId() {
		return editarId;
	}

	public void setEditarId(Long editarId) {
		this.editarId = editarId;
	}

	public Pergunta getPerguntaSelecionada() {
		return perguntaSelecionada;
	}

	public void setPerguntaSelecionada(Pergunta perguntaSelecionada) {
		this.perguntaSelecionada = perguntaSelecionada;
	}
	
	
	

}
