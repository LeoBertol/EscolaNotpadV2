package br.escolanotpad.sc.model;

import java.sql.SQLException;
import java.util.List;

import br.escolanotpad.sc.dao.RegraDAO;
import br.escolanotpad.sc.model.entity.Regra;

public class RegraRN {
	
	private RegraDAO dao;
	
	public RegraRN(){
		dao = new RegraDAO();
	}
	
	public List<Regra> listar(){
		return dao.listar();
	}
	
	public void salvar(Regra regra) throws SQLException{
		dao.salvar(regra);
	}
	
	public Regra buscarPorId(Long id){
		return dao.buscarPorId(id);
	}
	
	public void excluir(Long id){
		dao.excluir(id);
	}

}
