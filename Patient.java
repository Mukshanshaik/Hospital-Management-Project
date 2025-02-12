package com.hospital.mangament;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.protocol.Resultset;

public class Patient 
{
	private Connection connection;
	Scanner scanner = new Scanner(System.in);
	
	public Patient(Connection connection)
	{
		this.connection = connection;
	}
	
	public void addPatient() throws Exception
	{
		System.out.print("Enter Patient Name: ");
		String name = scanner.next();
		
		System.out.print("Enter patient Age: ");
		int age = scanner.nextInt();
		
		System.out.print("Enter patient Gender:");
		String gender = scanner.next();		
		
		String query = "insert into patients(name ,age , gender) values(?,?,? )";
		
	 try(PreparedStatement ps = connection.prepareStatement(query))
	 {
		 ps.setString(1,name);
		 ps.setInt(2,age);
		 ps.setString(3,gender);
		 
		 if(ps.execute())
		 {
			 System.out.println("Patients details add successfully");	 
		 }
		 else 
		{
			 System.out.println("Failed to add Patients details");
		}
	 }
	
  }	
	 
public void viewPatients() throws SQLException
{
	String query = "select * from patients";
	try(PreparedStatement ps = connection.prepareStatement(query))
	{
		try(ResultSet rs = ps.executeQuery())
		{
			System.out.println("patients details : ");
			
			while(rs.next())
			{
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String gender = rs.getString("gender");
				
				System.out.println("patient id :"+id);
				System.out.println("patient Name :"+name);
				System.out.println("patient Age:"+age);
				System.out.println("patient Gender :"+gender);

			}	
		}
	}
}
	public boolean getPatientById(int id) throws Exception
	{
		String query = "select count(1) from patients where id = ?" ;
		
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
	

