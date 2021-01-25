

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.*;

/**
 * Servlet implementation class addProject
 */
@WebServlet("/addProject")
public class addProject extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        
//        private int pno;
//    	private String pname,pduration,platform;
        
         String pname=request.getParameter("pname");  
        String pduration=request.getParameter("pduration");  
        String platform=request.getParameter("platform");  
        
        Project s=new Project();  
        s.setPname(pname);
        s.setPduration(pduration);
        s.setPlatform(platform);
        
        int status=ProjectDao.save(s); 
        
        if(status>0){ 
            request.getRequestDispatcher("AddProject.jsp").include(request, response);  
            out.print("<p>Record saved successfully!</p>");  	
        }else{  
            out.println("Sorry! unable to save record");  
        }  
          
        out.close();
		
	}

}
