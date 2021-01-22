import java.io.IOException;  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/deleteproject")  
public class deleteproject extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response, String Project_number)   
             throws ServletException, IOException {  
    	 int Project_no=request.getParameter("number");
        int id=Integer.parseInt(Project_number);  
        Projectdao.delete(id);  
        response.sendRedirect("ViewServlet");  
    }  
}  