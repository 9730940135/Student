

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import stud.*;

/**
 * Servlet implementation class editStudetServlet
 */
@WebServlet("/editStudetServlet")
public class editStudetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
		
		String id = request.getParameter("sno");
		int cid = Integer.parseInt(id);
		
//        private String sno,sname,sdob,sdojoin;
    	

		
			 
	        String sname=request.getParameter("sname");  
	        String sdob=request.getParameter("sdob");  
	        String sdojoin=request.getParameter("sdojoin");
	      
	        Student e=new Student();  
	        e.setSno(cid);
	        e.setSname(sname);
	        e.setSdob(sdob);
	        e.setSdojoin(sdojoin);
	        
	        
        int status=StudentDao.update(e);  
        if(status>0){  
           // out.print("<p>update successfully!</p>");  
            request.getRequestDispatcher("ViewStudent.jsp").include(request, response);  
        }else{  
            out.println("Sorry! unable to update record");  
        }  
          
        out.close();
	}

}
