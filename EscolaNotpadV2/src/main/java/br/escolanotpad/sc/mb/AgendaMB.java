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
import br.escolanotpad.sc.model.AmbienteRN;
import br.escolanotpad.sc.model.UsuarioRN;
import br.escolanotpad.sc.model.entity.Agenda;
import br.escolanotpad.sc.model.entity.Ambiente;
import br.escolanotpad.sc.model.entity.Usuario;

@ViewScoped
@ManagedBean
public class AgendaMB {
	
	private List<Agenda> listaAgendas;
	private AgendaRN agendaRN;
	private AmbienteRN ambienteRN;
	private UsuarioRN usuarioRN;
	private Agenda agenda;
	
	private Long editarId;
	
	private List<Usuario> listaProfessores;
	private List<Usuario> listaProfessoresArray;
	
	private List<Agenda> listaAgendaPorTurma;
	private List<Agenda> listaAgendaPorProfessor;
	
	

	@PostConstruct
	public void init(){
		agendaRN = new AgendaRN();
		ambienteRN = new AmbienteRN();
		agenda = new Agenda();
	}

	

	public List<Agenda> getListaAgendaPorTurma(String turmaId) {
		if(listaAgendaPorTurma == null){
			listaAgendaPorTurma = agendaRN.listaAgendaPorTurma(turmaId);
		}
		return listaAgendaPorTurma;
	}



	public void setListaAgendaPorTurma(List<Agenda> listaAgendaPorTurma) {
		this.listaAgendaPorTurma = listaAgendaPorTurma;
	}



	public List<Agenda> getListaAgendas() {
		if(listaAgendas == null){
			listaAgendas = agendaRN.listar();
		}
		return listaAgendas;
	}
	
	

	



	public List<Agenda> getListaAgendaPorProfessor(String professorId) {
		if(listaAgendaPorProfessor == null){
			listaAgendaPorProfessor = agendaRN.listaAgendaPorProfessor(professorId);
		}
		return listaAgendaPorProfessor;
	}



	public void setListaAgendaPorProfessor(List<Agenda> listaAgendaPorProfessor) {
		this.listaAgendaPorProfessor = listaAgendaPorProfessor;
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

	public String jaEstaLocada(String jaEstaOcupada){
		return "";
	}
	
	//Auto complete para professor
	public List<Usuario> completaProfessor(String query) {
		return agendaRN.listarParaAutoComplete(query);
	}
	
	public List<Agenda> agendaPorTurma(String turmaId) {
		return agendaRN.listaAgendaPorTurma(turmaId);
	}
	
	public List<Agenda> agendaPorProfessor(String professorId) {
		return agendaRN.listaAgendaPorProfessor(professorId);
	}
	
	

	public String salvar() throws SQLException{
	
		//Verifica a data de loca��o
		List<Agenda> dataVerificar = agendaRN.buscarPorData(agenda.getData());
		//Verificar a data e o ambiente de loca��o
		List<Agenda> ambienteVerificar = agendaRN.buscarPorAmbiente(agenda.getAmbiente().getId(),agenda.getData());
		//Verifica a data, ambiente, hora de inicio e de termino
		List<Agenda> horarioVerificar = agendaRN.buscarPorHorario(agenda.getAmbiente().getId(),agenda.getData(),agenda.getInicioDaAula(), agenda.getFimDaAula());
		
		
		if(dataVerificar.size() == 0){
			agendaRN.salvar(agenda);
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Agenda cadastrada com sucesso!", "");
			FacesContext.getCurrentInstance().addMessage(null, message);
			agenda = new Agenda();
			return "";
		}else{
			if(ambienteVerificar.size() == 0){
				agendaRN.salvar(agenda);
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Agenda cadastrada com sucesso!", "");
				FacesContext.getCurrentInstance().addMessage(null, message);
				agenda = new Agenda();
				return "";
			}else{
				
					FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Este ambiente, já esta reservado para a mesma hora, por favor, tente com o próximo horario disponível", "");
					FacesContext.getCurrentInstance().addMessage(null, message);
				
			}
			
		}
					
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
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Agenda removida com sucesso!", "");
		FacesContext.getCurrentInstance().addMessage(null, message);
		return"";
	}
	
	

    
	

}
