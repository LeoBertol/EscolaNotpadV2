package br.escolanotpad.sc.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.Query;

import br.escolanotpad.sc.model.entity.Pergunta;

public class PerguntaDAO extends DAO{

	public void salvar(Pergunta pergunta) throws SQLException{
		getEM().merge(pergunta);
	}
	
	public Pergunta buscarPorId(Long id){
		return getEM().find(Pergunta.class, id);
	}
	
	public List<Pergunta> listar(){
		Query query = getEM().createQuery("From Pergunta order by id desc", Pergunta.class);
		return query.getResultList();
	}
	
	public void excluir(Long id){
		Pergunta pergunta = getEM().getReference(Pergunta.class, id);
		getEM().remove(pergunta);
	}
	
}
