package com.skillstorm.clockwork.service;

import java.util.Set;

import com.skillstorm.clockwork.beans.TimeSheet;
import com.skillstorm.clockwork.data.TimeSheetDao;

public class TimesheetService {

	public TimeSheetDao timesheetDao = new TimeSheetDao();

	public void update(TimeSheet timesheet) {
		timesheetDao.update(timesheet);
	}

	public void delete(int User_Id) {
		timesheetDao.delete(User_Id);
	}

	public Set<TimeSheet> searchByEmployee(String UserName) {
		return timesheetDao.searchByEmployee(UserName);

	}

	public TimeSheet save(TimeSheet timesheet) {
		return timesheetDao.save(timesheet);
	}

	public Object getAllTimeSheet() {

		return timesheetDao.findAllTimeSheet();

	}

	public Object getUserTimeSheets(int index) {

		return timesheetDao.getTimeSheetById(index);

	}

	public void addNewTimesheet(int user, String parsedDate) {

		timesheetDao.addNewTimeSheet(user, parsedDate);

	}

}
