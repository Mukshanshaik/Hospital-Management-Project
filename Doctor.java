package com.hospital.mangament;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Doctor 
{
		private Connection connection;
		Scanner scanner = new Scanner(System.in);
		
		public Doctor(Connection connection)
		{
			this.connection = connection;
		}
		
		public void addDoctor() throws Exception
		{
			System.out.print("Enter Doctor Name: ");
			String name = scanner.next();
			
			System.out.print("Enter Department: ");
			String department = scanner.next();		
			
			String query = "insert into doctors(name ,department) values(?,? )";
			
		 try(PreparedStatement ps = connection.prepareStatement(query))
		 {
			 ps.setString(1,name);
			 ps.setString(2,department);
			 
			 if(ps.execute())
			 {
				 System.out.println("Doctor details add successfully");	 
			 }
			 else 
			{
				 System.out.println("Failed to add Doctor details");
			}
		 }
		
	  }	
		 
	public void viewDoctors() throws Exception
	{
		String query = "select * from doctors";
		
		try(PreparedStatement ps = connection.prepareStatement(query))
		{
			try(ResultSet rs = ps.executeQuery())
			{
				System.out.println("Doctor details : ");
				
				while(rs.next())
				{
					int id = rs.getInt("id");
					String name = rs.getString("name");
					String department = rs.getString("department");
					
					System.out.println("Doctor id :"+id);
					System.out.println("Doctor Name :"+name);
					System.out.println("Doctor department:"+department);

				}	
			}
		}
	}
		public boolean getDoctorById(int id) throws Exception
		{
			String query = "select count(1) from doctors where id = ?" ;
			
			try(PreparedStatement ps= connection.prepareStatement(query))
			{
				ps.setInt(1, id);
				
				try(ResultSet rs = ps.executeQuery())
				{
					return rs.next();
				}
			}
			
		}
	}
