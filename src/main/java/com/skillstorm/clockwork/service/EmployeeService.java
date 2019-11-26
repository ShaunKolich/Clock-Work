package com.skillstorm.clockwork.service;

import java.util.Set;

import com.skillstorm.clockwork.beans.Employee;
import com.skillstorm.clockwork.data.UserDao;

public class EmployeeService {

	private UserDao userDao = new UserDao();

	public Employee getUserName(String user, String pass) throws Exception {
		Employee employee = new Employee();

		if (userDao.verifyEmployee(user, pass)) {
			employee = userDao.getUserName(user, pass);
		}
		return employee;

	}

	public Set<Employee> getEmployeeName(String UserName) {
		return userDao.getEmployeeName(UserName);
	}

}
