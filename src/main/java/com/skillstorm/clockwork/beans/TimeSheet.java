package com.skillstorm.clockwork.beans;

public class TimeSheet {
	private int user_Id;
	private int end_Date;
	private double mon_Hours;
	private double tues_Hours;
	private double weds_Hours;
	private double thurs_Hours;
	private double fri_Hours;
	private double total_Hours;

	public TimeSheet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TimeSheet(int user_Id, int end_Date, double total_Hours) {
		super();
		this.user_Id = user_Id;
		this.end_Date = end_Date;
		this.total_Hours = total_Hours;
	}

	public TimeSheet(double mon_Hours, double tues_Hours, double weds_Hours, double thurs_Hours, double fri_Hours) {
		super();
		this.mon_Hours = mon_Hours;
		this.tues_Hours = tues_Hours;
		this.weds_Hours = weds_Hours;
		this.thurs_Hours = thurs_Hours;
		this.fri_Hours = fri_Hours;
	}

	public int getUser_Id() {
		return user_Id;
	}

	public int setUser_Id(int user_Id) {
		return user_Id;
	}

	public int getEnd_Date() {
		return end_Date;
	}

	public double setEnd_Date(int end_Date) {
		return end_Date;
	}

	public double getMon_Hours() {
		return mon_Hours;
	}

	public void setMon_Hours(double mon_Hours) {
		this.mon_Hours = mon_Hours;
	}

	public double getTues_Hours() {
		return tues_Hours;
	}

	public void setTues_Hours(double tues_Hours) {
		this.tues_Hours = tues_Hours;
	}

	public double getWeds_Hours() {
		return weds_Hours;
	}

	public void setWeds_Hours(double weds_Hours) {
		this.weds_Hours = weds_Hours;
	}

	public double getThurs_Hours() {
		return thurs_Hours;
	}

	public void setThurs_Hours(double thurs_Hours) {
		this.thurs_Hours = thurs_Hours;
	}

	public double getFri_Hours() {
		return fri_Hours;
	}

	public void setFri_Hours(double fri_Hours) {
		this.fri_Hours = fri_Hours;
	}

	public void setTotal_Hours(double total_Hours) {
		this.total_Hours = total_Hours;
	}

	public double getTotal_Hours() {
		return total_Hours;
	}

	public void setTotal_Hours(int total_Hours) {
		this.total_Hours = total_Hours;
	}

}
