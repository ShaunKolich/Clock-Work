package com.skillstorm.clockwork.beans;

import java.sql.ResultSet;
import java.sql.SQLException;

//My employee model

public class Employee {
	private int user_Id;
	private String first_Name;
	private String last_Name;
	private String userName;
	private String password;
	private String role_Id;
	

	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}


	public Employee(String userName, String password, int user_Id) {
		super();
		this.userName = userName;
		this.password = password;
		this.user_Id = user_Id;
	}

	public Employee( int user_Id, String first_Name, String last_Name, String role_Id) {
		super();
		this.user_Id = user_Id;
		this.first_Name = first_Name;
		this.last_Name = last_Name;
		this.role_Id = role_Id;

	}

	public Employee( ResultSet results) throws SQLException {
		user_Id = results.getInt("user_Id");
		userName = results.getString("userName");
		password = results.getString("password");
		first_Name = results.getString("first_Name");
		last_Name = results.getString("last_Name");
	    role_Id = results.getString("role_Id");
	}
	
	public int getUser_Id() {
		return user_Id;
	}

	public void setUser_Id(int user_Id) {
		this.user_Id = user_Id;
	}

	public String getFirst_Name() {
		return first_Name;
	}

	public void setFirst_Name(String first_Name) {
		this.first_Name = first_Name;
	}

	public String getLast_Name() {
		return last_Name;
	}

	public void setLast_Name(String last_Name) {
		this.last_Name = last_Name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole_Id() {
		return role_Id;
	}

	public void setRole_Id(String role_Id) {
		this.role_Id = role_Id;
	}

	@Override
	public String toString() {
		return "Employee [user_Id=" + user_Id + ", first_Name=" + first_Name + ", last_Name=" + last_Name + "]";
	}

}
