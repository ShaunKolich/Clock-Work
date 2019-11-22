package com.skillstorm.clockwork.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletController extends HttpServlet {

	private EmployeeController employeeController = new EmployeeController();

	protected void doDispatch(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uri = req.getRequestURI();

		switch (uri) {
		case "/clockwork/api/employee":
			if (req.getMethod().equals("POST")) {

				return;
			}
			if (req.getMethod().equals("PUT")) {

				return;
			}
			if (req.getMethod().equals("GET")) {

				return;
			}
			if (req.getMethod().equals("DELETE")) {
				;
				return;
			}

		default:
			break;
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doDispatch(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doDispatch(req, resp);
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doDispatch(req, resp);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doDispatch(req, resp);
	}

	@Override
	public void init() throws ServletException {
		System.out.println("Servlet Working!");
	}
}
