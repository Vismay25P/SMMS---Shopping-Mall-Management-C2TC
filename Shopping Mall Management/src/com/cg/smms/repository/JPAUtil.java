package com.cg.smms.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	private static EntityManagerFactory factory;
	private static EntityManager entityManager;

//	Static Block execute first
	static {
		factory = Persistence.createEntityManagerFactory("JPA-PU");
	}

	public static EntityManager getEntityManager() {
//		if(true OR true)
		if (entityManager == null || entityManager.isOpen()) {
			entityManager = factory.createEntityManager();
		}
		return entityManager;
	}
}
