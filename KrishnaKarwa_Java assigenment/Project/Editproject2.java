import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/EditStudent2")  
public class EditStudent2 extends HttpServlet {  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   
          throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        
        
        int Project_no=request.getParameter("number");  
        String Project_name=request.getParameter("name");  
        String Project_duration=request.getParameter("duration");  
        String Project_platfrom=request.getParameter("platfrom");  
          
        project p=new project();  
        p.setProject_no(Project_no);  
        p.setProject_name(Project_name);  
        p.setProject_duration(Project_duration);  
        p.setProject_platfrom(Project_platfrom);
        
        
        int status=Projectdao.update(p);  
        if(status>0){  
            response.sendRedirect("ViewServlet");  
        }else{  
            out.println("Sorry! unable to update record");  
        }  
          
        out.close();  
    }  
  
}  