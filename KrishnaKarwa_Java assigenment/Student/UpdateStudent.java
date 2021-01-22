import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/EditStudent")  
public class UpdateStudent extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
           throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<h1>Update Student</h1>");  
        int Stud_no=request.getParameter("Stud_no");  
        int id=Integer.parseInt(Stud_n);  
          
        Student s=studentdaoimpl.getStudentById(Stud_no);  
          
        out.print("<form action='EditStudent' method='post'>");  
        out.print("<table>");  
        out.print("<tr><td></td><td><input type='hidden' name='id' value='"+e.getId()+"'/></td></tr>");  
        out.print("<tr><td>student Number:</td><td><input type='text' name='number' value='"+e.getstud_no()+"'/></td></tr>");  
        out.print("<tr><td>Student name:</td><td><input type='password' name='Name' value='"+e.getPassword()+"'/>  
                </td></tr>");  
        out.print("<tr><td>Birth_date:</td><td><input type='email' name='birthdate' value='"+e.getBirth_date()+"'/></td></tr>");  
        try {  
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);  
            dataNascimento1 = Calendar.getInstance();  
            dataNascimento1.setTime(date);
            dataNascimento2 = Calendar.getInstance();  
            dataNascimento2.setTime(date);  
            dataNascimento3 = Calendar.getInstance();  
            dataNascimento3.setTime(date);  
        } catch(ParseException e) {  
            out.println("Errors");  
            return;   
        } 
        out.print("<tr><td>Join_date:</td><td><input type='email' name='joindate' value='"+e.getJoin_date()+"'/></td></tr>");  
        try {  
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);  
            dataNascimento1 = Calendar.getInstance();  
            dataNascimento1.setTime(date);
            dataNascimento2 = Calendar.getInstance();  
            dataNascimento2.setTime(date);  
            dataNascimento3 = Calendar.getInstance();  
            dataNascimento3.setTime(date);  
        } catch(ParseException e) {  
            out.println("Errors");  
            return;   
        } 
        out.print("</select>");  
        out.print("</td></tr>");  
        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");  
        out.print("</table>");  
        out.print("</form>");  
          
        out.close();  
    }  
}  