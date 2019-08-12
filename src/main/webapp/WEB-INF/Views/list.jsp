<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%> 
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set var="message" value="${100}"></c:set>
<c:out value="${message}"></c:out>
	<tr>
		<td></td>
	</tr>
	<tr>
		<th>EmpID</th>
		<th>FirstName</th>
		<th>LastName</th>
		<th>ManagerID</th>
	</tr>
	<c:if test="${not empty employeeList}">
		<c:out value="${employeeList}"></c:out>
	</c:if>
	
	<c:forEach var="employee" items="${employeeList}">
		<tr>
			<td><c:out value="${employee.getEmployeeId()}"></c:out></td>
			<td><c:out value="${employee.getFirstName()}"></c:out></td>
			<td><c:out value="${employee.getLastName()}"></c:out></td>
			<td><c:out value="${employee.getManagerId()}"></c:out></td>
		</tr>
	</c:forEach>
</body>
</html>