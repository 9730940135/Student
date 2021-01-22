import java.io.IOException;  
import java.io.PrintWriter;  
import java.util.List;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/viewproject")  
public class viewproject extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
               throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<a href='Projectjsp.jsp'>Add New Employee</a>");  
        out.println("<h1>project List</h1>");  
          
        List<Emp> list=Projectdao.getAllEmployees();  
          
        out.print("<table border='1' width='100%'");  
        out.print("<tr><th>Id</th><th>Number</th><th>name</th><th>duration</th><th>platform</th>  
                 <th>Edit</th><th>Delete</th></tr>");  
        for(Project p:list){  
         out.print("<tr><td>"+e.getProject_number()+"</td><td>"+e.Project_name()+"</td><td>"+e.getProject_duration()+"</td>  
                 <td>"+e.getProject_platform()+"</td><td><a href='EditStudent?id="+e.getProject_no()+"'>edit</a></td>  
                 <td><a href='deleteproject?id="+e.getProject_no()+"'>delete</a></td></tr>");  
        }  
        out.print("</table>");  
          
        out.close();  
    }  
}  