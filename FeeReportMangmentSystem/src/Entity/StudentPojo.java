package Entity;

import java.io.Serializable;

public class StudentPojo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	float fee,paid,due;
	int rollno;
	String name,email,course,address,city,state,country,contactno;

public int getRollno() {
	return rollno;
}
public void setRollno(int rollno) {
	this.rollno = rollno;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getCourse() {
	return course;
}
public void setCourse(String course) {
	this.course = course;
}
public float getFee() {
	return fee;
}
public void setFee(float fee) {
	this.fee = fee;
}
public float getPaid() {
	return paid;
}
public void setPaid(float paid) {
	this.paid = paid;
}
public float getDue() {
	return due;
}
public void setDue(float due) {
	this.due = due;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
public String getContactno() {
	return contactno;
}
public void setContactno(String contactno) {
	this.contactno = contactno;
}

}
