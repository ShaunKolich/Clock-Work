package com.skillstorm.clockwork.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet {
	 protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	            throws ServletException, IOException {
	        HttpSession session = req.getSession(false);
	        if (session != null) {
	            session.removeAttribute("Username");
	             
	            RequestDispatcher dispatcher = req.getRequestDispatcher("login.html");
	            dispatcher.forward(req, resp);
	        }
	    }
}
