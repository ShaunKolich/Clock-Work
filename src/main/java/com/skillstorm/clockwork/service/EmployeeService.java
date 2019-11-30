package com.skillstorm.clockwork.service;

import javax.servlet.http.HttpServletResponse;

import com.skillstorm.clockwork.beans.Employee;
import com.skillstorm.clockwork.data.UserDao;

public class EmployeeService {

	private UserDao userDao = new UserDao();

	public boolean getUserName(String user, String pass) throws Exception {

		Employee employee = new Employee();

		if (userDao.verifyEmployee(user, pass)) {
			return true;
		}
		return false;

	}

	public Employee getEmployee(String UserName, String Pass) {

		Employee thisEmp = new Employee();
		if (userDao.verifyEmployee(UserName, Pass)) {
			thisEmp = userDao.getEmployeeName(UserName, Pass);

		}

		return thisEmp;
	}

	public Employee verifyAndGetUser(String username, String pass, HttpServletResponse resp) {
		Employee employee = new Employee();
		System.out.println("UserService, getuser called");
		System.out.println("usrName : " + username + " password: " + pass);
		
		if (userDao.verifyEmployee(username, pass)) {

			System.out.println("User verified in service");
			employee = userDao.getEmployeeName(username, pass);

		} else {
			resp.setStatus(401);
		}

		return null;

	}

	public Employee verifyAndGetUserObj(Employee emp) {
		Employee empl = new Employee();

//		System.out.println("UserService, getuser called");
		System.out.println("username : " + emp.getUserName() + " password: " + emp.getPassword());

		if (userDao.verifyEmployee(emp.getUserName(), emp.getPassword())) {

			System.out.println("employee Service");
			empl = userDao.getEmployeeName(emp.getUserName(), emp.getPassword());

		}

		return empl;

	}

	

	

}
