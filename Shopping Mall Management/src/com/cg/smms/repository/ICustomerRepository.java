package com.cg.smms.repository;

import com.cg.smms.entities.Customer;

public interface ICustomerRepository {
	Customer addCustomer(Customer customer);

	Customer updateCustomer(Customer customer);

	Customer searchCustomer(int id);

	boolean deleteCustomer(int id);

	void beginTransaction();

	void commitTransaction();
}
