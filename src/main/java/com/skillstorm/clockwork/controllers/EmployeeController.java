package com.skillstorm.clockwork.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skillstorm.clockwork.beans.Employee;
import com.skillstorm.clockwork.service.EmployeeService;

//Employee Controller

public class EmployeeController {

	EmployeeService employeeService = new EmployeeService();

	public void getUserName(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		resp.setContentType("application/json");
		if (req.getParameter("userName") != null && (req.getParameter("password") !=null)) {
			resp.getWriter().println(new ObjectMapper().writeValueAsString(
					employeeService.getUserName(req.getParameter("userName"), req.getParameter("password"))));
		}else {
			System.out.println("no user info");
		}
	}
}

