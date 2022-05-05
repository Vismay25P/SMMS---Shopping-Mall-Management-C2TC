package com.cg.smms.repository;

import javax.persistence.EntityManager;

import com.cg.smms.entities.Employee;
import com.cg.smms.exception.ObjectNotFoundException;

public class EmployeeRepositoryImpl implements IEmployeeRepository {
	private EntityManager entityManager;

//	Constructor
	public EmployeeRepositoryImpl() {
		entityManager = JPAUtil.getEntityManager();
	}

//	addEmployee
	@Override
	public Employee addEmployee(Employee employee) {
		entityManager.persist(employee);
		System.out.println("Your Account is created, ID is:- " + employee.getEmployeeId());
		return employee;
	}

//	updateEmployee
	@Override
	public Employee updateEmployee(Employee employee) {
		int id = employee.getEmployeeId();
		Employee emp = entityManager.find(Employee.class, id);
		try {
			if (emp == null) {
				throw new ObjectNotFoundException("Please provide correct Employee ID !!\n");
			} else {
				entityManager.merge(employee);
			}
		} catch (ObjectNotFoundException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}
		return employee;
	}

//	searchEmployee
	@Override
	public Employee searchEmployee(int id) {
		Employee emp = entityManager.find(Employee.class, id);
		try {
			if (emp == null) {
				throw new ObjectNotFoundException("Employee Details not Found !!\n");
			}
//			else {
//				System.out.println(emp.toString());
//			}
		} catch (ObjectNotFoundException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}
		return emp;
	}

//	deleteEmployee
	@Override
	public boolean deleteEmployee(int id) {
		Employee emp = entityManager.find(Employee.class, id);
		try {
			if (emp == null) {
				throw new ObjectNotFoundException("Can't delete unknown employee !!\n");
			} else {
				entityManager.remove(emp);
			}
		} catch (ObjectNotFoundException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
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
