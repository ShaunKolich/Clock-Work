package com.skillstorm.clockwork.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet {

	TimeSheetController timeSheetController = new TimeSheetController();
	EmployeeController employeeController = new EmployeeController();

	protected void doDispatch(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();

		switch (uri) {
		case "/clockwork/api/employee":
			if (req.getMethod().equals("POST")) {
				employeeController.postUser(req, resp);
				return;
			} else if (req.getMethod().equals("GET")) {
				employeeController.getUserName(req, resp);

			}
		
			break;
		case "/clockwork/api/timesheet":
			if (req.getMethod().equals("POST")) {
				timeSheetController.postTimeSheet(req, resp);
				return;
			}
			if (req.getMethod().equals("PUT")) {
				timeSheetController.putTimeSheet(req, resp);
				return;
			}
			if (req.getMethod().equals("GET")) {
				timeSheetController.getTimeSheet(req, resp);
			}
			if (req.getMethod().equals("DELETE")) {
				timeSheetController.deleteTimeSheet(req, resp);
				return;
			}

			break;
		default:
			break;

		}

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doDispatch(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doDispatch(req, resp);
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doDispatch(req, resp);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doDispatch(req, resp);
	}

}
