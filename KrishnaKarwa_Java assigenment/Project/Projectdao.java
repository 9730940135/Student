package net.java.Student.Project;
import java.util.*;  
import java.sql.*;  

public class Projectdao {
	public static Connection getConnection(){  
        Connection con=null;  
        try{  
            Class.forName("oracle.jdbc.driver.OracleDriver");  
            con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");  
        }catch(Exception e){System.out.println(e);}  
        return con;  
    }  
    public static int save(project p){  
        int status=0;  
        try{  
            Connection con=Projectdao.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "insert into Project1(Project_no,Project_name,Project_duration,Project_platfom) values (?,?,?,?)");  
            ps.setInt(1,p.getProject_no());  
            ps.setString(2,p.getProject_name());  
            ps.setString(3,p.getProject_duration());  
            ps.setString(4,p.getProject_platfrom());  
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public static int update(project p){  
        int status=0;  
        try{  
            Connection con=Projectdao.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "update project set Project_no=?,Project_name=?,Project_duration=?,project_platfrom=? where id=?");  
            ps.setInt(1,p.getProject_no());  
            ps.setString(2,p.getProject_name());  
            ps.setString(3,p.getProject_duration());  
            ps.setString(4,p.getProject_platfrom());
            ps.setInt(5,p.getid());  
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public static int delete(int id){  
        int status=0;  
        try{  
            Connection con=Projectdao.getConnection();  
            PreparedStatement ps=con.prepareStatement("delete from Project where id=?");  
            ps.setInt(1,id);  
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return status;  
    }  
    public static project getEmployeeById(int id){  
        project p=new project();  
          
        try{  
            Connection con=Projectdao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from Project where id=?");  
            ps.setInt(1,id);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
                p.setProject_no(rs.getInt(1));  
                p.setProject_name(rs.getString(2));  
                p.setProject_duration(rs.getString(3));  
                p.setProject_platfrom(rs.getString(4));  
                
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return p;  
    }  
    public static List<project> getAllproject(){  
        List<project> list=new ArrayList<project>();  
          
        try{  
            Connection con=Projectdao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from project");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                project p=new project();    
                p.setProject_no(rs.getInt(1));  
                p.setProject_name(rs.getString(2));  
                p.setProject_duration(rs.getString(3));  
                p.setProject_platfrom(rs.getString(4));  
                list.add(p);  
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    }  
}  
	

