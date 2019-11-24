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

	public void postTimeSheet(HttpServletRequest req, HttpServletResponse resp) throws Throwable {
		
	}






}