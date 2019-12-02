package com.skillstorm.javabeans;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class TimeSheet {

	float monHours, tueHours, wedHours, thuHours, friHours, totalHours;
	int timeSheetId, userId, statusId;
	Date endDate;

	public TimeSheet() {

	}

	public TimeSheet(ResultSet results) throws SQLException {

		timeSheetId = results.getInt("timeSheetId");
		userId = results.getInt("userId");
		statusId = results.getInt("statusId");
		monHours = results.getFloat("monHours");
		tueHours = results.getFloat("tueHours");
		wedHours = results.getFloat("wedHours");
		thuHours = results.getFloat("thuHours");
		friHours = results.getFloat("friHours");
		endDate = results.getDate("endDate");
		System.out.println("Read the Java Beans");

	}

	public TimeSheet(int timeSheetId, int userId, int statusId) {
		this.timeSheetId = timeSheetId;
		this.userId = userId;
		this.statusId = statusId;
	}

	public float getMonHours() {
		return monHours;
	}

	public void setMonHours(float monHours) {
		this.monHours = monHours;
	}

	public float getTueHours() {
		return tueHours;
	}

	public void setTueHours(float tueHours) {
		this.tueHours = tueHours;
	}

	public float getWedHours() {
		return wedHours;
	}

	public void setWedHours(float wedHours) {
		this.wedHours = wedHours;
	}

	public float getThuHours() {
		return thuHours;
	}

	public void setThuHours(float thuHours) {
		this.thuHours = thuHours;
	}

	public float getFriHours() {
		return friHours;
	}

	public void setFriHours(float friHours) {
		this.friHours = friHours;
	}

	public int getTimeSheetId() {
		return timeSheetId;
	}

	public void setTimeSheetId(int timeSheetId) {
		this.timeSheetId = timeSheetId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public void calcTotalHours() {
		totalHours = monHours + tueHours + wedHours + thuHours + friHours;
	}

	public float getTotalHours() {
		return totalHours;
	}

	@Override
	public String toString() {
		return "TimeSheet [monHours=" + monHours + ", tueHours=" + tueHours + ", wedHours=" + wedHours + ", thuHours="
				+ thuHours + ", friHours=" + friHours + ", totalHours=" + totalHours + ", timeSheetId=" + timeSheetId
				+ ", userId=" + userId + ", statusId=" + statusId + ", endDate=" + endDate + "]";
	}

}
