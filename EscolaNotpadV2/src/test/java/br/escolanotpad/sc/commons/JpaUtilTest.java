package br.escolanotpad.sc.commons;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtilTest {

	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private static JpaUtilTest instancia;

	private JpaUtilTest() {
	}

	public static JpaUtilTest getInstancia() {
		if (instancia == null) {
			instancia = new JpaUtilTest();
		}
		return instancia;
	}

	public EntityManagerFactory initEntityManagerFactory() {
		if (this.entityManagerFactory == null) {
			this.entityManagerFactory = Persistence.createEntityManagerFactory("hsqldb");
		}
		return this.entityManagerFactory;
	}

	public EntityManager getEntityManager() {
		if (this.entityManagerFactory != null && this.entityManagerFactory.isOpen() && (this.entityManager == null || !this.entityManager.isOpen())) {
			this.entityManager = this.entityManagerFactory.createEntityManager();
		}
		return this.entityManager;
	}

	public void closeEntityManager() {
		if (this.entityManager != null && this.entityManager.isOpen()) {
			this.entityManager.close();
		}
		this.entityManager = null;
	}

	public void closeEntityManagerFactory() {
		if (this.entityManagerFactory != null && this.entityManagerFactory.isOpen()) {
			this.entityManagerFactory.close();
		}
		this.entityManagerFactory = null;
	}

}
