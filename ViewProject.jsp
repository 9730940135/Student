 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
  <%@page import="project.*,java.util.*"%>  
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
List<Project> list=ProjectDao.getAllRecords();
request.setAttribute("list",list);  
%>  

<br/><a href="AddStudent.jsp">Add New Student</a>  

  
<table border="1" width="90%">  
<tr>
	<th>Project Number</th>
	<th>Project Name</th>
	<th>Project Duration</th>
	<th>Platform</th>  
	<th>Edit</th>
	<th>Delete</th>
</tr>  
	<c:forEach items="${list}" var="u">  
		<tr>
			<td>${u.getPno()}</td>
			<td>${u.getPname()}</td>
			<td>${u.getPduration()}</td>  
			<td>${u.getPlatform()}</td>
			<td><a href="editProject.jsp?pno=${u.getPno()}">Edit</a></td>  
			<td><a href="deleteProject?pno=${u.getPno()}">Delete</a></td>
		</tr>  
	</c:forEach>  
</table>  
      

</body>
</html> 