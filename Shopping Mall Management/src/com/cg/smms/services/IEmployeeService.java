package com.cg.smms.services;

import java.util.List;

import com.cg.smms.entities.Employee;

public interface IEmployeeService {

	Employee addEmployee(Employee employee);
	
	List<Employee> addEmployees(List<Employee> employees);

	Employee updateEmployee(Employee employee);

	Employee searchEmployee(int id);

	boolean deleteEmployee(int id);
}
