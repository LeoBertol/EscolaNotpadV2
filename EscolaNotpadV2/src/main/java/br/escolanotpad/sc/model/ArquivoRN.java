package br.escolanotpad.sc.model;

import java.sql.SQLException;
import java.util.List;

import br.escolanotpad.sc.dao.ArquivoDAO;
import br.escolanotpad.sc.model.entity.Arquivo;

public class ArquivoRN {
	
	private ArquivoDAO dao;
	
	public ArquivoRN(){
		dao = new ArquivoDAO();
	}
		
	public List<Arquivo> listar(){
		return dao.listar();
	}
	
	public void salvar(Arquivo arquivo) throws SQLException{
		dao.salvar(arquivo);
	}
	
	public Arquivo buscarPorId(Long id) {
		return dao.buscarPorId(id);
	}

	public void excluir(Long id) {
		dao.excluir(id);		
	}
	

}
