package br.escolanotpad.sc.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.Query;

import br.escolanotpad.sc.model.entity.Regra;

public class RegraDAO extends DAO{
	
	public void salvar(Regra regra) throws SQLException{
		getEM().merge(regra);
	}	
	
	public Regra buscarPorId(long id){
		return getEM().find(Regra.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Regra> listar(){
		Query query = getEM().createQuery("select r from regra r", Regra.class);
		return query.getResultList();
	}
	
	public void excluir(Long id){
		Regra regra = getEM().getReference(Regra.class, id);
		getEM().remove(regra);
	}
	
}
