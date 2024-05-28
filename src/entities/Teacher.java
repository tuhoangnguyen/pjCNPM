package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Teacher {
	private int teacherID;
	private int accountID;
	private String name;
	private Date dob;
	private String phone;
	private String email;
	private String image;

	public Teacher(int teacherID, int accountID, String name, Date dob, String phone, String email, String image) {
		super();
		this.teacherID = teacherID;
		this.accountID = accountID;
		this.name = name;
		this.dob = dob;
		this.phone = phone;
		this.email = email;
		this.image = image;
	}
	public Teacher() {
		super();
	}
	public int getTeacherID() {
		return teacherID;
	}
	public void setTeacherID(int teacherID) {
		this.teacherID = teacherID;
	}
	public int getAccountID() {
		return accountID;
	}
	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "Teacher [teacherID=" + teacherID + ", accountID=" + accountID + ", name=" + name + ", dob=" + dob
				+ ", phone=" + phone + ", email=" + email + ", image=" + image + "]";
	}

	
	
}
