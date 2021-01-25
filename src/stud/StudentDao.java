package stud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.util.*;

import java.sql.*;


public class StudentDao
{
	
	public static Connection getConnection()
	{  
        Connection con=null; 
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studproject","root","");        
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	  return con;  
	}


	public static int save(Student s) 
	{
//      private String sno,sname,sdob,sdojoin;
	
		int status=0;  
        try{  
            Connection con=StudentDao.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "insert into student(sname,sdob,sdojoin) values (?,?,?)");  
            ps.setString(1,s.getSname());  
            ps.setString(2,s.getSdob());
            ps.setString(3,s.getSdojoin());
            
            status=ps.executeUpdate();  
           
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
    
	return status;
	}
	
	
	public static List<Student> getAllRecords(){  
	    List<Student> list=new ArrayList<Student>();  
	      
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement("select * from student");  
	        ResultSet rs=ps.executeQuery();  
	        while(rs.next()){  
	        	Student u=new Student();  
	            u.setSno(rs.getInt("sno"));  
	            u.setSname(rs.getString("sname"));  
	            u.setSdob(rs.getString("sdob"));  
	            u.setSdojoin(rs.getString("sdojoin"));  
	          
	            list.add(u);  
	        }  
	    }catch(Exception e){System.out.println(e);}  
	    return list;  
	}  
	
	
	public static Student getStudId(int id){  
		Student u=null;  
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement("select * from student where sno=?");  
	        ps.setInt(1,id);  
	        ResultSet rs=ps.executeQuery();  
	        while(rs.next()){  
//	          private String sno,sname,sdob,sdojoin;
	        	
	            u=new Student();  
	            u.setSno(rs.getInt("sno"));  
	            u.setSname(rs.getString("sname"));    
	            u.setSdob(rs.getString("sdob"));
	            u.setSdojoin(rs.getString("sdojoin"));
	        }  
	    }catch(Exception e){System.out.println(e);}  
	    return u;  
	}


	public static int update(Student e) 
	{
		int status=0;  
	    try
	    { 
	    	
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement("update student set sname=?,sdob=?,sdojoin=? where sno=?");  
	            
	       ps.setString(1,e.getSname());
	       ps.setString(2,e.getSdob());
	       ps.setString(3,e.getSdojoin());
	       ps.setInt(4,e.getSno());
	        
	        status=ps.executeUpdate();  
	    }catch(Exception a)
	    {
	    	System.out.println(a);
	    	}  
	    return status;
	}


	public static int delete(int id) 
	{
		int status=0;  
        try{  
            Connection con=StudentDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("delete from student where sno=?");  
            ps.setInt(1,id);  
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return status; 
		
	}  
}
