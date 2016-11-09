package br.escolanotpad.sc.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
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
		Usuario usuarioSave = new Usuario(1l, "ROLE_ADMINISTRADOR", "Usuario Teste 01", "salvarUsuario@test.com.br", 
				"123456abc", "rua dos testes, 0102", "000.000.000-00", new Date(), null);
		
		JpaUtilTest.getInstancia().beginSession();
		dao.salvar(usuarioSave);
		JpaUtilTest.getInstancia().endSession();
		
		Usuario usuarioRecuperado = dao.buscarPorEmail("salvarUsuario@test.com.br");
		
		Assert.assertTrue(usuarioSave.equals(usuarioRecuperado));
	}
	
	@Test
	public void salvarUsuarioComIdNuloTest(){
		UsuarioDAO dao = new UsuarioDAO(entityManager);
		Usuario usuarioSave = new Usuario(null, "ROLE_ADMINISTRADOR", "Usuario Teste 02", "salvarUsuarioComIdNulo@test.com.br", 
				"123456abc", "rua dos testes, 0102", "000.000.000-00", new Date(), null);
		
		JpaUtilTest.getInstancia().beginSession();
		dao.salvar(usuarioSave);
		JpaUtilTest.getInstancia().endSession();
				
		Usuario usuarioRecuperado = dao.buscarPorEmail("salvarUsuarioComIdNulo@test.com.br");
		Assert.assertEquals(usuarioSave, usuarioRecuperado);
	}	
	
	@Test
	public void listarUsuariosTest(){
		UsuarioDAO dao = new UsuarioDAO(entityManager);
		Usuario usuarioSave = new Usuario(2l, "ROLE_ADMINISTRADOR", "Usuario Teste 03", "listarUsuarios@test.com.br", 
				"123456abc", "rua dos testes, 0102", "000.000.000-00", new Date(), null);
		
		JpaUtilTest.getInstancia().beginSession();
		dao.salvar(usuarioSave);
		JpaUtilTest.getInstancia().endSession();
		
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
	public void listarAdministradoresTest(){
		UsuarioDAO dao = new UsuarioDAO(entityManager);
		dao.listarAdministradores();
	}

	@Test
	public void listarAlunosCadastrados(){
		UsuarioDAO dao = new UsuarioDAO(entityManager);
		dao.listarAlunosCadastrados();
	}
	
	@Test
	public void buscarPorEmailCatch(){
		String resultadoEsperado = null;
		UsuarioDAO dao = new UsuarioDAO(entityManager);
		
		Usuario usuarioRecuperado = dao.buscarPorEmail(null);
		
		Assert.assertEquals(resultadoEsperado, usuarioRecuperado);
	}
	
	@Test
	public void buscarPorIdTest(){
		UsuarioDAO dao = new UsuarioDAO(entityManager);
		
		Usuario usuarioSave = new Usuario(3l, "ROLE_ADMINISTRADOR", "Usuario Teste 04", "buscarPorId@test.com.br", 
				"123456abc", "rua dos testes, 0102", "000.000.000-00", new Date(), null);
		
		JpaUtilTest.getInstancia().beginSession();
		dao.salvar(usuarioSave);
		JpaUtilTest.getInstancia().endSession();
		
		Usuario usuarioRecuperadoComId = dao.buscarPorId(usuarioSave.getId());
			
		Assert.assertTrue(usuarioSave.equals(usuarioRecuperadoComId));	
	}
		
	@Test
	public void excluirUsuarioTest(){
		UsuarioDAO dao = new UsuarioDAO(entityManager);
		Usuario usuarioSave = new Usuario(4l, "ROLE_ADMINISTRADOR", "Usuario Teste 05", "excluirUsuario@test.com.br", 
				"123456abc", "rua dos testes, 0102", "000.000.000-00", new Date(), null);
		
		JpaUtilTest.getInstancia().beginSession();
		dao.salvar(usuarioSave);
		JpaUtilTest.getInstancia().endSession();
		
		Usuario usuarioRecuperado = dao.buscarPorEmail("excluirUsuario@test.com.br");
				
		JpaUtilTest.getInstancia().beginSession();
		dao.excluir(4l);
		JpaUtilTest.getInstancia().endSession();
		
		Assert.assertTrue(usuarioSave.equals(usuarioRecuperado));				
	}
	

}














