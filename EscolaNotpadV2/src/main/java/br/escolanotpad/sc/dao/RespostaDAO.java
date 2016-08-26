package br.escolanotpad.sc.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.Query;

import br.escolanotpad.sc.model.entity.Resposta;

public class RespostaDAO extends DAO{

	public void salvar(Resposta resposta) throws SQLException{
		getEM().merge(resposta);
	}
	
	public Resposta buscarPorId(Long id){
		return getEM().find(Resposta.class, id);
	}
	
	public List<Resposta> listar(){
		Query query = getEM().createQuery("From Resposta order by id desc", Resposta.class);
		return query.getResultList();
	}
	
	public void excluir(Long id){
		Resposta resposta = getEM().getReference(Resposta.class, id);
		getEM().remove(resposta);
	}

	public List<Resposta> buscarPorIdDaPergunta(Long id){
		Query query = getEM().createQuery("From Resposta where pergunta = :pergunta", Resposta.class);
		query.setParameter("pergunta", id);
		return query.getResultList();
	}
	
}
