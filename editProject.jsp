<%@page import="project.*,java.util.*"%>  
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
		String sid = request.getParameter("pno");
		int id = Integer.parseInt(sid);

		Project b =ProjectDao.getProjId(id); 
	%>
<form action="editProject" method="post">  
			<table>   
					<tr><td>Project Number :</td><td><input type="text" name="pno"  value="<%=b.getPno()%>" /></td></tr>  
					<tr><td>Project Name :</td><td><input type="text" name="pname"  value="<%=b.getPname()%>"/></td></tr>  
					<tr><td>Project Duration :</td><td><input type="text" name="pduration"  value="<%=b.getPduration()%>"/></td></tr>  
					<tr><td>Platform:</td><td><input type="text" name="platform" value="<%=b.getPlatform()%>"/></td></tr>  
					<tr><td colspan="2"><input type="submit" value="Update Info"/></td></tr>
			</table>  
</form>  
<br/>  
<a href="ViewStudent.jsp">View Student Details</a>  
</body>
</html> 