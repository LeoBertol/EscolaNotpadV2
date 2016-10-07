package br.escolanotpad.sc.dao;

import javax.persistence.EntityManager;

import br.escolanotpad.sc.commons.JpaUtil;

public abstract class DAO {
	
	private EntityManager entityManager = null;

	public DAO() {
		super();
	}
	
	public DAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	protected EntityManager getEM() {
		if (this.entityManager == null) {
			return JpaUtil.getEntityManager();
		}
		return this.entityManager;
	}

}
