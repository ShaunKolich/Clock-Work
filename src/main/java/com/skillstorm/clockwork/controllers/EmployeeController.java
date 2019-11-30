package com.skillstorm.clockwork.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.skillstorm.clockwork.beans.Employee;
import com.skillstorm.clockwork.service.EmployeeService;

//Employee Controller

public class EmployeeController {

	EmployeeService employeeService = new EmployeeService();

	public void getUserName(HttpServletRequest req, HttpServletResponse resp) {
		resp.setContentType("application/json");
		try {
			if (req.getParameter("user") != null && (req.getParameter("pass") != null)) {
				resp.getWriter().println(new ObjectMapper().writeValueAsString(
						employeeService.verifyAndGetUser(req.getParameter("userName"), req.getParameter("password"), resp)));
				resp.setStatus(201);
			} else {
				System.out.println("no user info");
			}
		} catch (Exception e) {
			resp.setStatus(401);
		}

	}

	public void postUser(HttpServletRequest req, HttpServletResponse resp)
			throws JsonParseException, JsonMappingException, IOException {
		resp.setContentType("application/json");
		
		resp.getWriter().println((new ObjectMapper().writeValueAsString
		(employeeService.verifyAndGetUserObj(new ObjectMapper().readValue(req.getInputStream(), Employee.class)))));	
		System.out.println("Employee Controller");	
			
		
	}

}
