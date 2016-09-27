package br.escolanotpad.sc.mb;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.escolanotpad.sc.model.AgendaRN;
import br.escolanotpad.sc.model.UsuarioRN;
import br.escolanotpad.sc.model.entity.Agenda;
import br.escolanotpad.sc.model.entity.Usuario;

@ViewScoped
@ManagedBean
public class AgendaMB {
	
	private List<Agenda> listaAgendas;
	private AgendaRN agendaRN;
	private UsuarioRN usuarioRN;
	private Agenda agenda;
	
	private Long editarId;
	
	private List<Usuario> listaProfessores;
	private List<Usuario> listaProfessoresArray;
	
	@PostConstruct
	public void init(){
		agendaRN = new AgendaRN();
		agenda = new Agenda();
	}

	public List<Agenda> getListaAgendas() {
		if(listaAgendas == null){
			listaAgendas = agendaRN.listar();
		}
		return listaAgendas;
	}

	public void setListaAgendas(List<Agenda> listaAgendas) {
		this.listaAgendas = listaAgendas;
	}

	public AgendaRN getAgendaRN() {
		return agendaRN;
	}

	public void setAgendaRN(AgendaRN agendaRN) {
		this.agendaRN = agendaRN;
	}

	public Agenda getAgenda() {
		return agenda;
	}

	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}

	
	
	public Long getEditarId() {
		return editarId;
	}

	public void setEditarId(Long editarId) {
		this.editarId = editarId;
	}

	
	
	//Auto complete para professor
	public List<Usuario> completaProfessor(String query) {
		return agendaRN.listarParaAutoComplete(query);
	}
	
	public String salvar() throws SQLException{
		agendaRN.salvar(agenda);
		listaAgendas = null;
		return "";
	}
	
	public void carregarEdicao(){
		if(editarId != null && !FacesContext.getCurrentInstance().getPartialViewContext().isAjaxRequest()){
			agenda = agendaRN.buscarPorId(editarId);
		}
	}
	
	public String excluir(String id){
		Long idExcluir = Long.parseLong(id);
		agendaRN.excluir(idExcluir);
		listaAgendas = null;
		return"";
	}
	

    
	

}
