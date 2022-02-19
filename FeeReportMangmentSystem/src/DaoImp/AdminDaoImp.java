package DaoImp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Entity.AccountantPojo;

public class AdminDaoImp implements AdminDao {

	public static Connection getCon(){
		Connection Connection=null;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver"); //Connecting to MYSQL using JDBC Driver
			Connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/Fee","root","Atkar@2021"); 	
		}catch(Exception e){System.out.println(e);}
		return Connection;
	}

	public boolean save(AccountantPojo ap){		//Accountant details Save in database
		boolean status= false;
		try{
			Connection Connection=getCon();
			PreparedStatement ps=Connection.prepareStatement("insert into accountant(name,password,email,contactno) values(?,?,?,?)");
		
			ps.setString(1,ap.getName());
			ps.setString(2,ap.getPassword());
			ps.setString(3,ap.getEmail());
			ps.setString(4,ap.getContactNo());
			ps.execute();
			System.out.println("Accountant added successfully!");
			
			Connection.close();
			
		}catch(Exception e){
			System.out.println(e);
			System.out.println("Sorry, Unable to add Accountant!");
		}
		return status;
	}
	
	
	public List<AccountantPojo> view(AccountantPojo ap){		//fetch accountantant detals from database
		List<AccountantPojo> list=new ArrayList<>();
		try{
		Connection Connection=getCon();
		PreparedStatement ps=Connection.prepareStatement("select * from accountant");
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
		
			AccountantPojo ap1 = new AccountantPojo();
			ap1.setName(rs.getString(1));
			ap1.setPassword(rs.getString(2));
			ap1.setEmail(rs.getString(3));
			ap1.setContactNo(rs.getString(4));
			list.add(ap1);	
		}
		Connection.close();
		}catch(Exception e){System.out.println(e);}
		return list;
		
		
	}
}
	
	

