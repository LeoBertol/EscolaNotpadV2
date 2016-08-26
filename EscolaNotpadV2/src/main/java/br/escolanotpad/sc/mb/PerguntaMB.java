package br.escolanotpad.sc.mb;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;

import br.escolanotpad.sc.model.PerguntaRN;
import br.escolanotpad.sc.model.RespostaRN;
import br.escolanotpad.sc.mb.RespostaMB;
import br.escolanotpad.sc.model.entity.Pergunta;
import br.escolanotpad.sc.model.entity.Resposta;
import br.escolanotpad.sc.model.entity.Usuario;

@ManagedBean
public class PerguntaMB {
	private Pergunta pergunta;
	private PerguntaRN perguntaRN;
	private Resposta resposta;
	private RespostaRN respostaRN;
	private RespostaMB respostaMB;
	private Long editarId;
	
	private List<Resposta> listaRespostas;
	private List<Pergunta> listaPerguntas;
	
	private Resposta respostaA;
	private Resposta respostaB;
	private Resposta respostaC;
	private Resposta respostaD;
	private Resposta respostaE;
	
	private List<Resposta> alternativasCorreta;

	@PostConstruct
	public void initi(){
		perguntaRN = new PerguntaRN();
		
		pergunta = new Pergunta();
		respostaA = new Resposta();
		respostaB = new Resposta();
		respostaC = new Resposta();
		respostaD = new Resposta();
		respostaE = new Resposta();
		pergunta.setAlternativasCorreta(new ArrayList<Resposta>());
	}
	
	public List<Pergunta> getListaPerguntas() {
		if (listaPerguntas == null){
			listaPerguntas = perguntaRN.listar();
		}
		return listaPerguntas;
	}
	
	public void setListaPerguntas(List<Pergunta> listaPerguntas) {
		this.listaPerguntas = listaPerguntas;
	}
	
	public void carregarEdicao(){
		if(editarId != null && !FacesContext.getCurrentInstance().getPartialViewContext().isAjaxRequest()){
			pergunta = perguntaRN.buscarPorId(editarId);
		}
	}
	
	public String salvar() throws Throwable{
		respostaA.setPergunta(pergunta);
		respostaB.setPergunta(pergunta);
		respostaC.setPergunta(pergunta);
		respostaD.setPergunta(pergunta);
		respostaE.setPergunta(pergunta);
		
		List<Resposta> addResposta;
		addResposta = new ArrayList<Resposta>();
		addResposta.add(respostaA);
		addResposta.add(respostaB);
		addResposta.add(respostaC);
		addResposta.add(respostaD);
		addResposta.add(respostaE);
		pergunta.setAlternativasCorreta(addResposta);
		try{
			perguntaRN.salvar(pergunta);
			listaPerguntas = null;
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Salvo", "Salvo Com Sucesso"));
			return "/prof/listaPergunta";
		} catch (IllegalArgumentException exception){
			exception.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro",exception.getMessage()));
		}catch (Exception e){
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", e.getMessage()));
		}
		return "";
	}
	
	public void carregarPergunta(ComponentSystemEvent event){
		if(editarId == null){
			return ;
		}
		pergunta = perguntaRN.buscarPorId(editarId);
		if(pergunta.getAlternativasCorreta() == null){
			return;
		}
		pergunta.getAlternativasCorreta();
		respostaA = pergunta.getAlternativasCorreta().get(0);
		respostaB = pergunta.getAlternativasCorreta().get(1);
		respostaC = pergunta.getAlternativasCorreta().get(2);
		respostaD = pergunta.getAlternativasCorreta().get(3);
		respostaE = pergunta.getAlternativasCorreta().get(4);
	}
	
	public String excluir(String id){
		Long idExcluir = Long.parseLong(id);
		perguntaRN.excluir(idExcluir);
		listaPerguntas = null;
		return "";
	}
	
	

	public Pergunta getPergunta() {
		return pergunta;
	}

	public void setPergunta(Pergunta pergunta) {
		pergunta = pergunta;
	}

	public PerguntaRN getPerguntaRN() {
		return perguntaRN;
	}

	public void setPerguntaRN(PerguntaRN perguntaRN) {
		perguntaRN = perguntaRN;
	}

	public Long getEditarId() {
		return editarId;
	}

	public void setEditarId(Long editarId) {
		this.editarId = editarId;
	}

	public Resposta getResposta() {
		return resposta;
	}

	public void setResposta(Resposta resposta) {
		this.resposta = resposta;
	}

	public RespostaRN getRespostaRN() {
		return respostaRN;
	}

	public void setRespostaRN(RespostaRN respostaRN) {
		this.respostaRN = respostaRN;
	}

	public Resposta getRespostaA() {
		return respostaA;
	}

	public void setRespostaA(Resposta respostaA) {
		this.respostaA = respostaA;
	}

	public Resposta getRespostaB() {
		return respostaB;
	}

	public void setRespostaB(Resposta respostaB) {
		this.respostaB = respostaB;
	}

	public Resposta getRespostaC() {
		return respostaC;
	}

	public void setRespostaC(Resposta respostaC) {
		this.respostaC = respostaC;
	}

	public Resposta getRespostaD() {
		return respostaD;
	}

	public void setRespostaD(Resposta respostaD) {
		this.respostaD = respostaD;
	}

	public Resposta getRespostaE() {
		return respostaE;
	}

	public void setRespostaE(Resposta respostaE) {
		this.respostaE = respostaE;
	}

	public List<Resposta> getAlternativasCorreta() {
		return alternativasCorreta;
	}

	public void setAlternativasCorreta(List<Resposta> alternativasCorreta) {
		this.alternativasCorreta = alternativasCorreta;
	}

	public RespostaMB getRespostaMB() {
		return respostaMB;
	}

	public void setRespostaMB(RespostaMB respostaMB) {
		this.respostaMB = respostaMB;
	}

	public List<Resposta> getListaRespostas() {
		return listaRespostas;
	}

	public void setListaRespostas(List<Resposta> listaRespostas) {
		this.listaRespostas = listaRespostas;
	}
	
	
}
