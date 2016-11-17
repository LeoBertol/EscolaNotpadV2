package br.escolanotpad.sc.dao;

import java.util.Date;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import br.escolanotpad.sc.commons.JpaUtilTest;
import br.escolanotpad.sc.model.entity.Usuario;

public class UsuarioDAOTest {

	private EntityManager entityManager;

	@BeforeClass
	public static void initClass() {
		JpaUtilTest.getInstancia().initEntityManagerFactory();
	}
	
	@AfterClass
	public static void finishClass() {
		JpaUtilTest.getInstancia().closeEntityManagerFactory();
	}

	@Before
	public void initTest() {
		entityManager = JpaUtilTest.getInstancia().getEntityManager();
	}

	@After
	public void finishTest() {
		JpaUtilTest.getInstancia().closeEntityManager();
	}

	@Test
	public void entityManagerByUsuarioDaoIsNotNullTest() {
		Assert.assertNotNull(entityManager);
	}

	@Test
	public void entityManagerByUsuarioDaoIsNullTest() {
		entityManager = null;
		Assert.assertNull(entityManager);
	}
	
	@Test
	public void construtorVaziuTest(){
		UsuarioDAO dao = new UsuarioDAO();
	}
	
	@Test
	public void salvaUsuarioTest() {
		UsuarioDAO dao = new UsuarioDAO(entityManager);
		Usuario usuarioSave = new Usuario(1l, "ROLE_ADMINISTRADOR", "Usuario Teste", "salvarUsuario@test.com.br", 
				"123456abc", "rua dos testes, 0102", "000.000.000-00", new Date(), null);
		
		Usuario usuarioSave2 = new Usuario(2l, "ROLE_ADMINISTRADOR", "Usuario Teste 02", "excluirUsuario@test.com.br", 
				"123456abc", "rua dos testes, 0102", "000.000.000-00", new Date(), null);
		
		JpaUtilTest.getInstancia().beginSession();
		dao.salvar(usuarioSave);
		dao.salvar(usuarioSave2);
		JpaUtilTest.getInstancia().endSession();
	}
		
	@Test
	public void salvarUsuarioComIdNuloTest(){
		UsuarioDAO dao = new UsuarioDAO(entityManager);
		Usuario usuarioSave = new Usuario(null, "ROLE_ADMINISTRADOR", "Usuario Teste 01", "salvarUsuarioComIdNulo@test.com.br", 
				"123456abc", "rua dos testes, 0102", "000.000.000-00", new Date(), null);
		
		JpaUtilTest.getInstancia().beginSession();
		dao.salvar(usuarioSave);
		JpaUtilTest.getInstancia().endSession();
	}	
			
	@Test
	public void listarUsuariosTest(){
		UsuarioDAO dao = new UsuarioDAO(entityManager);
		dao.listarUsuarios();							
	}
			
	@Test
	public void listarProfessoresTest(){
		UsuarioDAO dao = new UsuarioDAO(entityManager);
		dao.listarProfessores();
	}
	
	@Test
	public void listarAlunosTest(){
		UsuarioDAO dao = new UsuarioDAO(entityManager);
		dao.listarAlunos();
	}
	
	@Test
	public void listarAlunosCadastrados(){
		UsuarioDAO dao = new UsuarioDAO(entityManager);
		dao.listarAlunosCadastrados();
	}
		
	@Test
	public void listarAdministradoresTest(){
		UsuarioDAO dao = new UsuarioDAO(entityManager);
		dao.listarAdministradores();
	}
	
	@Test
	public void buscarPorIdTest(){
		UsuarioDAO dao = new UsuarioDAO(entityManager);		
		Usuario usuarioRecuperado = dao.buscarPorId(1l);
	}
	
	@Test
	public void buscarPorEmailTeste(){
		UsuarioDAO dao = new UsuarioDAO(entityManager);		
		Usuario usuarioRecuperado = dao.buscarPorEmail("salvarUsuario@test.com.br");	
	}	
		
	@Test@Ignore
	public void excluirUsuarioTest(){
		UsuarioDAO dao = new UsuarioDAO(entityManager);
		Usuario usuarioSave4 = new Usuario(4l, "ROLE_ADMINISTRADOR", "Usuario Teste 05", "excluirUsuario@test.com.br", 
				"123456abc", "rua dos testes, 0102", "000.000.000-00", new Date(), null);
		
		JpaUtilTest.getInstancia().beginSession();
		dao.salvar(usuarioSave4);
		dao.excluir(4l);
		JpaUtilTest.getInstancia().endSession();
		
		Assert.assertFalse(usuarioSave4.equals(null));	
	}
	
}














