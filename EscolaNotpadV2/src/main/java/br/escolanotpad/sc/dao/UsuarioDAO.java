package br.escolanotpad.sc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.escolanotpad.sc.model.entity.Usuario;

public class UsuarioDAO extends DAO {
	
	public UsuarioDAO(){
		
	}
	
	public UsuarioDAO(EntityManager entityManager) {
		super(entityManager);
	}
	
	public void salvar(Usuario usuario) {
		if (usuario.getId() == null) {
			getEM().persist(usuario);
		} else {
			getEM().merge(usuario);
		}
	}
	
	public Usuario buscarPorId(Long id){
		return getEM().find(Usuario.class, id);
	}
	
	public List<Usuario> listarUsuarios(){
		Query query = getEM().createQuery("From Usuario order by id desc", Usuario.class);
		return query.getResultList();
	}
	
	public void excluir(Long id){
		Usuario usuario = getEM().getReference(Usuario.class, id);
		getEM().remove(usuario);
	}
	
	public List<Usuario> listarProfessores(){
		Query query = getEM().createQuery("From Usuario where perfil = :perfil order by perfil", Usuario.class);
		query.setParameter("perfil", "ROLE_PROFESSOR");
		return query.getResultList();
	}
	
	public List<Usuario> listarAlunos(){
		Query query = getEM().createQuery("From Usuario where perfil = :perfil order by perfil", Usuario.class);
		query.setParameter("perfil", "ROLE_ALUNO");
		return query.getResultList();
	}
	
	public Usuario buscarPorEmail(String email) {
		Query query = getEM().createQuery("From Usuario u Where u.email = :email", Usuario.class);
		query.setParameter("email", email);
		try {
 			return (Usuario) query.getSingleResult();
 		} catch (NoResultException exceptio) {
 			return null;
 		}
	}
	
	public List<Usuario> listarAlunosCadastrados() {
		Query query = getEM().createQuery("From Usuario where perfil = :perfil order by perfil", Usuario.class);
		query.setParameter("perfil", "ROLE_ALUNO");
		return query.getResultList();
	}

	public List<Usuario> listarAdministradores() {
		Query query = getEM().createQuery("From Usuario where perfil = :perfil order by perfil", Usuario.class);
		query.setParameter("perfil", "ROLE_ADMINISTRADOR");
		return query.getResultList();
	}
	
		
}