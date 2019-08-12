package com.mounika.zeroxml.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mounika.zeroxml.dao.AbstractDBConnection;
import com.mounika.zeroxml.dao.EmployeeDao;
import com.mounika.zeroxml.model.Employee;

@Repository
public class EmployeeDaoImpl extends AbstractDBConnection implements EmployeeDao {
	public List<Employee> fetchEmployees() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = getConnection();
			Statement st = conn.createStatement();
			String query = "select * from Employee";
			ResultSet rs = st.executeQuery(query);
			List<Employee> list = new ArrayList<Employee>();
			while (rs.next()) {
				Employee emp = new Employee();
				emp.setEmployeeId(rs.getString(1));
				emp.setFirstName(rs.getString(2));
				emp.setLastName(rs.getString(3));
				emp.setManagerId(rs.getString(4));
				list.add(emp);

			}

			return list;
		} catch (SQLException e) {
			System.out.println("SQLException caught: " + e.getMessage());

		} catch (Exception e) {

			System.out.println("message");
		}
		return null;
	}

}
