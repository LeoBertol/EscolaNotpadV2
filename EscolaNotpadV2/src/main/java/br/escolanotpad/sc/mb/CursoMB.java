package br.escolanotpad.sc.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;

import br.escolanotpad.sc.model.CursoRN;
import br.escolanotpad.sc.model.entity.Curso;

@ManagedBean
public class CursoMB {
	private Curso curso;
	private CursoRN cursoRN;
	private Long editarId;
	private List<Curso> listaCursos;
	
	@PostConstruct
	public void initi(){
		cursoRN = new CursoRN();
		curso = new Curso();		
	}
	
	public List<Curso> getListaCursos() {
		if (listaCursos == null){
			listaCursos = cursoRN.listar();
		}
		return listaCursos;
	}
	
	public void setListaCursos(List<Curso> listaCursos) {
		this.listaCursos = listaCursos;
	}

	public String salvar() throws Throwable{
		if(editarId == null){
			cursoRN.salvar(curso);
			listaCursos = null;
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Curso cadastrado com sucesso!", "");
			FacesContext.getCurrentInstance().addMessage(null, message);
			curso = new Curso();
			return "";
		}else{
			cursoRN.salvar(curso);
			listaCursos = null;
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Curso atualizado com sucesso!", "");
			FacesContext.getCurrentInstance().addMessage(null, message);
			curso = new Curso();
			return "";
		}
		
	}
	
	public void carregarCurso(ComponentSystemEvent event){
		if(editarId == null){
			return ;
		}
		
		curso = cursoRN.buscarPorId(editarId);
	}
	
	public String excluir(String id){
		Long idExcluir = Long.parseLong(id);
		cursoRN.excluir(idExcluir);
		listaCursos = null;
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Curso removido com sucesso!", "");
		FacesContext.getCurrentInstance().addMessage(null, message);
		return "";
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public CursoRN getCursoRN() {
		return cursoRN;
	}

	public void setCursoRN(CursoRN cursoRN) {
		this.cursoRN = cursoRN;
	}

	public Long getEditarId() {
		return editarId;
	}

	public void setEditarId(Long editarId) {
		this.editarId = editarId;
	}
			
}
