package Connectivity.Jdbc;
import java.sql.*; 

public class prepareStatement {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		String url= "jdbc:mysql://localhost:3307/aliens";
		//jdbc:mysql://localhost:3307/aliens?autoReconnect=true&useSSL=false
		String pass= "root";
		String uname ="Logic";
		int id = 5;
		String name = "Parth";
		//String query = "insert into student values (?,?)";
		String query = "delete from student where id = ?";
		Class.forName("com.mysql.jdbc.Driver");
		
		try {
		Connection con = DriverManager.getConnection(url,pass,uname);
		PreparedStatement st = con.prepareStatement(query);
		
		//st.setString(1, name);
		st.setInt(1, id);
		int count = st.executeUpdate();
		
		System.out.println(count+" row affected");
		st.close();
		con.close();
		
		}
		catch(Exception exe)
		{
			exe.printStackTrace();
		}
			
	}
}
