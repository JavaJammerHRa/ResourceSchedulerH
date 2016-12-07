package com.ReourceEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name="user")
public class User {
	
	@Id
	//lets MySQL handle auto increment
	//assign primary keys using database identity columns
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="userId")
	private int userId;
	
	@Column(name="reservationId")
	private int reservationId;
	
	@Column(name="firstName")
	private String firstName;
	
	@Column(name="lastName")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	@Column(name="mac")
	private String mac;
	
	@Column(name="contactNo")
	private String contactNo;
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getReservationId() {
		return reservationId;
	}

	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	
	public User(){
		
	}

	public User(int reservationId, String firstName, String lastName, String email, String mac, String contactNo) {
		super();
		this.reservationId = reservationId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mac = mac;
		this.contactNo = contactNo;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", reservationId=" + reservationId + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email + ", mac=" + mac + ", contactNo=" + contactNo + "]";
	}
	
	
	
}
