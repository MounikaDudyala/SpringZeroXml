package com.mounika.employeemanagement.controller;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.mounika.employeemanagement.model.Employee;
import com.mounika.employeemanagement.model.Error;
import com.mounika.employeemanagement.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	private ModelAndView fetchEmployees() throws IOException {
		ModelAndView model = new ModelAndView("list");
		List<Employee> empList = employeeService.fetchEmployees();
		model.addObject("employeeList", empList);
		return model;
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	private ModelAndView newForm() {
		ModelAndView model = new ModelAndView("new");
		return model;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	private ModelAndView createEmployee(@RequestParam("empId") String empId,
			@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName,
			@RequestParam("managerId") String managerId) throws IOException {
		if (firstName.isEmpty() && lastName.isEmpty() && empId.isEmpty() && managerId.isEmpty()) {
			ModelAndView model = new ModelAndView("new");
			return model;
		}
		if (firstName.isEmpty() || lastName.isEmpty() || empId.isEmpty() || managerId.isEmpty()) {
			String requested_option = "create";
			ModelAndView model = new ModelAndView("create");
			model.addObject("request", requested_option);
			model.addObject("employeeId", empId);
			model.addObject("managerId", managerId);
			model.addObject("f_name", firstName);
			model.addObject("l_name", lastName);
			return model;
		} else {
			Employee emp = new Employee(empId, firstName, lastName, managerId);
			boolean is_employee_created = employeeService.createEmployee(emp);
			if (is_employee_created) {
				String success_message = "Employee with Id=" + empId + " Created Successfully!";
				List<Employee> empList = employeeService.fetchEmployees();
				ModelAndView model = new ModelAndView("list");
				model.addObject("employeeList", empList);
				model.addObject("message", success_message);
				return model;
			} else {
				ModelAndView model = new ModelAndView("create");
				return model;
			}
		}
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	@ResponseBody
	private ModelAndView editEmployee(@RequestParam("empId") String empId) throws IOException {
		Employee employee = employeeService.fetchEmployee(empId);
		if (employee.getEmployeeId() == null) {
			ModelAndView model = new ModelAndView("new");
			return model;
		} else {
			ModelAndView model = new ModelAndView("create");
			String requested_option = "update";
			model.addObject("request", requested_option);
			model.addObject("employeeId", employee.getEmployeeId());
			model.addObject("managerId", employee.getManagerId());
			model.addObject("f_name", employee.getFirstName());
			model.addObject("l_name", employee.getLastName());
			return model;
		}
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	private ModelAndView updateEmployee(@RequestParam("empId") String empId,
			@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName,
			@RequestParam("managerId") String managerId) throws IOException {

		if (firstName.isEmpty() && lastName.isEmpty() && empId.isEmpty() && managerId.isEmpty()) {
			ModelAndView model = new ModelAndView("new");
			return model;
		}
		if (firstName.isEmpty() || lastName.isEmpty() || empId.isEmpty() || managerId.isEmpty()) {
			String requested_option = "update";
			ModelAndView model = new ModelAndView("create");
			model.addObject("request", requested_option);
			model.addObject("employeeId", empId);
			model.addObject("managerId", managerId);
			model.addObject("f_name", firstName);
			model.addObject("l_name", lastName);
			return model;
		} else {
			Employee emp = new Employee(empId, firstName, lastName, managerId);
			boolean is_employee_updated = employeeService.updateEmployee(emp);
			if (is_employee_updated) {
				String success_message = "Employee with Id=" + empId + " Updated Successfully!";
				List<Employee> empList = employeeService.fetchEmployees();
				ModelAndView model = new ModelAndView("list");
				model.addObject("employeeList", empList);
				model.addObject("message", success_message);
				return model;
			} else {
				Error error = new Error();
				error.set_message("Employee not Updated");
				ModelAndView model = new ModelAndView("error");
				model.addObject("error", error.get_message());
				return model;
			}
		}
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	@ResponseBody
	private ModelAndView deleteEmployee(@RequestParam("empId") String empId) throws IOException {
		if (empId == null) {
			Error error = new Error();
			error.set_message("Wrong Request with EmployeeId as Null");
			ModelAndView model = new ModelAndView("error");
			model.addObject("error", error.get_message());
			return model;
		} else {
			boolean is_employee_deleted = employeeService.deleteEmployee(empId);
			if (is_employee_deleted) {
				String success_message = "Employee with Id=" + empId + " deleted Successfully!";
				List<Employee> empList = employeeService.fetchEmployees();
				ModelAndView model = new ModelAndView("list");
				model.addObject("employeeList", empList);
				model.addObject("message", success_message);
				return model;
			} else {
				Error error = new Error();
				error.set_message("Employee not existed");
				ModelAndView model = new ModelAndView("error");
				model.addObject("error", error.get_message());
				return model;
			}
		}
	}

}
