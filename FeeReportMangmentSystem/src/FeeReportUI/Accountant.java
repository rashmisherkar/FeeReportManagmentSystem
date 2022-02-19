package FeeReportUI;


import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import DaoImp.AccountantDao;
import DaoImp.AccountantDaoimp;
import DaoImp.AccountantDaoimpF;
import Entity.AccountantPojo;
import Entity.StudentPojo;



public class Accountant {


	static Scanner in;
	static AccountantDao addac;
	static AccountantPojo aPojo=new AccountantPojo();
	static StudentPojo sPojo=new StudentPojo() ;
	
	public Accountant(boolean flag) {
		if(flag) addac = new AccountantDaoimp();
		else addac = new AccountantDaoimpF();
		in = new Scanner(System.in);
		while (!accountantlogin());
	}
	
	private boolean accountantlogin() {
		boolean flag = false;
		while (!flag) {
		System.out.println("Accountant Login");
		System.out.println("Name:");
		String name = in.nextLine();
		aPojo.setName(name);
		
		System.out.println("Password:");
		 String password = in.nextLine();
		aPojo.setPassword(password);
		
		if(addac.validate(name,password))
			{
				System.out.println("Accountant Login successfully!");
				  accountantsection();		
				 }else{
				 System.out.println("Accountant Login Unsuccessfull!");
			}
			FeeReport.Login();	
			}
		return false;	
	}
	
	
public static void accountantsection()  {

		System.out.println("------ACCOUNTANT SECTION------");
		System.out.println(" 1: Add Student ");
		System.out.println(" 2: view Student ");
		System.out.println(" 3: Edit Student ");
		System.out.println(" 4: Due Fee ");
		System.out.println(" 5: Logout ");
		int opt = 0;
		opt =  in.nextInt();
		
		//------------------ADD STUDENT-----------------------------------------------------
		switch(opt) {
		
		case 1 :System.out.println(" 1: Add Student ");
				addStudent();			//goto addStudent() method to enter student details
				accountantsection();
				break;
				
				
		case 2:	ViewStudent();		//fetch student details in viewstudent()
				System.out.println(" 2: view Student ");
				accountantsection();
				break;
				
		case 3: EditStudent();		//update student details
				System.out.println(" 3: Edit Student ");
				accountantsection();
				break;
				
		case 4: dueFee();			//display student whoes fees is remaining
				System.out.println(" 3: Due Fee ");
				accountantsection();
				break;
					
		case 5:System.out.println("\n\t.....Successfully Admin Logging Out......\n");
				FeeReport.Login();		//back to main login page
				accountantsection();
				break;
				
		default: System.out.println("Enter correct number");
				accountantsection();
			
			
		}
		}
	
public static void addStudent() {//Add student details
	boolean flag = false;
	
	System.out.println("------ADD STUDENT-------");
			
	System.out.println(" Enter Student RollNo : ");	//Enter Student Name
	int rollno = in.nextInt();
	sPojo.setRollno(rollno);
	
	System.out.println(" Enter Student Name : ");	//Enter Student Name
	String name;
	while (!(name = in.nextLine()).trim().matches("[A-Za-z ]+")) {
		System.out.print("\nInvalid re-enter : ");
	}
	sPojo.setName(name);
		

	System.out.println(" Enter Student Email : "); //Enter Student Email
	String email ;
	while (!(email = in.nextLine()).trim().matches("[A-Za-z0-9]+[@][a-z]+[.][a-z]+")) {
		System.out.print("Invalid e-mail re-enter : ");
	}
	sPojo.setEmail(email);
	
	System.out.println(" Enter Student Course : "); //Enter Student Course
    String course ;
    while (!(course =in.nextLine()).trim().matches("[A-Za-z]+")) {
		System.out.print("Invalid re-enter : ");
	}
    sPojo.setCourse(course);
	
	System.out.println(" Enter Student Batch Fees :");//Enter Student Fees
	while (!flag) {
	try {
		float fee =in.nextFloat();
		sPojo.setFee(fee);
		flag = true;
		} catch (InputMismatchException e) {
			System.out.println("Input valid amount : ");
		}
	}flag = false;
	
	System.out.println(" Enter Student Batch Paid : ");//Enter Student paid fees
		while (!flag) {
		try {
			float paid = in.nextFloat();
			sPojo.setPaid(paid);
			flag = true;
		} catch (InputMismatchException e) {
			System.err.println("Input valid amount : ");
		}
	}
   
		
		sPojo.setDue(sPojo.getFee() - sPojo.getPaid() ); // set due fee
	

		System.out.println(" Enter Student Address : ");//Enter Student Address
		String address;
	while (!(address = in.nextLine()).trim().matches("[A-Za-z0-9 -]+")) {
		System.out.print("Invalid characters re-enter : ");
	}
	sPojo.setAddress(address);
	
    

	System.out.println(" Enter Student City : ");//Enter Student city
	String city;
	while (!(city = in.nextLine()).trim().matches("[A-Za-z]+")) {
		System.out.print("Invalid characters re-enter : ");
	}
	sPojo.setCity(city);
	 
	System.out.println(" Enter Student State : ");//Enter Student State
	String state ;
	while (!(state  = in.nextLine()).trim().matches("[A-Za-z]+")) {
		System.out.print("Invalid characters re-enter : ");
	}
	sPojo.setState(state);
	
	System.out.println(" Enter Student Country : "); //Enter Student Country
	String country ;
	while (!(country  =in.nextLine()).trim().matches("[A-Za-z ]+")) {
		System.out.print("Invalid characters re-enter : ");
	}
	sPojo.setCountry(country);
	
	System.out.println(" Enter Student contact No.: "); //Enter Student Contact no
	 String contactno;
	 while (!(contactno  = in.nextLine()).trim().matches("[0-9]{10}")) {
			System.out.print("Invalid re-enter : ");
		}
	 sPojo.setContactno(contactno);
	
	 if(addac.save(sPojo)) {     //save student details 
			System.out.print("\nAccountant added succesfully ...\n");
		}else { //System.err.print("\nError please try again later...\n");
	}
	 	accountantsection(); //back to aacountantsection class
	}


	
	public static void ViewStudent(){
		System.out.println("\n---------View Student Details----------\n ");
		
		List<StudentPojo> list=addac.view(sPojo);
	
		for(StudentPojo s:list){
			System.out.println("RollNo:" +s.getRollno());
			System.out.println("Name:" +s.getName());
			System.out.println("Email:" +s.getEmail());
			System.out.println("Course:" +s.getCourse());
			System.out.println("Fee:" +s.getFee());
			System.out.println("Paid:" +s.getPaid());
			System.out.println("Due:" +s.getDue());
			System.out.println("Address:" +s.getAddress());
			System.out.println("City:" +s.getCity());
			System.out.println("state:" +s.getState());
			System.out.println("Country:" +s.getCountry());
			System.out.println("ContactNo:" +s.getContactno());
			System.out.println("\n");
		}
		accountantsection();
		}
		
	
	public static void EditStudent()  {
		boolean flag = false;
		while (!flag) {
			
			System.out.println(" Edit Student Details ");	
		
			System.out.println(" Enter Student RollNo : ");	//Enter Student Name
			sPojo.setRollno(in.nextInt());
			
			System.out.println(" Enter Student Name : ");	//Enter Student Name
			String name;
			while (!(name = in.nextLine()).trim().matches("[A-Za-z ]+")) {
			System.out.print("\nInvalid re-enter : ");
			}
			sPojo.setName(name);
			

			System.out.println(" Enter Student Email : "); //Enter Student Email
			String email ;
			while (!(email = in.nextLine()).trim().matches("[A-Za-z0-9]+[@][a-z]+[.][a-z]+")) {
			System.out.print("Invalid e-mail re-enter : ");
			}
			sPojo.setEmail(email);
		
			System.out.println(" Enter Student Course : "); //Enter Student Course
			String course ;
			while (!(course =in.nextLine()).trim().matches("[A-Za-z]+")) {
			System.out.print("Invalid re-enter : ");
			}
			sPojo.setCourse(course);
		
			System.out.println(" Enter Student Batch Fees :");//Enter Student Fees
			while (!flag) {
				try {
			float fee =in.nextFloat();
			sPojo.setFee(fee);
			flag = true;
			} catch (InputMismatchException e) {
				System.out.println("Input valid amount : ");
			}
			}flag = false;
		
			System.out.println(" Enter Student Batch Paid : ");//Enter Student paid fees
			while (!flag) {
			try {
				float paid = in.nextFloat();
				sPojo.setPaid(paid);
				flag = true;
			} catch (InputMismatchException e) {
				System.err.println("Input valid amount : ");
			}
			}
	   
			sPojo.setDue(sPojo.getFee() - sPojo.getPaid() ); // set due fee
		

			System.out.println(" Enter Student Address : ");//Enter Student Address
			String address;
			while (!(address = in.nextLine()).trim().matches("[A-Za-z0-9 -]+")) {
			System.out.print("Invalid characters re-enter : ");
			}
			sPojo.setAddress(address);
		
	    

			System.out.println(" Enter Student City : ");//Enter Student city
			String city;
			while (!(city = in.nextLine()).trim().matches("[A-Za-z]+")) {
			System.out.print("Invalid characters re-enter : ");
			}
			sPojo.setCity(city);
		 
			System.out.println(" Enter Student State : ");//Enter Student State
			String state ;
			while (!(state  = in.nextLine()).trim().matches("[A-Za-z]+")) {
			System.out.print("Invalid characters re-enter : ");
			}
			sPojo.setState(state);
		
			System.out.println(" Enter Student Country : "); //Enter Student Country
			String country ;
			while (!(country  =in.nextLine()).trim().matches("[A-Za-z ]+")) {
			System.out.print("Invalid characters re-enter : ");
			}
			sPojo.setCountry(country);
		
			System.out.println(" Enter Student contact No.: "); //Enter Student Contact no
			String contactno;
		 	while (!(contactno  = in.nextLine()).trim().matches("[0-9]{10}")) {
				System.out.print("Invalid re-enter : ");
			}
		 	sPojo.setContactno(contactno);
		 
		 if(addac.update(sPojo)) {     //update student details 
				System.out.print("\nAccountant updated succesfully ...\n");
			}else { //System.err.print("\nError please try again later...\n");
			}
			accountantsection();
		}
}
	
	
public static void dueFee()  {
		System.out.println("Due Fees");
		List<StudentPojo> list=addac.due(sPojo);
		
		for(StudentPojo s:list){
			System.out.println("RollNo:" +s.getRollno());
			System.out.println("Name:" +s.getName());
			System.out.println("Email:" +s.getEmail());
			System.out.println("Course:" +s.getCourse());
			System.out.println("Fee:" +s.getFee());
			System.out.println("Paid:" +s.getPaid());
			System.out.println("Due:" +s.getDue());
			System.out.println("Address:" +s.getAddress());
			System.out.println("City:" +s.getCity());
			System.out.println("State:" +s.getState());
			System.out.println("Country:" +s.getCountry());
			System.out.println("ContactNo:" +s.getContactno());
			System.out.println("\n");
		}
		accountantsection();
		}
	
}

	
	
	


	
	
		