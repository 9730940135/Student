package net.java.Student;

import java.sql.Date;

public interface Studentdao {
	
		
		public  int insertStudent(Student s);
		

			public  Student getStudent(int Stud_no,String Stud_name,Date birth_date,Date join_date );
				
				
				
				
			
}


