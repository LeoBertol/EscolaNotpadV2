package br.escolanotpad.sc.dao;

import java.util.Date;

import javax.persistence.EntityManager;

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
	public void salvaUsuarioTest() {
		UsuarioDAO dao = new UsuarioDAO(entityManager);
		Usuario usuarioSave = new Usuario(1l, "ROLE_ADMINISTRADOR", "João", "joao@joao.com.br", "123456abc", "rua joão da silva, 2424", "000.000.000-00", new Date(), null, null);
		
		JpaUtilTest.getInstancia().beginSession();
		dao.salvar(usuarioSave);
		JpaUtilTest.getInstancia().endSession();
		
		Usuario usuarioRecuperado = dao.buscarPorEmail("joao@joao.com.br");
		
		Assert.assertTrue(usuarioSave.equals(usuarioRecuperado));
	}
	

}
