package DaoImp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entity.StudentPojo;
import FeeReportUI.FeeReport;

public class AccountantDaoimp implements AccountantDao {
	
	StudentPojo sPojo = new StudentPojo();

	public static Connection getCon(){
		Connection Connection=null;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver"); //Connecting to MYSQL using JDBC Driver
			Connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/Fee","root","Atkar@2021"); 	
		}catch(Exception e){System.out.println(e);}
		return Connection;
	}
	
	public boolean validate(String name,String password){ //login 
		boolean status=false;
		try{
			Connection  Connection=getCon();
			PreparedStatement ps= Connection.prepareStatement("select * from accountant where name=? and password=?");
			ps.setString(1,name);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			status=rs.next();
			//System.out.println("Accountant Login successfully!");
			 Connection.close();
		}catch(Exception e){System.out.println(e);
		//System.out.println("Accountant Login Unsuccessfull!");}
		}
	return status;
}
	
	public boolean save(StudentPojo sPojo){
		boolean status= false;
		try{
			Connection Connection = AccountantDaoimp.getCon();
			
			PreparedStatement ps=Connection.prepareStatement("insert into student(rollno,name,email,course,fee,paid,due,address,city,state,country,contactno) values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setInt(1,sPojo.getRollno());
			ps.setString(2,sPojo.getName());
			ps.setString(3,sPojo.getEmail());
			ps.setString(4, sPojo.getCourse());
			ps.setFloat(5,sPojo.getFee());
			ps.setFloat(6,sPojo.getPaid());
			ps.setFloat(7,sPojo.getDue());
			ps.setString(8,sPojo.getAddress());
			ps.setString(9,sPojo.getCity());
			ps.setString(10,sPojo.getState());
			ps.setString(11,sPojo.getCountry());
			ps.setString(12,sPojo.getContactno());
			
		
			ps.execute();
			Connection.close();
			System.out.println("Student Added Succeddfully ");
		}catch(Exception e){System.out.println(e);
		System.out.println("Student Details Not Added Succeddfully ");}
		return status;
	}
	
	
	public boolean update(StudentPojo sPojo){
		boolean status=false;
		try{
			
			Connection con = AccountantDaoimp.getCon();
			
			PreparedStatement ps=con.prepareStatement("update student set name=?,email=?,course=?,fee=?,paid=?,due=?,address=?,city=?,state=?,country=?,contactno=? where rollno=?");
		
			ps.setString(1,sPojo.getName());
			ps.setString(2,sPojo.getEmail());
			ps.setString(3, sPojo.getCourse());
			ps.setFloat(4,sPojo.getFee());
			ps.setFloat(5,sPojo.getPaid());
			ps.setFloat(6,sPojo.getDue());
			ps.setString(7,sPojo.getAddress());
			ps.setString(8,sPojo.getCity());
			ps.setString(9,sPojo.getState());
			ps.setString(10,sPojo.getCountry());
			ps.setString(11,sPojo.getContactno());
			ps.setInt(12,sPojo.getRollno());
			ps.execute();
			con.close();
			System.out.println("Student updated successfully!");
		
			}catch(Exception e){System.out.println(e);
			System.out.println("Sorry, Unable to add student!");
		}
		return status;
	}
	
	
	public ArrayList<StudentPojo> view(StudentPojo sPojo){
		ArrayList<StudentPojo> list=new ArrayList<StudentPojo>();
		try{
			Connection con=AccountantDaoimp.getCon();
			PreparedStatement ps=con.prepareStatement("select * from student");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				StudentPojo s = new StudentPojo();
				s.setRollno(rs.getInt("rollno"));
				s.setName(rs.getString("name"));
				s.setEmail(rs.getString("email"));
				s.setCourse(rs.getString("course"));
				s.setFee(rs.getInt("fee"));
				s.setPaid(rs.getInt("paid"));
				s.setDue(rs.getInt("due"));
				s.setAddress(rs.getString("address"));
				s.setCity(rs.getString("city"));
				s.setState(rs.getString("state"));
				s.setCountry(rs.getString("country"));
				s.setContactno(rs.getString("contactno"));
				list.add(s);
		}
			con.close();
	}catch(Exception e){System.out.println(e);}
		return list;
	}
	
	
	public List<StudentPojo> due(StudentPojo sPojo) {
		List<StudentPojo> list=new ArrayList<StudentPojo>();
		
		try{
			Connection Connection=AccountantDaoimp.getCon();
			PreparedStatement ps=Connection.prepareStatement("select * from Student where due>0");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				StudentPojo s = new StudentPojo();
				
				s.setRollno(rs.getInt("rollno"));
				s.setName(rs.getString("name"));
				s.setEmail(rs.getString("email"));
				s.setCourse(rs.getString("course"));
				s.setFee(rs.getInt("fee"));
				s.setPaid(rs.getInt("paid"));
				s.setDue(rs.getInt("due"));
				s.setAddress(rs.getString("address"));
				s.setCity(rs.getString("city"));
				s.setState(rs.getString("state"));
				s.setCountry(rs.getString("country"));
				s.setContactno(rs.getString("contactno"));
				list.add(s);
			}
			Connection.close();
		}catch(Exception e){System.out.println(e);}
		return list;
	}
	
}

