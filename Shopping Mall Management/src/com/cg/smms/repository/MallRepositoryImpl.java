package com.cg.smms.repository;

import javax.persistence.EntityManager;

import com.cg.smms.entities.Mall;

public class MallRepositoryImpl implements IMallRepository {
	private EntityManager entityManager;

//	Constructor
	public MallRepositoryImpl() {
		entityManager = JPAUtil.getEntityManager();
	}

//	addMall
	@Override
	public Mall addMall(Mall mall) {
		entityManager.persist(mall);
		return mall;
	}

//	updateMall
	@Override
	public Mall updateMall(Mall mall) {
		entityManager.merge(mall);
		return mall;
	}

//	searchMall
	@Override
	public Mall searchMall(int id) {
		Mall mall = entityManager.find(Mall.class, id);
		return mall;
	}

//	deleteMall
	@Override
	public Mall deleteMall(int id) {
		Mall mall = entityManager.find(Mall.class, id);
		entityManager.remove(mall);
		return mall;
	}

//	beginTransaction
	@Override
	public void beginTransaction() {
		entityManager.getTransaction().begin();
	}

//	commitTransaction
	@Override
	public void commitTransaction() {
		entityManager.getTransaction().commit();

	}

}
