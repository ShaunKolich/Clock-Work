package com.skillstorm.clockwork.beans;

public class TimeSheet {
	private int User_Id;
	private int End_Date;
	private double Mon_Hours;
	private double Tues_Hours;
	private double Weds_Hours;
	private double Thurs_Hours;
	private double Fri_Hours;
	private double Total_Hours;

	public TimeSheet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TimeSheet(int user_Id, int end_Date, int mon_Hours, int tues_Hours, int weds_Hours, int thurs_Hours,
			int fri_Hours, int total_Hours) {
		super();
		User_Id = user_Id;
		End_Date = end_Date;
		Mon_Hours = mon_Hours;
		Tues_Hours = tues_Hours;
		Weds_Hours = weds_Hours;
		Thurs_Hours = thurs_Hours;
		Fri_Hours = fri_Hours;
		Total_Hours = total_Hours;
	}

	public int getUser_Id() {
		return User_Id;
	}

	public int setUser_Id(int user_Id) {
		return user_Id;
	}

	public int getEnd_Date() {
		return End_Date;
	}

	public double setEnd_Date(int end_Date) {
		return end_Date;
	}

	public double getMon_Hours() {
		return Mon_Hours;
	}

	public void setMon_Hours(int mon_Hours) {
		Mon_Hours = mon_Hours;
	}

	public double getTues_Hours() {
		return Tues_Hours;
	}

	public void setTues_Hours(int tues_Hours) {
		Tues_Hours = tues_Hours;
	}

	public double getWeds_Hours() {
		return Weds_Hours;
	}

	public void setWeds_Hours(int weds_Hours) {
		Weds_Hours = weds_Hours;
	}

	public double getThurs_Hours() {
		return Thurs_Hours;
	}

	public void setThurs_Hours(int thurs_Hours) {
		Thurs_Hours = thurs_Hours;
	}

	public double getFri_Hours() {
		return Fri_Hours;
	}

	public double setFri_Hours(int fri_Hours) {
		return fri_Hours;
	}

	public double getTotal_Hours() {
		return Total_Hours;
	}

	public void setTotal_Hours(int total_Hours) {
		Total_Hours = total_Hours;
	}

	
}
