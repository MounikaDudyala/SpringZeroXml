<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="create" method="post">
		<table style="width: 50%">
			<tr>
				<td>EmpId*</td>
				<td><input type="text" name="empId" required
					pattern="[1-9][a-zA-Z0-9]{1,4}" /></td>
			</tr>
			<tr>
				<td>First Name*</td>
				<td><input type="text" name="firstName" required /></td>
			</tr>
			<tr>
				<td>Last Name*</td>
				<td><input type="text" name="lastName" required /></td>
			</tr>
			<tr>
				<td>ManagerId*</td>
				<td><input type="text" name="managerId" required
					pattern="[a-zA-Z0-9]{1,5}" /></td>
			</tr>
			<tr>
			<td><input type="submit" value="create" /></td>
			</tr>
		</table>
	</form>
	<form action="list" method="Get">
	 <input type="submit" value="Cancel"/>
</form>
</body>
</html>