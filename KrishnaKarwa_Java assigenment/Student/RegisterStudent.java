import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/SaveServlet")  



public class RegisterStudent extends HttpServlet {  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   
         throws ServletException, IOException {  
        response.setContentType("text/javascript");  
        PrintWriter out=response.getWriter();  
          
        int number=Integer.parseInt(request.getParameter("number"));
        
        
		String Name=request.getParameter("Name");
		
		int date=Integer.parseInt(request.getParameter("date"));
		int joindate=Integer.parseInt(request.getParameter("joindate"));
		
          
        Student s=new Student();  
        s.setStud_no(number);  
        s.setStud_name(Name);  
        s.setBirth_date(date);  
        s.setJoin_date(joindate);
          
          
        int status=studentdaoimpl.save(s);  
        if(status>0){  
            out.print("<p>Record saved successfully!</p>");  
            request.getRequestDispatcher("Newfile.jsp").include(request, response);  
        }else{  
            out.println("Sorry! unable to save record");  
        }  
          
        out.close();  
    }  
  
}  