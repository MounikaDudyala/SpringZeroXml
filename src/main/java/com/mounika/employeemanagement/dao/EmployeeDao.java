package com.mounika.employeemanagement.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mounika.employeemanagement.model.Employee;
public interface EmployeeDao {
	 List<Employee> fetchEmployees();
}
