package br.escolanotpad.sc.model;

import java.sql.SQLException;
import java.util.List;

import br.escolanotpad.sc.dao.CursoDAO;
import br.escolanotpad.sc.model.entity.Curso;

public class CursoRN {
	
	private CursoDAO dao;
	
	public CursoRN(){
		dao = new CursoDAO();
	}

	public void salvar(Curso curso) throws SQLException{
		dao.salvar(curso);
	}

	public Curso buscarPorId(Long id) {
		return dao.buscarPorId(id);
	}
	
	public List<Curso> listar(){
		return dao.listar();
	}
	
	public void excluir(Long id) {
		dao.excluir(id);
	}
	
}
