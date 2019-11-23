package com.skillstorm.clockwork.beans;

//My employee model

public class Employee {
	private String user_Id;
	private String first_Name;
	private String last_Name;
	private String userName;
	private String password;
	private String role_Id;
	

	public Employee() {
		super();
	}

	public Employee(String userName, String password, String user_Id) {
		super();
		this.userName = userName;
		this.password = password;
		this.user_Id = user_Id;
	}

	public Employee( String user_Id, String first_Name, String last_Name, String role_Id) {
		super();
		this.user_Id = user_Id;
		this.first_Name = first_Name;
		this.last_Name = last_Name;
		this.role_Id = role_Id;

	}

	public String getUser_Id() {
		return user_Id;
	}

	public void setUser_Id(String user_Id) {
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		int User_Id;
		result = prime * result + ((first_Name == null) ? 0 : first_Name.hashCode());
		result = prime * result + ((last_Name == null) ? 0 : last_Name.hashCode());
		User_Id = Integer.parseInt(user_Id);
		result = prime * result + User_Id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (first_Name == null) {
			if (other.first_Name != null)
				return false;
		} else if (!first_Name.equals(other.first_Name))
			return false;
		if (last_Name == null) {
			if (other.last_Name != null)
				return false;
		} else if (!last_Name.equals(other.last_Name))
			return false;
		if (user_Id != other.user_Id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [user_Id=" + user_Id + ", first_Name=" + first_Name + ", last_Name=" + last_Name + "]";
	}

}
