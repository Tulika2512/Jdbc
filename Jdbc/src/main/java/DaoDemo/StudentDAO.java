package DaoDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentDAO {
	
	String url= "jdbc:mysql://localhost:3307/aliens";
	
	Connection con = null;
	
	public void connect() throws ClassNotFoundException, SQLException

	{
		String pass= "root";
		String uname ="Logic";
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url,pass,uname);
		System.out.println("Connection successful");
		
	}
	
	public void getname(int rollno) throws ClassNotFoundException, SQLException
	{
		Student s = new Student();
		s.rollno = rollno;
		String result = null;
		//connect();
		String query = "select name from student where id =" + rollno;

		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			rs.next();
			result = rs.getString("name");
			//s.sname = result;
			
			st.close();
			con.close();
			
		}
		catch(Exception exe)
		{
			exe.printStackTrace();
		}
		System.out.println("Data fetched");
		System.out.println("name"+" "+result);
		
		
	}

	public Student addStudent(Student s) throws ClassNotFoundException
	{
		
		String query = "insert into student values (?,?)";
		
		try {
			
			PreparedStatement st = con.prepareStatement(query);
			//ResultSet rs = st.executeQuery();
			st.setInt(2, s.rollno);
			st.setString(1,s.sname);
			st.executeUpdate();
			st.close();
			con.close();
			
		}
		catch(Exception exe)
		{
			exe.printStackTrace();
		}
		
		System.out.println("Data inserted");
		return s;
		
		
		
	}

	public void deleteStudent(int rollno)
	{
		
			Student s = new Student();
			s.rollno = rollno;
			String result = null;
			String query = "delete from student where id = ?";
	
			try {
				PreparedStatement st = con.prepareStatement(query);
				
				//st.setString(1, name);
				st.setInt(1, rollno);
				int count = st.executeUpdate();
				
				System.out.println(count+" row deleted");
				st.close();
				con.close();
				
			}
			catch(Exception exe)
			{
				exe.printStackTrace();
			}
			
			
		
		
	}

}

