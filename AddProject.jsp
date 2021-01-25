<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Add Project Details</h1>  
<form action="addProject" method="post">  
<table>   
<tr><td>Project Name :</td><td><input type="text" name="pname"/></td></tr>  
<tr><td>Project Duration :</td><td><input type="text" name="pduration"/></td></tr>  
<tr><td>Platform :</td><td><input type="text" name="platform"/></td></tr>  
<tr><td colspan="2"><input type="submit" value="Save Info"/></td></tr>
</table>  
</form>  
<br/>  
<a href="ViewProject.jsp">View Student Details</a>  
</body>
</html>