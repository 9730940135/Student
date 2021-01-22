package net.java.Student;

import com.mysql.jdbc.Connection;

import com.mysql.DriverManager;

public interface register extends Myprovider {
	
	static Connection Con=null;

	public static Connection getCon()
	{
		try {
		       Class.forName("com.mysql.jdbc.Driver");
			   Con=DriverManager.getConnection(ConnUrl,username,password);
			
		}
		catch(Exception e)
		{
			System.out.println(e); 
		}
		return Con;
	}
	

}
