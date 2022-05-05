package com.cg.smms.repository;

import javax.persistence.EntityManager;

import com.cg.smms.entities.User;

public class UserRepositoryImpl implements IUserRepository {
	private EntityManager entityManager;

//	Constructor
	public UserRepositoryImpl() {
		entityManager = JPAUtil.getEntityManager();
	}

	@Override
	public User addNewUser(User user) {
		entityManager.persist(user);
		return user;
	}

//	updateUser
	@Override
	public User updateUser(User user) {
		entityManager.merge(user);
		return user;
	}

//	searchUser
	@Override
	public User searchUser(int id) {
		User user = entityManager.find(User.class, id);
		return user;
	}

	/* Important */
	public User searchUser(User user) {
		int id = user.getUserId();
		User u = entityManager.find(User.class, id);
		return u;
	}

//	deleteUser
	@Override
	public User deleteUser(int id) {
		User user = entityManager.find(User.class, id);
		entityManager.remove(user);
		return user;
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
