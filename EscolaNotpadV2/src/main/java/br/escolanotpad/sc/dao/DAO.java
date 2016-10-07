package br.escolanotpad.sc.dao;

import javax.persistence.EntityManager;

import br.escolanotpad.sc.commons.JpaUtil;

public abstract class DAO {

	public DAO() {
		super();
	}

	protected EntityManager getEM() {
		return getEM(null);
	}

	protected EntityManager getEM(EntityManager entityManager) {
		if (entityManager == null) {
			return JpaUtil.getEntityManager();
		}
		return entityManager;
	}

}
