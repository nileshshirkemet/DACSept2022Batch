<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<sf:form modelAttribute="emp">
		
		<table border="1">
			<tr>
				<td>ID: </td>
				<td> <sf:input id="txtId" path="id"/> </td>
			</tr>
			<tr>
				<td>Name: </td>
				<td><sf:input id="txtName" path="name"/> </td> 
			</tr>
			<tr>
				<td>Designation: </td>
				<td><sf:input id="txtDesignation" path="designation"/> </td>
			</tr>
			<tr>
				<td>EmailId: </td>
				<td> <sf:input id="txtEmailId" path="emailId"/> </td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="Save Emp" />
				</td>
			</tr>
		</table>
		
	</sf:form>
		

</body>
</html>