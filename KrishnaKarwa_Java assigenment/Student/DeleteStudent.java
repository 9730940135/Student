package net.java.Student;

import java.io.IOException;  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/DeleteStudent")  
public class DeleteStudent extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
             throws ServletException, IOException {  
    	int Stud_no=request.getParameter("Stud_no"); 
        int id=Integer.parseInt(Stud_no);  
        studentdaoimpl.delete(id);  
        response.sendRedirect("ViewStudent");  
    }  
}  