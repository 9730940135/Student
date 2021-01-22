package net.java.Student;

import java.sql.Date;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class studentdaoimpl implements Studentdao {

	
	static Connection con;
	static PreparedStatement ps;
	
	public int insertStudent(Student s) {
		int status=0;
		try {
			
			con=register.getCon();
			ps=(PreparedStatement) con.prepareStatement("insert into Student1(Stud_no,Stud_name,Birth_date,Join_date)values(?,?,?,?)");
			ps.setInt(1,s.getStud_no());
			ps.setString(2,s.getStud_name());
			ps.setDate(3,s.getBirth_date());
			ps.setDate(4, s.getJoin_date());
			status=ps.executeUpdate();
			con.close();
			
			
		}
		catch(Exception e) {
			
		
			System.out.println(e);
		}
		return status;
	}
	
	public static int update(Student s)
	{
		int status=0;
		
         try {
			
			con=register.getCon();
			ps=(PreparedStatement) con.prepareStatement("update student set Stud_no=?,Stud_name=?,Birth_date=?,Join_date=? where Stud_no=?");
			ps.setInt(1,s.getStud_no());
			ps.setString(2,s.getStud_name());
			ps.setDate(3,s.getBirth_date());
			ps.setDate(4, s.getJoin_date());
			status=ps.executeUpdate();
			con.close();
			
			
		}
		catch(Exception e) {
			
		
			System.out.println(e);
		}
		return status;
	}
	
	public static int delete(int Stud_no)
	{
		int status=0;
		
         try {
			
			con=register.getCon();
			ps=(PreparedStatement) con.prepareStatement("delete from student where Stud_no=?");
			ps.setInt(1,Stud_no);	
			status=ps.executeUpdate();
			con.close();
			
			
		}
		catch(Exception e) {
			
		
			System.out.println(e);
		}
		return status;
	}
	

	
	public static int StudentByno(int Stud_no)
	{
		Student s=new Student();
		int status=0;
		
         try {
			
			con=register.getCon();
			ps=(PreparedStatement) con.prepareStatement("select* form student where Stud_no=?");
			ps.setInt(1,Stud_no);
			
			
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				s.setStud_no(rs.getInt(1));
				s.setStud_name(rs.getString(2));
				s.setBirth_date(rs.getDate(3));
				s.setJoin_date(rs.getDate(4));
				
			}
			status=ps.executeUpdate();
			con.close();
		}
		catch(Exception e) {
			
		
			System.out.println(e);
		}
		return status;
	}
	
	@Override
	public Student getStudent(int Stud_no, String Stud_name, Date birth_date, Date join_date) {
		
		Student s=new Student();
		
		
		try {
			con=register.getCon();
			ps=(PreparedStatement) con.prepareStatement("Select * form student where Stud_no=?,Stud_name=?,Birth_date=? and Join_date=?");
			ps.setInt(1,Stud_no);
			ps.setString(2, Stud_name);
			ps.setDate(3, birth_date);
			ps.setDate(4, join_date);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
			  s.setStud_no(rs.getInt(1));
			  s.setStud_name(rs.getString(2));
			  s.setBirth_date(rs.getDate(3));
			  s.setJoin_date(rs.getDate(4));
			}
					
			
			
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			
		}
		return s;
	}

	public static int save(Student s) {
		// TODO Auto-generated method stub
		return 0;
	}

}
