package com.skillstorm.clockwork.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.skillstorm.clockwork.beans.TimeSheet;
import com.skillstorm.clockwork.data.TimeSheetDao;
import com.skillstorm.clockwork.service.TimesheetService;

public class TimeSheetController {

	private TimesheetService timeSheetService = new TimesheetService();

	public void postTimeSheet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		resp.getWriter().println(new ObjectMapper().writeValueAsString(
				timeSheetService.save(new ObjectMapper().readValue(req.getInputStream(), TimeSheet.class))));
		resp.setStatus(201);
	}

	public void putTimeSheet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		timeSheetService.update(new ObjectMapper().readValue(req.getInputStream(), TimeSheet.class));
		resp.setStatus(204);

	}

	public void deleteTimeSheet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		timeSheetService.delete(Integer.parseInt(req.getParameter("User_Id")));
		resp.setStatus(204);
	}

	public void getTimeSheet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		if (req.getParameter("UserName") != null) {
			resp.getWriter().println(new ObjectMapper()
					.writeValueAsString(timeSheetService.searchByEmployee(req.getParameter("UserName"))));

		}
	}

}
