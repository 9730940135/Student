<%@page import="stud.*,java.util.*"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  	

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
		String sid = request.getParameter("sno");
		int id = Integer.parseInt(sid);

		Student b =StudentDao.getStudId(id); 
	%>
 
<form action="editStudetServlet" method="post">  
<table>   
<tr><td>Student Number :</td><td><input type="text" name="sno"  value="<%=b.getSno()%>" /></td></tr>  
<tr><td>Student Name :</td><td><input type="text" name="sname"  value="<%=b.getSname()%>"/></td></tr>  
<tr><td>Date Of Birth :</td><td><input type="text" name="sdob"  value="<%=b.getSdob()%>"/></td></tr>  
<tr><td>Date Of Join:</td><td><input type="text" name="sdojoin" value="<%=b.getSdojoin()%>"/></td></tr>  
<tr><td colspan="2"><input type="submit" value="Update Info"/></td></tr>
</table>  
</form>  
<br/>  
<a href="ViewStudent.jsp">View Student Details</a>  
</body>
</html> 