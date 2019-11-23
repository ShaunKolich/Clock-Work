package com.skillstorm.clockwork.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skillstorm.clockwork.beans.Employee;
import com.skillstorm.clockwork.data.UserDao;

//Employee Controller

public class EmployeeController {

	private UserDao userDao = new UserDao();
	
	//Convert to JSON the User INFO
	
	public void getEmployee (HttpServletRequest req, HttpServletResponse res) {
		res.setContentType("application/json");
		if (req.getParameter ("Username") != null){
//			res.getWriter().println(
//					new ObjectMapper().writeValueAsString(Employee.(req.getParameter("name"))));
		}
	}

}
