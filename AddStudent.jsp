<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Add Student Details</h1>  
<form action="SaveStudent" method="post">  
<table>   
<tr><td>Student Name :</td><td><input type="text" name="sname"/></td></tr>  
<tr><td>Date Of Birth :</td><td><input type="text" name="sdob"/></td></tr>  
<tr><td>Date Of Join:</td><td><input type="text" name="sdojoin"/></td></tr>  
<tr><td colspan="2"><input type="submit" value="Save Info"/></td></tr>
</table>  
</form>  
<br/>  
<a href="ViewStudent.jsp">View Student Details</a>  
</body>
</html>