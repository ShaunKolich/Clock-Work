package com.skillstorm.service;

import java.io.IOError;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletResponse;

import com.skillstorm.data.UserDao;
import com.skillstorm.javabeans.User;

public class UserService {
	
	UserDao userDao = new UserDao();
	

	
	public boolean verifyUser(String usrName, String password) {
		
		System.out.println("UserService: verifyUser: ");
		if(userDao.verifyUser(usrName, password)) {
			return true;
		}
		
		
		return false;
	}
	
	public User verifyAndGetUserByUserObj(User employee) {
		
		
		User user = new User();
		
		System.out.println("UserService, getuser called");
		System.out.println("usrName : " + employee.getUserName() + " password: " + employee.getPassword());
		
		if (userDao.verifyUser(employee.getUserName(), employee.getPassword() ) ){
			
			System.out.println("User verified in services");
			user = userDao.getUser(employee.getUserName() ,employee.getPassword());
			
			
		}
		
		
		return user;
		
		
	}

	public User verifyAndGetUser(String userName, String password, HttpServletResponse resp) {
		User user = new User();
		
		System.out.println("UserService, getuser called");
		System.out.println("usrName : " + userName + " password: " + password);
		
		if (userDao.verifyUser(userName, password)){
			
			System.out.println("User verified in service");
			user = userDao.getUser(userName, password);
			
		}
		else {
			resp.setStatus(401);
		}
		
		return null;
		
		
		
	}
	
	
	

}
