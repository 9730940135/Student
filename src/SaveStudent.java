

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import stud.Student;
import stud.StudentDao;
/**
 * Servlet implementation class SaveStudent
 */
@WebServlet("/SaveStudent")
public class SaveStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
   	{
   		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        
//        private String sno,sname,sdob,sdojoin;

         String sname=request.getParameter("sname");  
        String sdob=request.getParameter("sdob");  
        String sdojoin=request.getParameter("sdojoin");  
        
        Student s=new Student();  
        s.setSname(sname);
        s.setSdob(sdob);
        s.setSdojoin(sdojoin);
        
        int status=StudentDao.save(s); 
        
        if(status>0){ 
            request.getRequestDispatcher("AddStudent.jsp").include(request, response);  
            out.print("<p>Record saved successfully!</p>");  	
        }else{  
            out.println("Sorry! unable to save record");  
        }  
          
        out.close();  
	}

}
