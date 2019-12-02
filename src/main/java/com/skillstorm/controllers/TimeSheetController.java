package com.skillstorm.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.skillstorm.javabeans.TimeSheet;
import com.skillstorm.service.TimeSheetService;

public class TimeSheetController {

	TimeSheetService timeSheetService = new TimeSheetService();

	public void getTimesheets(HttpServletRequest req, HttpServletResponse resp)
			throws JsonProcessingException, IOException {

		resp.setContentType("application/json");
		// System.out.println("test");
		if (req.getParameter("timesheetId") != null) {
			System.out.println("Timesheet controller: timesheetID != null");
			resp.getWriter().println(new ObjectMapper().writeValueAsString(
					timeSheetService.getTimeSheetById(Integer.parseInt(req.getParameter("timesheetId")))));
		} else if (req.getParameter("userId") != null) {
			resp.getWriter().println(new ObjectMapper().writeValueAsString(
					timeSheetService.getUserTimeSheets(Integer.parseInt(req.getParameter("userId")))));
			resp.setStatus(201);
			System.out.println("Timesheet controller: userID != null");

		} else {
			System.out.println("TimeSheetController: getTimesheets, userId null, retrieving all timesheets");
			resp.getWriter().println(new ObjectMapper().writeValueAsString(timeSheetService.getAllTimeSheet()));
			resp.setStatus(201);
		}

	}

	public void postTimeSheets(HttpServletRequest req, HttpServletResponse resp)
			throws JsonProcessingException, IOException {

		resp.setContentType("application/json");

		if (req.getParameter("userId") != null && req.getParameter("date") != null) {

			if (timeSheetService.dateExist(Integer.parseInt(req.getParameter("userId")), req.getParameter("date"))) {

			} else {
				timeSheetService.addNewTimesheet(Integer.parseInt(req.getParameter("userId")),
						req.getParameter("date"));
				resp.getWriter().println(new ObjectMapper().writeValueAsString(
						timeSheetService.getUserTimeSheets(Integer.parseInt(req.getParameter("userId")))));
				resp.setStatus(201);
			}

		} else { // return error
			resp.setStatus(402);

		}

	}

	public void putTimesheets(HttpServletRequest req, HttpServletResponse resp)
			throws JsonParseException, JsonMappingException, IOException {
		resp.setContentType("application/json");

		timeSheetService.update(new ObjectMapper().readValue(req.getInputStream(), TimeSheet.class));

	}

	public void deleteTimesheet(HttpServletRequest req, HttpServletResponse resp) {

		resp.setContentType("application/json");

		timeSheetService.deleteTimeSheet(Integer.parseInt(req.getParameter("timesheetId")));

	}

}
