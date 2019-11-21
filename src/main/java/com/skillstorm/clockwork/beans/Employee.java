package com.skillstorm.clockwork.beans;

//My employee model

public class Employee {
	private int user_Id;
	private String first_Name;
	private String last_Name;
	int hours;

	public Employee() {
		super();
	}

	public Employee(int user_Id, String first_Name, String last_Name, int hours) {
		super();
		this.user_Id = user_Id;
		this.first_Name = first_Name;
		this.last_Name = last_Name;
		this.hours = hours;
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

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((first_Name == null) ? 0 : first_Name.hashCode());
		result = prime * result + ((last_Name == null) ? 0 : last_Name.hashCode());
		result = prime * result + user_Id;
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
		return "Employee [user_Id=" + user_Id + ", first_Name=" + first_Name + ", last_Name=" + last_Name + ", hours="
				+ hours + "]";
	}

}