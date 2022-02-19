package FeeReportUI;

import java.util.Scanner;



public class FeeReport {
	static Scanner in;
	public static FeeReport feereport;
	static Admin admin;
	static Accountant accountant;
	private static boolean flag;

	
public FeeReport() {			//select db or file
		in = new Scanner(System.in);
		feereport = this;
		//boolean f = false;
		
		System.out.println("Select which type of project you want to do:");
		System.out.println("1.Database Connectivity");
		System.out.println("2.File Handling Connectivity\n");
		int opt;
		
		opt = in.nextInt(); 		//Enter opt to select
				
		switch(opt){
			case 1: flag = true;
			 		break;
		
			case 2: flag = false;
					break;
			
			default: System.out.println("Invalid");
					new FeeReport();
		 }
	
		if(flag) {
				System.out.println("You select type Database Connectivity.\n");
				Login();
				} else {
				// check connection established or not
				System.out.println("You select type File Handling Connectivity.\n");
					Login();
				}
			}

		
  public static void Login() {
	  	System.out.println("Fee Reports");
		System.out.println("1.Admin");
		System.out.println("2.Accountant");
		System.out.println("3.Back");
		
		int opt;
			opt = in.nextInt();
		switch(opt){
		case 1: admin = new Admin(flag);
			 	break;
			
		case 2: accountant = new Accountant(flag);
				break;
				
		case 3: new FeeReport();
		
		default: System.out.println("Invalid");
				 Login();
	}
  }
  public static void main(String[] args) {
	  new FeeReport();
 }
}
	
