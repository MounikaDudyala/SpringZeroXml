<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ page isELIgnored="false" %>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${request}" method=post>
<table style="width: 50%">
			<tr>
				<td>EmpId*</td>
				<td><input type="text" name="empId" required
                  pattern="[1-9][a-zA-Z0-9]{1,4}"
                  value="${employeeId}"/></td>
              </tr>
			<tr>
				<td>First Name*</td>
				<td><input type="text" name="firstName" required
					pattern="[a-zA-Z]{1,15}" value="${f_name}"/></td>
			</tr>
			<tr>
				<td>Last Name*</td>
				<td><input type="text" name="lastName" required
					pattern="[a-zA-Z]{1,15}" value="${l_name}" /></td>
			</tr>
			<tr>
				<td>ManagerId*</td>
				<td><input type="text" name="managerId" required
					pattern="[a-zA-Z0-9]{1,5}"
					value=${managerId} /></td>
			</tr>
			<tr>
				<td><input type="submit" value="${request}" /></td>
			</tr>
		</table>
	</form>
	<form action="list" method="Get">
	 <input type="submit" value="Cancel"/>
</form>    
</body>
</html>