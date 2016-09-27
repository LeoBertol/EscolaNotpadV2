package br.escolanotpad.sc.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.Query;

import br.escolanotpad.sc.model.entity.Agenda;
import br.escolanotpad.sc.model.entity.Perfil;
import br.escolanotpad.sc.model.entity.Usuario;

public class AgendaDAO extends DAO{
	
	public void salvar(Agenda agenda) throws SQLException{
		getEM().merge(agenda);
	}
	
	public Agenda buscarPorId(Long id){
		return getEM().find(Agenda.class, id);
	}
	
	public List<Agenda> listar(){
		Query query = getEM().createQuery("From Agenda order by id desc", Agenda.class);
		return query.getResultList();
	}
	
	public void excluir(Long id){
		Agenda agenda = getEM().getReference(Agenda.class, id);
		getEM().remove(agenda);
	}
	
	public List<Usuario> listarParaAutoComplete(String busca) {
		Query query = getEM().createQuery("From Usuario where perfil = :perfil order by perfil", Usuario.class);
		query.setParameter("perfil", "ROLE_PROFESSOR");
		return query.getResultList();
	}

}
