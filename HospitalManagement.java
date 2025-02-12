package com.hospital.mangament;

import java.sql.Connection;
import java.util.Scanner;

public class HospitalManagement
{

	public static void main(String[] args) throws  Exception
	{
		Scanner scanner = new Scanner (System.in);
			
		try(Connection connection = DatabaseService.getConnection())
		{
			Patient patient = new Patient(connection);
			Doctor doctor = new Doctor(connection);
			while(true)
			{
				System.out.println("=== Hospital Management System===");
				System.out.println("1.ADD Patient");
				System.out.println("2.ADD Doctor");
				System.out.println("3.View Patients");
				System.out.println("4.View Doctors");
				System.out.println("5.Book Appointment");
				System.out.println("6.Exit");

				System.out.println("Enter your choice: ");
				
				int choice  = scanner.nextInt();
				
				switch (choice) 
				{
				case 1:
					   patient. addPatient();
				break;
				
				case 2:
					   doctor.addDoctor();
				break;
				
				case 3:
					   patient.viewPatients();
				break;
				
				case 4:
					   doctor.viewDoctors();
				break;
				
				case 5:
					 //   Book appointment
				break;
				
				case 6:
					scanner.close();
					return ;
				default:
					   System.out.println("Please enter valid choice");
				 break ;
				}
			}
		}
	}

}
