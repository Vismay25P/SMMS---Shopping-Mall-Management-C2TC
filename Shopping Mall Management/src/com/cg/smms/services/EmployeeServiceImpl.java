package com.cg.smms.services;

import java.util.List;

import com.cg.smms.entities.Employee;
import com.cg.smms.repository.EmployeeRepositoryImpl;
import com.cg.smms.repository.IEmployeeRepository;

public class EmployeeServiceImpl implements IEmployeeService {
	private IEmployeeRepository EmployeeDAO;

//	Constructor
	public EmployeeServiceImpl() {
		EmployeeDAO = new EmployeeRepositoryImpl();
	}

//	addEmployee
	@Override
	public Employee addEmployee(Employee employee) {
		EmployeeDAO.beginTransaction();
		EmployeeDAO.addEmployee(employee);
		EmployeeDAO.commitTransaction();
		System.out.println("1Employee is Added");
		return employee;
	}

	@Override
	public List<Employee> addEmployees(List<Employee> employees) {
		EmployeeDAO.beginTransaction();
		for (Employee employee : employees) {
			EmployeeDAO.addEmployee(employee);
		}
		EmployeeDAO.commitTransaction();
		System.out.println("Employee List is Added");
		return employees;
	}

//	updateEmployee
	@Override
	public Employee updateEmployee(Employee employee) {
		EmployeeDAO.beginTransaction();
		EmployeeDAO.updateEmployee(employee);
		EmployeeDAO.commitTransaction();
		return employee;
	}

//	searchEmployee
	@Override
	public Employee searchEmployee(int id) {
		Employee employee = EmployeeDAO.searchEmployee(id);
		System.out.println("Here is your Result: Employee " + employee.getName());
		return employee;
	}

//	deleteEmployee
	@Override
	public boolean deleteEmployee(int id) {
		EmployeeDAO.beginTransaction();
		EmployeeDAO.deleteEmployee(id);
		EmployeeDAO.commitTransaction();
		return true;
	}

}
