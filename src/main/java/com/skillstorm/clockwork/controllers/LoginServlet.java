package com.skillstorm.clockwork.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.skillstorm.clockwork.beans.Employee;
import com.skillstorm.clockwork.data.UserDao;

public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		UserDao userDao = new UserDao();
		
		String userName = req.getParameter("userName");
		String password = req.getParameter("password");
//		int User_Id = Integer.parseInt(req.getParameter("user_Id"));
		
		
		try {
			
			Employee Username = userDao.getUserName(userName, password);
			
			if (Username != null) {
				HttpSession session = req.getSession();
				session.setAttribute("Username", Username);
				RequestDispatcher dispatcher = req.getRequestDispatcher("/timesheet.html");
				dispatcher.forward(req, resp);

			} else {
				String message = "Invalid Username or Password";
				req.setAttribute("message", message);
			}
			

		}

		catch (ClassNotFoundException ex) {
			throw new ServletException(ex);
		}
	}
}