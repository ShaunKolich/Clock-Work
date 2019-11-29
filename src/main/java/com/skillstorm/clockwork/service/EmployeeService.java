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

	public Employee getEmployee(Employee employee) {

		Employee thisEmp = new Employee();
		if (userDao.verifyEmployee(employee.getUserName(), employee.getPassword())) {
			thisEmp = userDao.getEmployeeName(employee.getUserName(), employee.getPassword());

		}

		return thisEmp;
	}

	public Employee verifyAndGetUser(String userName, String password, HttpServletResponse resp) {
		Employee thisEmp = new Employee();
		if (userDao.verifyEmployee(userName, password)) {
			thisEmp = userDao.getEmployeeName(userName, password);
		} else {

			resp.setStatus(401);
		}
		return null;
	}
}
