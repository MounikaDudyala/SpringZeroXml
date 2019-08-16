package com.mounika.employeemanagement.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mounika.employeemanagement.dao.AbstractDBConnection;
import com.mounika.employeemanagement.dao.EmployeeDao;
import com.mounika.employeemanagement.model.Employee;

@Repository
public class EmployeeDaoImpl extends AbstractDBConnection implements EmployeeDao {
	public boolean createEmployee(Employee emp) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement("insert into Employee values(?,?,?,?)");
			pstmt.setString(1, emp.getEmployeeId());
			pstmt.setString(2, emp.getFirstName());
			pstmt.setString(3, emp.getLastName());
			pstmt.setString(4, emp.getManagerId());
			int i = pstmt.executeUpdate();
			if (i == 1)
				return true;
			if (i == 0)
				return false;
		} catch (SQLException e) {
			System.out.println("SQLException caught: " + e.getMessage());
		} catch (Exception e) {

			System.out.println("message");
		}
		return false;
	}

	public Employee fetchEmployee(String empId) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select * from Employee where empId=?");
			pstmt.setString(1, empId);
			ResultSet rs = pstmt.executeQuery();
			Employee emp = new Employee();
			while (rs.next()) {
				emp.setEmployeeId(rs.getString(1));
				emp.setFirstName(rs.getString(2));
				emp.setLastName(rs.getString(3));
				emp.setManagerId(rs.getString(4));
			}

			return emp;
		} catch (SQLException e) {
			System.out.println("SQLException caught: " + e.getMessage());

		} catch (Exception e) {

			System.out.println("message");
		}
		return null;
	}

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

	public boolean deleteEmployee(String empId) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement("delete from Employee where empId=?");
			pstmt.setString(1, empId);
			int i = pstmt.executeUpdate();
			if (i == 1)
				return true;
			if (i == 0)
				return false;

		} catch (SQLException e) {
			System.out.println("SQLException caught: " + e.getMessage());
		} catch (Exception e) {

			System.out.println("message");
		}
		return false;
	}

	public boolean updateEmployee(Employee emp) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = getConnection();
			PreparedStatement pstmt = conn
					.prepareStatement("update Employee set empId=?,FirstName=?,LastName=?,ManagerId=? where EmpId=?");
			pstmt.setString(1, emp.getEmployeeId());
			pstmt.setString(2, emp.getFirstName());
			pstmt.setString(3, emp.getLastName());
			pstmt.setString(4, emp.getManagerId());
			pstmt.setString(5, emp.getEmployeeId());
			int i = pstmt.executeUpdate();
			if (i == 0) {
				return false;
			} else
				return true;

		} catch (SQLException e) {
			System.out.println("SQLException caught: " + e.getMessage());
		} catch (Exception e) {

			System.out.println("message");
		}
		return false;
	}
}
