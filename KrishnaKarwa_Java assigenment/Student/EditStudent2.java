

import java.io.IOException; 
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/EditServlet2")  
public class EditServlet2 extends HttpServlet {  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   
          throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String sid=request.getParameter("id");  
        int Stud_no=request.getParameter("Stud_no");  
        int Stud_no1=Integer.parseInt(Stud_no); 
        String Stud_name=request.getParameter(Stud_name);
        int date=Integer.parseInt(request.getParameter("date"));
		int joindate=Integer.parseInt(request.getParameter("joindate"));
		
          
        Student s=new Student();  
        s.setStud_no(Stud_no);  
        s.setStud_name(Stud_name);  
        s.setBirth_date(Birth_date);  
        s.setJoin_date(join_date);
        
          
          
        int status=EmpDao.update(e);  
        if(status>0){  
            response.sendRedirect("ViewServlet");  
        }else{  
            out.println("Sorry! unable to update record");  
        }  
          
        out.close();  
    }  
  
}  