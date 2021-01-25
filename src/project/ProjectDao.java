package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import stud.StudentDao;

public class ProjectDao 
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

	public static int save(Project s) 
	{
//    	private String pname,pduration,platform;
		
		int status=0;  
        try{  
            Connection con=ProjectDao.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "insert into project(pname,pduration,platform) values (?,?,?)");  
            ps.setString(1,s.getPname());  
            ps.setString(2,s.getPduration());
            ps.setString(3,s.getPlatform());
            
            status=ps.executeUpdate();  
           
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
    
	return status;
	}
	
	public static List<Project> getAllRecords(){  
	    List<Project> list=new ArrayList<Project>();  
	      
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement("select * from project");  
	        ResultSet rs=ps.executeQuery();  
	        while(rs.next()){  
	        	Project u=new Project();  
	        	
	            u.setPno(rs.getInt("pno"));  
	            u.setPname(rs.getString("pname"));  
	            u.setPduration(rs.getString("pduration"));  
	            u.setPlatform(rs.getString("platform"));  
	          
	            list.add(u);  
	        }  
	    }catch(Exception e){System.out.println(e);}  
	    return list;  
	} 
	
	
	public static Project getProjId(int id){  
		Project u=null;  
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement("select * from project where pno=?");  
	        ps.setInt(1,id);  
	        ResultSet rs=ps.executeQuery();  
	        while(rs.next()){  
//	          private String sno,sname,sdob,sdojoin;
	        	
	            u=new Project();  
	            
	            u.setPno(rs.getInt("pno"));  
	            u.setPname(rs.getString("pname"));  
	            u.setPduration(rs.getString("pduration"));  
	            u.setPlatform(rs.getString("platform"));      
	        }  
	    }catch(Exception e){System.out.println(e);}  
	    return u;  
	}

	public static int update(Project e) 
	{
		int status=0;  
	    try
	    { 
	    	
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement("update project set pname=?,pduration=?,platform=? where pno=?");  
	            
	       ps.setString(1,e.getPname());
	       ps.setString(2,e.getPduration());
	       ps.setString(3,e.getPlatform());
	       ps.setInt(4,e.getPno());
	        
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
            PreparedStatement ps=con.prepareStatement("delete from project where pno=?");  
            ps.setInt(1,id);  
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return status; 
		
	}
	
	
	
	

}
