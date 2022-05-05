package com.cg.smms.repository;

import java.util.*;

import com.cg.smms.entities.Employee;

@SuppressWarnings("unused")
public interface IEmployeeRepository {

	Employee addEmployee(Employee employee);

	Employee updateEmployee(Employee employee);

	Employee searchEmployee(int id);

	boolean deleteEmployee(int id);

	void beginTransaction();

	void commitTransaction();

}
