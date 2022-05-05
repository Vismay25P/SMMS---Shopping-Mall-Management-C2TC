package com.cg.smms.repository;

import javax.persistence.EntityManager;

import com.cg.smms.entities.MallAdmin;

public class MallAdminRepositoryImpl implements IMallAdminRepository {
	private EntityManager entityManager;

//	Constructor
	public MallAdminRepositoryImpl() {
		entityManager = JPAUtil.getEntityManager();
	}

//	addMallAdmin
	@Override
	public MallAdmin addMallAdmin(MallAdmin mallAdmin) {
		entityManager.persist(mallAdmin);
		return mallAdmin;
	}

//	updateMallAdmin
	@Override
	public MallAdmin updateMallAdmin(MallAdmin mallAdmin) {
		entityManager.merge(mallAdmin);
		return mallAdmin;
	}

//	searchMallAdmin
	@Override
	public MallAdmin searchMallAdmin(int id) {
		MallAdmin mallAdmin = entityManager.find(MallAdmin.class, id);
		return mallAdmin;
	}

//	deleteMallAdmin
	@Override
	public MallAdmin deleteMallAdmin(int id) {
		MallAdmin mallAdmin = entityManager.find(MallAdmin.class, id);
		entityManager.remove(searchMallAdmin(id));
		return mallAdmin;
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
