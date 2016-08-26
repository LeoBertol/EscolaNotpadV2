package br.escolanotpad.sc.model;

import java.util.List;

import br.escolanotpad.sc.dao.UsuarioDAO;
import br.escolanotpad.sc.model.entity.Usuario;

public class UsuarioRN {

	private UsuarioDAO dao;
	
	/*public void salvar(Usuario usuario){
	 * 	DaoFactory.getUsuarioDao().salvar(usuario);
	 * }
	 * 
	 * public Usuario buscarPorId(long id){
	 * 	return DaoFactory.getUsuarioDao().buscarPorId(id);
	 * }
	 * 
	 * public list<Usuario> listarTodos(){
	 * 	return DaoFactory.getUsuarioDao().listarTodos();
	 * }
	 * 
	 * public void excluir(long id){
	 * 	DaoFactory.getUsuarioDao().excluir(id);
	 * }
	 * 
	 */

	public UsuarioRN() {
		dao = new UsuarioDAO();
	}

	public void salvar(Usuario usuario) {
		dao.salvar(usuario);
	}

	public Usuario buscarPorId(Long id) {
		return dao.buscarPorId(id);
	}

	public List<Usuario> listarUsuarios() {
		return dao.listarUsuarios();
	}
	
	public void excluir(Long id) {
		dao.excluir(id);
	}
	
	public List<Usuario> listarAlunos() {
		return dao.listarAlunos();
	}
	
	public List<Usuario> listarProfessores() {
		return dao.listarProfessores();
	}
	
	public List<Usuario> listarAdministradores() {
		return dao.listarAdministradores();
	}
	
	public Usuario buscarPorEmail(String email) {
		return dao.buscarPorEmail(email);
	}

	public List<Usuario> listarAlunosCadastrados() {
		return dao.listarAlunosCadastrados();
	}
	
}
