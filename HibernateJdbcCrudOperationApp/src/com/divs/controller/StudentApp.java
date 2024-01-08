package com.divs.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.divs.model.Student;
import com.divs.service.IStudentService;
import com.divs.servicefactory.StudentServiceFactory;
import com.divs.util.HibernateUtil;

public class StudentApp {
static{
	HibernateUtil.startup();
}
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			System.out.println("1.Create");
			System.out.println("2.Read");
			System.out.println("3.Update");
			System.out.println("4.Delete");
			System.out.println("5.Exit5");
			System.out.println("enter your choice:1/2/3/4");
			String option=br.readLine();
			
			switch(option) {
			case "1":insertOperation();
				break;
			case "2":selectOperation();
				break;
			case "3":updateOperation();
				break;
			case "4":deleteOperation();
			break;
			case "5":System.out.println("Thanks fo using this app...");
		System.exit(1);
		break;
				
				default:System.out.println("Invalid option plz try again with valid input");
				break;
					
			}
		
		}
		
		//insertOperation();
		
		//selectOperation();
		
		//deleteOperation();
		
		//updateOperation();

	}

	private static void updateOperation() {
		IStudentService studentService=StudentServiceFactory.getStudentService();
		Scanner input=new Scanner(System.in);
		System.out.println("Enter the id for updation");
		int id=input.nextInt();
		System.out.println("Enter the new name to append");
		String name=input.next();
		System.out.println("enter the new age");
		int age=input.nextInt();
		System.out.println("enter the new address");
		String address=input.next();
		String message=studentService.updateById(id, name, age, address);
		if(message.equalsIgnoreCase("success")) {
			System.out.println("record updated successfully");
		}else {
			System.out.println("failed");
		}
		
	}

	private static void deleteOperation() {
		IStudentService studentService=StudentServiceFactory.getStudentService();
		Scanner input=new Scanner(System.in);
		System.out.println("Enter student id");
		int sid=input.nextInt();
		String message=studentService.deleteById(sid);
		if(message.equalsIgnoreCase("success")) {
			System.out.println("record deleted successfully");
		}else if(message.equalsIgnoreCase("not found")) {
			System.out.println("record not found for id::"+sid);
		}else {
			System.out.println("failed");
		}
		
		
	}

	private static void selectOperation() {
		
		IStudentService studentService=StudentServiceFactory.getStudentService();
		Scanner input=new Scanner(System.in);
		System.out.println("Enter student id");
		int sid=input.nextInt();
		Student student=studentService.findById(sid);
		if(student!=null) {
			System.out.println(student.getSid()+" "+student.getSname()+" "
					+student.getSage()+" "+student.getSddress());
		}else {
			System.out.println("record not found");
		}
	}

	private static void insertOperation() {
		IStudentService studentService=StudentServiceFactory.getStudentService();
	
		Scanner input=new Scanner(System.in);
		System.out.println("Enter name");
		String name=input.next();
		System.out.println("Enter age");
		int age=input.nextInt();
		System.out.println("Enter address");
		String address=input.next();
		String message=studentService.save(name, age, address);
	
		if(message.equalsIgnoreCase("success")) {
			System.out.println("inserted successfully");
		}else {
			System.out.println("insertion failed");
		}
	}

}
