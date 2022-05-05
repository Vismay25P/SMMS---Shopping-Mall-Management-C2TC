package com.cg.smms.repository;

import javax.persistence.EntityManager;

import com.cg.smms.entities.Customer;

public class CustomerRepositoryImpl implements ICustomerRepository {
	private EntityManager entityManager;

//	Constructor
	public CustomerRepositoryImpl() {
		entityManager = JPAUtil.getEntityManager();
	}

//	addCustomer
	@Override
	public Customer addCustomer(Customer customer) {
		entityManager.persist(customer);
		return customer;
	}

//	updateCustomer
	@Override
	public Customer updateCustomer(Customer customer) {
		entityManager.merge(customer);
		return customer;
	}

//	searchCustomer
	@Override
	public Customer searchCustomer(int id) {
		Customer customer = entityManager.find(Customer.class, id);
		return customer;
	}

//	deleteCustomer
	@Override
	public boolean deleteCustomer(int id) {
		entityManager.remove(searchCustomer(id));
		return true;
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
