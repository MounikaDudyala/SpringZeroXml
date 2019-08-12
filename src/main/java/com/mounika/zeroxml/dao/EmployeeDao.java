package com.mounika.zeroxml.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mounika.zeroxml.model.Employee;
public interface EmployeeDao {
	 List<Employee> fetchEmployees();
}
