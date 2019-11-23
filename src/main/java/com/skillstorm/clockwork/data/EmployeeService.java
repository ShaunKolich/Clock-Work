package com.skillstorm.clockwork.data;

import java.util.Set;

import com.skillstorm.clockwork.beans.Employee;

public class EmployeeService {

	private UserDao userDao = new UserDao();

	public Set<Employee> getEmployeeName(String UserName) {
		return userDao.getEmployeeName(UserName);
	}
//Ask about this
	public Employee getUserName(String userName, String password) throws Exception {
		return userDao.getUserName(userName, password);
	}

}
