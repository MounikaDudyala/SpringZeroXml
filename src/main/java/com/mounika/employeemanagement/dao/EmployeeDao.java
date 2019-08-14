package com.mounika.employeemanagement.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mounika.employeemanagement.model.Employee;
public interface EmployeeDao {
	 boolean createEmployee(Employee emp);
	    Employee fetchEmployee(String empId);
	    List<Employee> fetchEmployees();
		boolean deleteEmployee(String empId);
	boolean updateEmployee(Employee emp);
}
