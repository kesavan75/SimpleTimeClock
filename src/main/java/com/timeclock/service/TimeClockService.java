package com.timeclock.service;

import java.util.List;

import com.timeclock.dao.TimeClockDAO;
import com.timeclock.model.Employee;
import com.timeclock.model.EmployeeTimeClockReport;

public class TimeClockService {
	
	TimeClockDAO dao = new TimeClockDAO();
	
	public Employee validateEmployee(String user, String pwd) {
		
		return dao.validateEmployee(user, pwd);		
	}
	
	public Employee startShift(String user) {
		
		return dao.startShift(user);
	}

	public Employee endShift(String user) {
			
		return dao.endShift(user);			
	}
	
	public Employee startLunch(String user) {
			
		return dao.startLunch(user);
	}
	
	public Employee endLunch(String user) {
			
		return dao.endLunch(user);
	}
	
	public Employee startBreak(String user) {
		
		return dao.startBreak(user);
	}
	
	public Employee endBreak(String user) {
			
		return dao.endBreak(user);
	}
	
	public boolean checkIfLunchBreakStarted(String user) {
		
		return dao.checkIfLunchBreakStarted(user);		
	}
	
	public boolean checkIfShiftStarted(String user) {
		
		return dao.checkIfShiftStarted(user);		
	}
	
	public EmployeeTimeClockReport report(String empId, String period,
			String timeclock) {		
		List<Employee> empList = dao.report(empId, period, timeclock);
		EmployeeTimeClockReport empTimeClockReport = new EmployeeTimeClockReport();
		empTimeClockReport.setEmpId(empId);
		empTimeClockReport.setPeriod(period);
		empTimeClockReport.setTimeclock(timeclock);
		empTimeClockReport.setEmp(empList);
		
		return empTimeClockReport;
	}
}
