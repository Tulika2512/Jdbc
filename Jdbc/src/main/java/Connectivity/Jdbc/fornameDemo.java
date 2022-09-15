package Connectivity.Jdbc;

import java.sql.DriverManager;
import java.sql.SQLException;

public class fornameDemo 
{

	public static void main(String[] args) throws Exception 
		{
	
			//pqr obj = new pqr();
		    //Class.forName("Connectivity.Jdbc.pqr");
			//Class.forName("Connectivity.Jdbc.pqr").newInstance();
		    DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		}
}
	
class pqr
{
	//static block
	static 
	{
		System.out.println("static block");
	}
	
	//instance block
	{
		System.out.println("instance block");
	}
}


