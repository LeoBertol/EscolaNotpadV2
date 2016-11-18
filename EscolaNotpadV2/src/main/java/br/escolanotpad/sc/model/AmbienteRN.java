package br.escolanotpad.sc.model;

import java.sql.SQLException;
import java.util.List;

import br.escolanotpad.sc.dao.AmbienteDAO;
import br.escolanotpad.sc.model.entity.Ambiente;

public class AmbienteRN {
	
	private AmbienteDAO dao;
	
	public AmbienteRN(){
		dao = new AmbienteDAO();
	}
	
	public List<Ambiente> listar(){
		return dao.listar();
	}
	
	public void salvar(Ambiente ambiente) throws SQLException{
		dao.salvar(ambiente);
	}
	
	public Ambiente buscarPorId(Long id) {
		return dao.buscarPorId(id);
	}

	public void excluir(Long id) {
		dao.excluir(id);		
	}

}
