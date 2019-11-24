package com.skillstorm.clockwork.data;

import java.util.Set;

import com.skillstorm.clockwork.beans.TimeSheet;

public class TimesheetService {

	public TimeSheetDao timesheetDao = new TimeSheetDao();
	
	public void update(TimeSheet timesheet) {
		timesheetDao.update(timesheet);
	}
	
	public void delete(int User_Id) {
		timesheetDao.delete(User_Id);
	}
	
	public Set<TimeSheet> searchByEmployee(String UserName){
		return timesheetDao.searchByEmployee(UserName);
		
	}
	
	public TimeSheet save(TimeSheet timesheet) {
		return timesheetDao.save(timesheet);
	}
	
	
	
	
	
}
