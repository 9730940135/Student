

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.Project;
import project.ProjectDao;

/**
 * Servlet implementation class editProject
 */
@WebServlet("/editProject")
public class editProject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
		
		String id = request.getParameter("pno");
		int cid = Integer.parseInt(id);
		
//        private String sno,sname,sdob,sdojoin;
   			 
	        String pname=request.getParameter("pname");  
	        String pduration=request.getParameter("pduration");  
	        String platform=request.getParameter("platform");
	      
	        Project e=new Project();  
	        e.setPno(cid);
	        e.setPname(pname);
	        e.setPduration(pduration);
	        e.setPlatform(platform);
	                
        int status=ProjectDao.update(e);  
        if(status>0){  
           // out.print("<p>update successfully!</p>");  
            request.getRequestDispatcher("ViewProject.jsp").include(request, response);  
        }else{  
            out.println("Sorry! unable to update record");  
        }            
        out.close();
	}

}
