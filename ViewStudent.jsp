 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
  <%@page import="stud.StudentDao,stud.*,java.util.*"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
    
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Records</title>
</head>
<body>
<h2>Student Records</h2>  
  
<%  
List<Student> list=StudentDao.getAllRecords();
request.setAttribute("list",list);  
%>  

<br/><a href="AddStudent.jsp">Add New Student</a>  

  
<table border="1" width="90%">  
<tr>
	<th>Number</th>
	<th>Name</th>
	<th>Date Of Birth</th>
	<th>Date Of Join</th>  
	<th>Edit</th>
	<th>Delete</th>
</tr>  
	<c:forEach items="${list}" var="u">  
		<tr>
			<td>${u.getSno()}</td>
			<td>${u.getSname()}</td>
			<td>${u.getSdob()}</td>  
			<td>${u.getSdojoin()}</td>
			<td><a href="editStudent.jsp?sno=${u.getSno()}">Edit</a></td>  
			<td><a href="deleteStudent?sno=${u.getSno()}">Delete</a></td>
		</tr>  
	</c:forEach>  
</table>  
      

</body>
</html> 