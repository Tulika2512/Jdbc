package Connectivity.Jdbc;
import java.sql.*; 

//Java database Connectivity
/*
 * import class --> java.sql
 * load and register driver --> com.mysql.jdbc.driver
 * Create connection 
 * Create statement
 * Execute a query
 * Process results
 * close	
 */
public class demoClass {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		String url= "jdbc:mysql://localhost:3307/aliens";
		//jdbc:mysql://localhost:3307/aliens?autoReconnect=true&useSSL=false
		String pass= "root";
		String uname ="Logic";
		String query = "select * from student";
		Class.forName("com.mysql.jdbc.Driver");
		
		try {
		Connection con = DriverManager.getConnection(url,pass,uname);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);//for fetching
		//st.executeUpdate(query);//for inserting
		while(rs.next())
		{
			String result = rs.getString("name") +" " + rs.getString("id");
			System.out.println(result);
			}
		
		//String result = rs.getString("name");	
		//System.out.println("inserted");
		//System.out.println(result);
		
	
		st.close();
		con.close();
		
		}
		catch(Exception exe)
		{
			exe.printStackTrace();
		}
		
		
		
		
	}

}
