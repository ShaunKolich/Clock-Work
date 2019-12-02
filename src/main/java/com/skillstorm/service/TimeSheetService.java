package com.skillstorm.service;

import com.skillstorm.data.TimeSheetDAO;
import com.skillstorm.javabeans.TimeSheet;
import com.skillstorm.javabeans.User;

public class TimeSheetService {

	TimeSheetDAO t = new TimeSheetDAO();

	public Object getAllTimeSheet() {

		return t.findAllTimeSheet();

	}

	public Object getUserTimeSheets(int i) {
		System.out.println("I equals" + i);
		return t.findTimeSheetsByUser(i);

	}

	public void addNewTimesheet(int usr, String parsedDate) {

		System.out.println("TimesheetService: add new timesheet called");
		t.addNewTimeSheet(usr, parsedDate);

	}

	public void update(TimeSheet readValue) {
		// TODO Auto-generated method stub
		System.out.println("Timesheet Service, Update called, Timesheet: " + readValue);
		t.save(readValue);

	}

	public Object getTimeSheetById(int i) {

		System.out.println("GetTimeSheetById called in service: ");
		return t.getTimeSheetById(i);
	}

	public void deleteTimeSheet(int i) {
		System.out.println("timesheet service, delete called: ");
		t.deleteTimeSheet(i);
	}

	public boolean dateExist(int i, String d) {

		return t.dateExist(i, d);
	}

}