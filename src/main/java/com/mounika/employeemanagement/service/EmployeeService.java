package com.mounika.employeemanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mounika.employeemanagement.dao.EmployeeDao;
import com.mounika.employeemanagement.model.Employee;

@Service
public class EmployeeService {
	@Autowired
	EmployeeDao employeeDao;

	public List<Employee> fetchEmployees() {
		List<Employee> employeeList = employeeDao.fetchEmployees();
		return employeeList;
	}

	public boolean createEmployee(Employee emp) {
		boolean is_employee_created = employeeDao.createEmployee(emp);
		return is_employee_created;
	}

	public Employee fetchEmployee(String empId) {
		Employee emp = employeeDao.fetchEmployee(empId);
		return emp;
	}

	public boolean updateEmployee(Employee emp) {
		boolean is_employee_updated = employeeDao.updateEmployee(emp);
		return is_employee_updated;
	}

	public boolean deleteEmployee(String empId) {
		boolean is_employee_deleted = employeeDao.deleteEmployee(empId);
		return is_employee_deleted;
	}
}
