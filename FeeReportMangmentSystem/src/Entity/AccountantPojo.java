package Entity;

import java.io.Serializable;

public class AccountantPojo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String Id;
	private String name;
	private String password;
	private String Email;
	private String ContactNo;
	
	public String getId() {	//return variable id
		return Id;
	}

	public void setId(String id) {		//set value of variable id
		this.Id = id;					
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		this.Email = email;
	}

	public String getContactNo() {
		return ContactNo;
	}
	public void setContactNo(String contact) {
		this.ContactNo = contact;
	}

}
