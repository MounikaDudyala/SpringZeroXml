<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%> 
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
}
</style>
</head>
<body>
<a href="new">NEW</a>
<h5>${message}</h5>
<table>
	<tr>
		<th>EmpID</th>
		<th>FirstName</th>
		<th>LastName</th>
		<th>ManagerID</th>
	</tr>
	<c:forEach var="employee" items="${employeeList}">
		<tr>
			<td><c:out value="${employee.getEmployeeId()}"></c:out></td>
			<td><c:out value="${employee.getFirstName()}"></c:out></td>
			<td><c:out value="${employee.getLastName()}"></c:out></td>
			<td><c:out value="${employee.getManagerId()}"></c:out></td>
	    <td>
        <a href="delete?empId=${employee.getEmployeeId()}">delete </a>
        </td>
        <td>
        <a href="edit?empId=${employee.getEmployeeId()}">edit </a>       
        </td>
	 </tr>
	</c:forEach>
</table>
</body>
</html>