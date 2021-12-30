package com.application.security;
import com.application.*;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="UserLogin")
public class User {
	@Id
	@Column(name="UserID")
	private long userID;
	@Column(name="email", nullable = false, unique=true)
	private String username;
	@Column(name = "password")
	private String password;
	
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="BusReservation", joinColumns={@JoinColumn(name="UserID", referencedColumnName="UserID")}
	, inverseJoinColumns={@JoinColumn(name="BusID", referencedColumnName="BusID")})
	private Set<BusSchedule> busSchedules;
	
	public long getUserID() {
		return userID;
	}
	public void UserID(long employeeID) {
		this.userID = employeeID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
