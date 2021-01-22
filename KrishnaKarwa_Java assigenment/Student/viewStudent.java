
package net.java.Student;
import java.io.IOException;  
import java.io.PrintWriter;  
import java.util.List;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/ViewStudent")  
public class ViewServlet extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
               throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<a href='NewFile.jsp'>Add New Student</a>");  
        out.println("<h1>Student List</h1>");  
          
        List<student> list=studentdaoimpl.getAllStudent();  
          
        out.print("<table border='1' width='100%'");  
        out.print("<tr><th>Id</th><th>Number</th><th>Name</th><th>Birth_date</th><th>Country</th>  
                 <th>Edit</th><th>Delete</th></tr>");  
        for(Student s:list){  
         out.print("<tr><td>"+e.getId()+"</td><td>"+e.getStud_no()+"</td><td>"+e.getStud_name()+"</td>  
                 <td>"+e.getBirth_date()+"</td><td>"+e.getJoin_date()+"</td><td><a href='EditStudent?id="+e.getId()+"'>edit</a></td>  
                 <td><a href='DeleteStudent?id="+e.getId()+"'>delete</a></td></tr>");  
        }  
        out.print("</table>");  
          
        out.close();  
    }  
}