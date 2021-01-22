import java.io.IOException;  
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  


@WebServlet("/EditStudent")  
public class EditStuden extends HttpServlet {  
    protected void doPost(HttpServletRequest request, HttpServletResponse response, Date Birth_date, Date join_date)   
          throws ServletException, IOException {  
        response.setContentType("text/javascript");  
        PrintWriter out=response.getWriter();  
          
        int Stud_no=request.getParameter("Stud_no");  
        int Stud_no1=Integer.parseUnsignedInt(Stud_no); 
        String Stud_name=request.getParameter(Stud_name);
        int date=Integer.parseInt(request.getParameter("date"));
		int joindate=Integer.parseInt(request.getParameter("joindate"));
		
          
        Student s=new Student();  
        s.setStud_no(Stud_no);  
        s.setStud_name(Stud_name);  
        s.setBirth_date(Birth_date);  
        s.setJoin_date(join_date);
        
          
        int status=studentdaoimpl.update(s);  
        if(status>0){  
            response.sendRedirect("ViewStudent");  
        }else{  
            out.println("Sorry! unable to update record");  
        }  
          
        out.close();  
    }  
  
}  