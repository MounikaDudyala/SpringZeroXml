package com.mounika.employeemanagement.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mounika.employeemanagement.dao.EmployeeDao;
import com.mounika.employeemanagement.dao.impl.EmployeeDaoImpl;
import com.mounika.employeemanagement.model.Employee;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeDao employeeDao = new EmployeeDaoImpl();

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView listEmployee() throws IOException {
		System.out.println("in listEmployee");
		ModelAndView model = new ModelAndView("list");
		List<Employee> empList = employeeDao.fetchEmployees();
		System.out.println(empList);
		model.addObject("employeeList", empList);
		return model;
	}
}
