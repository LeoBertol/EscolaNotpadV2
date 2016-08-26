package br.escolanotpad.sc.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;

import br.escolanotpad.sc.model.RespostaRN;
import br.escolanotpad.sc.model.entity.Resposta;

@ManagedBean
public class RespostaMB {
	private Resposta Resposta;
	private RespostaRN RespostaRN;
	private Long editarId;
	private List<Resposta> listaRespostas;
	
	private Resposta respostaA;
	private Resposta respostaB;
	private Resposta respostaC;
	private Resposta respostaD;
	private Resposta respostaE;
	
	@PostConstruct
	public void initi(){
		RespostaRN = new RespostaRN();
		Resposta = new Resposta();
		respostaA = new Resposta();
		respostaB = new Resposta();
		respostaC = new Resposta();
		respostaD = new Resposta();
		respostaE = new Resposta();
	}
	
	public List<Resposta> getListaRespostas() {
		if (listaRespostas == null){
			listaRespostas = RespostaRN.listar();
			respostaA = getListaRespostas().get(0);
			respostaB = getListaRespostas().get(1);
			respostaC = getListaRespostas().get(2);
			respostaD = getListaRespostas().get(3);
			respostaE = getListaRespostas().get(4);
		}
		return listaRespostas;
	}
	
	public void setListaRespostas(List<Resposta> listaRespostas) {
		this.listaRespostas = listaRespostas;
	}

	public String salvar() throws Throwable{
		RespostaRN.salvar(respostaA);
		listaRespostas = null;
		return "/prof/listaResposta";
	}
	
	public void carregarResposta(ComponentSystemEvent event){
		if(editarId == null){
			return ;
		}
		
		Resposta = RespostaRN.buscarPorId(editarId);
	}
	
	public List<Resposta> carregarRespostaPorIdPergunta(Long editarId){
		listaRespostas = RespostaRN.buscarPorIdDaPergunta(editarId);
		return listaRespostas;
	}
	
	public String excluir(String id){
		Long idExcluir = Long.parseLong(id);
		RespostaRN.excluir(idExcluir);
		listaRespostas = null;
		return "";
	}

	public Resposta getResposta() {
		return Resposta;
	}

	public void setResposta(Resposta resposta) {
		Resposta = resposta;
	}

	public RespostaRN getRespostaRN() {
		return RespostaRN;
	}

	public void setRespostaRN(RespostaRN respostaRN) {
		RespostaRN = respostaRN;
	}

	public Long getEditarId() {
		return editarId;
	}

	public void setEditarId(Long editarId) {
		this.editarId = editarId;
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
	

}
