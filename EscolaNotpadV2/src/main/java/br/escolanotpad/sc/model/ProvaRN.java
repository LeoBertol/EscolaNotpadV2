package br.escolanotpad.sc.model;

import java.sql.SQLException;
import java.util.List;

import br.escolanotpad.sc.dao.ProvaDAO;
import br.escolanotpad.sc.model.entity.Prova;

public class ProvaRN {
	
	private ProvaDAO dao;
	
	public ProvaRN(){
		dao = new ProvaDAO();
	}

	public void salvar(Prova prova) throws SQLException{
		dao.salvar(prova);
	}

	public Prova buscarPorId(Long id) {
		return dao.buscarPorId(id);
	}
	
	public List<Prova> listar(){
		return dao.listar();
	}
	
	public void excluir(Long id) {
		dao.excluir(id);
	}
	
}
