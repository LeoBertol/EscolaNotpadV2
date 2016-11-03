package br.escolanotpad.sc.mb;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ComponentSystemEvent;

import br.escolanotpad.sc.model.TurmaRN;
import br.escolanotpad.sc.model.entity.Curso;
import br.escolanotpad.sc.model.entity.Turma;
import br.escolanotpad.sc.model.entity.Usuario;

@ManagedBean
public class TurmaMB {
	private List<Turma> listaTurmas;
	private List<Turma> listaTurmasUsuario;
	private TurmaRN turmaRN;
	private Turma turma;
	private Usuario usuarioLogado;	
	private Long editarId;
	private Usuario alunoSelecionado;
	private List<Turma> listaTurmasCadastradas;
	private int tamanho;
	
	@PostConstruct
	public void init(){
		turmaRN = new TurmaRN();
		turma = new Turma();
		turma.setAlunosTurma(new ArrayList<Usuario>());
	}

	public List<Turma> getListaTurmas() {
		if (listaTurmas == null){
			listaTurmas = turmaRN.listar();
		}
		return listaTurmas;
	}

	public void setListaTurmas(List<Turma> listaTurmas) {
		this.listaTurmas = listaTurmas;
	}
	
	public Long getIdUsuarioLogado(){
		return usuarioLogado ==  null ? null: usuarioLogado.getId();
	}
		
	public List<Turma> getListaTurmasUsuario(Long usuarioLogado) {		
		if (listaTurmas == null){
			listaTurmasUsuario = turmaRN.listarTurmaPorUsuario(usuarioLogado);
		}		
		return listaTurmasUsuario;
	}

	public void setListaTurmasUsuario(List<Turma> listaTurmasUsuario) {
		this.listaTurmasUsuario = listaTurmasUsuario;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	
	public Usuario getAlunoSelecionado() {
		return alunoSelecionado;
	}

	public void setAlunoSelecionado(Usuario alunoSelecionado) {
		this.alunoSelecionado = alunoSelecionado;
	}
	
	public Long getEditarId() {
		return editarId;
	}

	public void setEditarId(Long editarId) {
		this.editarId = editarId;
	}
	
	public List<Turma> getListaTurmasCadastradas() {
		return listaTurmasCadastradas;
	}

	public void setListaTurmasCadastradas(List<Turma> listaTurmasCadastradas) {
		this.listaTurmasCadastradas = listaTurmasCadastradas;
	}

	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

	public void carregarEdicao(){
		if(editarId != null && !FacesContext.getCurrentInstance().getPartialViewContext().isAjaxRequest()){
			turma = turmaRN.buscarPorId(editarId);
		}
	}
	
	public String voltarRelatorios(){
		return "/admin/relatorios";
	}
	
	public String turmasCadastradas(){
		listaTurmasCadastradas = turmaRN.listar();
		tamanho = listaTurmasCadastradas.size();
		return "/admin/resultadoRelatorioTurmas";
	}
	
	public void adicionarAluno(AjaxBehaviorEvent event){
		if(turma.getAlunosTurma().contains(alunoSelecionado)){
			return;
		}
		turma.getAlunosTurma().add(alunoSelecionado);
		alunoSelecionado = null;
	}
	
	public void excluirAluno(AjaxBehaviorEvent event){
		Usuario aluno = (Usuario) event.getComponent().getAttributes().get("idAluno");
		turma.getAlunosTurma().remove(aluno);
	}
	
	public String salvar() throws Throwable{
		if(editarId == null){
			turmaRN.salvar(turma);
			listaTurmas = null;
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Turma cadastrada com sucesso!", "");
			FacesContext.getCurrentInstance().addMessage(null, message);
			turma = new Turma();
			return "";
		} else{
			turmaRN.salvar(turma);
			listaTurmas = null;
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Turma atualizada com sucesso!", "");
			FacesContext.getCurrentInstance().addMessage(null, message);
			turma = new Turma();
			return "";
		}
	}
		
	public void carregarTurma(ComponentSystemEvent event){
		if(editarId == null){
			return ;
		}
		
		turma = turmaRN.buscarPorId(editarId);
	}
	
	public String excluir(String id){
		Long idExcluir = Long.parseLong(id);
		turmaRN.excluir(idExcluir);
		listaTurmas = null;
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Turma removida com sucesso!", "");
		FacesContext.getCurrentInstance().addMessage(null, message);
		return "";
	}
	
	public TurmaRN getTurmaRN() {
		return turmaRN;
	}

	public void setTurmaRN(TurmaRN turmaRN) {
		this.turmaRN = turmaRN;
	}

}
