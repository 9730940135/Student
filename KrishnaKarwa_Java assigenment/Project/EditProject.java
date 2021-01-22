package net.java.Student.Project;
import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/EditProject")  
public class EditProject extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
           throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<h1>Update Project</h1>");  
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
          
        Project p=Projectdao.getProjectById(id);  
          
        out.print("<form action='EditPoject2' method='post'>");  
        out.print("<table>");  
        out.print("<tr><td></td><td><input type='hidden' name='id' value='"+e.getId()+"'/></td></tr>");  
        out.print("<tr><td>Number:</td><td><input type='text' name='name' value='"+e.getProject_number()+"'/></td></tr>");  
        out.print("<tr><td>Name:</td><td><input type='text' name='password' value='"+e.getProject_name()+"'/>  
                </td></tr>");  
        out.print("<tr><td>Duration:</td><td><input type='text' name='email' value='"+e.getProject_duration()+"'/></td></tr>");  
        out.print("<tr><td>Platfrom:</td><td>"<input type='text' name='text' value="+e.getProject_platfrom()+"/></td></tr>);  
        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");  
        out.print("</table>");  
        out.print("</form>");  
          
        out.close();  
    }  
}  