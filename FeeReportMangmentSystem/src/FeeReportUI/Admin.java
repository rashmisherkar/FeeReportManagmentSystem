package FeeReportUI;

import java.util.List;
import java.util.Scanner;

import DaoImp.AdminDao;
import DaoImp.AdminDaoImp;
import DaoImp.AdminDaoImpF;
import Entity.AccountantPojo;


//check user selection fot the data operations on
public class Admin {
	static Scanner in;
    static AccountantPojo ap = new AccountantPojo();
    static AdminDao add;
    
    Admin(boolean flag) {
    	if(flag) add = new AdminDaoImp();
 		else add = new AdminDaoImpF();
 		in = new Scanner(System.in);		
 		while(!adminlogin());
 	}
		

	public boolean adminlogin()  {
			in = new Scanner(System.in);
		
			System.out.println("Admin Login\n");
			System.out.println("Name:");
			String name = in.nextLine();
		//	ap.setName(name);
			
			System.out.println("Password:");
			String password = in.nextLine();
		//	ap.setPassword(password);
			
			if(name.equals("admin") && password.equals("admin123")){ //validate name and password are equals
					System.out.println("Login Successfully\n");
					adminsection();
					
				}else {
						System.out.println("\"Sorry, username or password error!\n");
						FeeReport.Login();
					}
		return false;
	}

	public static void adminsection()  {
		int opt = 0;
		System.out.println("_____ADMIN SECTION_____");
		System.out.println("1:Add Acountant");
		System.out.println("2:View Acountant");
		System.out.println("3:Logout");
		try {
			 opt = in.nextInt();
		} catch (Exception e) {
			System.out.println("\n Select from above given respective inputs.\n");
		}
		
		switch(opt) {
		
		case 1: System.out.println("1:Add Acountant");	
				addAccountant();		//Add Accountant detals
				adminsection();
				break;
				
		case 2:System.out.println("2:View Acountant");	
				viewAccountant();		//Dispaly accountant details
				adminsection();
				break;
				
		
		case 3 :System.out.println("Logout");
				FeeReport.Login();		//back to login page
				adminsection();
				break;
				
		default: System.out.println("Enter correct number");
				 adminsection();
		
	}}
		
  public static void addAccountant() {	
		  
		  System.out.println("------ADD ACCOUNTANT-------");
		
		  System.out.println("Name : ");	//Enter Accountant Name
		  String name;
		  while(!(name = in.nextLine()).matches("[A-Za-z]+")) {
			System.out.print("\nInvalid name please re-enter : ");
		  }
		  ap.setName(name);
	
		  System.out.println("password : ");	//Enter Accountant Password
		  String password;
		  while(!((password = in.nextLine()).trim().length()>4)) {
			System.out.print("\nShort password re-enter : ");
		  }
		  ap.setPassword(password);
	
		  System.out.println("Email : ");	//Enter Accountant Email
		  String Email;
		  while(!(Email = in.nextLine()).matches("[A-Za-z0-9]+[@][a-z]+[.][a-z]+")) {
			System.out.print("\nInvalid email re-enter : ");
		  }
		  ap.setEmail(Email);
	
		  System.out.println("Contact No: ");	//Enter Accountant Contact no.
			String ContactNo ;
			while(!(ContactNo = in.nextLine()).trim().matches("[0-9]{10}")) {
			System.out.print("\nInvalid mobile : ");
			}
			ap.setContactNo(ContactNo);
			
			if(add.save(ap)) {
				System.out.print("\nAccountant added succesfully ...\n");
		//	}else System.err.print("\nError please try again later...\n");
	 }
 }
  

		public static void viewAccountant() {  		// Accountant details view
			System.out.println("\n---------View Accountant Details----------\n ");
			List<AccountantPojo> list = add.view(ap); //go to AccountantDaoImp for view details
			
			for(AccountantPojo a : list){
				System.out.println("Name:" +a.getName()+"\n");
				System.out.println("Password:" +a.getPassword()+"\n");
				System.out.println("Email:" +a.getEmail()+"\n");
				System.out.println("Contact NO:" +a.getContactNo()+"\n");
				System.out.println("\n");
			}

			
  	}	
		
}
