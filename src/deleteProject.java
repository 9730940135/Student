import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.ProjectDao;

/**
 * Servlet implementation class deleteProject
 */

@WebServlet("/deleteProject")
public class deleteProject extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String sid=request.getParameter("pno");  
        int id=Integer.parseInt(sid);  
        ProjectDao.delete(id);  
        response.sendRedirect("AddProject"); 
	}
}
