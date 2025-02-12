package com.hospital.mangament;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseService 
{
	
	public static Connection connection;
	
	private static Connection createConnection() throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital?useSSL=false","root","Muskhan@123");
		
		System.out.println("Database connection created successfully");
		
		return connection;
	}
    public static Connection getConnection() throws Exception
    {
	   if(connection == null)
	   {
		return createConnection();
	   }
	 return connection;
    }
}
