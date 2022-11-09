package com.timeclock.model;

import java.util.List;

public class EmployeeTimeClockReport {
	
	private String empId;
	
	private String period;
	
	private String timeclock;
	
	private List<Employee> empList;

	public List<Employee> getEmp() {
		return empList;
	}

	public void setEmp(List<Employee> empList) {
		this.empList = empList;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getTimeclock() {
		return timeclock;
	}

	public void setTimeclock(String timeclock) {
		this.timeclock = timeclock;
	}
}