package com.timeclock.model;

import java.sql.Date;

public class Employee {
	
	private String empId;
	
	private String dept;
	
	private String empName;
	
	private String city;
	
	private Date actualShiftStart;
	
	private Date actualShiftEnd;
	
	private Date shiftStart;
	
	private Date shiftEnd;
	
	private Date lunchStart;
	
	private Date lunchEnd;
	
	private Date breakStart;
	
	private Date breakEnd;
	
	private String empType;

	public String getEmpType() {
		return empType;
	}

	public void setEmpType(String empType) {
		this.empType = empType;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Date getShiftStart() {
		return shiftStart;
	}

	public void setShiftStart(Date shiftStart) {
		this.shiftStart = shiftStart;
	}

	public Date getShiftEnd() {
		return shiftEnd;
	}

	public void setShiftEnd(Date shiftEnd) {
		this.shiftEnd = shiftEnd;
	}

	public Date getLunchStart() {
		return lunchStart;
	}

	public void setLunchStart(Date lunchStart) {
		this.lunchStart = lunchStart;
	}

	public Date getLunchEnd() {
		return lunchEnd;
	}

	public void setLunchEnd(Date lunchEnd) {
		this.lunchEnd = lunchEnd;
	}

	public Date getBreakStart() {
		return breakStart;
	}

	public void setBreakStart(Date breakStart) {
		this.breakStart = breakStart;
	}

	public Date getBreakEnd() {
		return breakEnd;
	}

	public void setBreakEnd(Date breakEnd) {
		this.breakEnd = breakEnd;
	}

	public Date getActualShiftStart() {
		return actualShiftStart;
	}

	public void setActualShiftStart(Date actualShiftStart) {
		this.actualShiftStart = actualShiftStart;
	}

	public Date getActualShiftEnd() {
		return actualShiftEnd;
	}

	public void setActualShiftEnd(Date actualShiftEnd) {
		this.actualShiftEnd = actualShiftEnd;
	}	
}