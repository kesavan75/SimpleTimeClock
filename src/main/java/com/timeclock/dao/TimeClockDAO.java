package com.timeclock.dao;    

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.timeclock.model.Employee;

    
public class TimeClockDAO {    
JdbcTemplate template;    
    
public void setTemplate(JdbcTemplate template) {    
    this.template = template;    
}  

public Employee validateEmployee(String user, String pwd) {	
	String sql="select * from users where user_id=? and pwd=?";
	Employee emp = null;
	try {
	    emp = template.queryForObject(sql, new Object[]{user, pwd},new BeanPropertyRowMapper<Employee>(Employee.class));
	    if(emp != null && emp.getEmpId().length() > 0) {
	    	return emp;
	    }
	}
	catch(Exception e) {
		throw e;
	}
    
    return emp;	
}

public Employee startShift(String user) {
	Timestamp date = getDate();
	String sql="insert into employee_time_clock(user, actual_start_shift, db_date_added, db_date_modified) values('"+user+","+date+","+date+","+null+")";  
	Employee emp = new Employee();
	emp.setEmpId(user);
	emp.setActualShiftStart(new Date(date.getTime()));
	try {
		template.update(sql);
	}
	catch(Exception e) {
		throw e;
	}
	
    return emp;	
}

public Employee endShift(String user) {	
	Timestamp date = getDate();
	String sql="update employee_time_clock set actual_shift_end="+date+","+date+" where emp_id="+user;  
	Employee emp = new Employee();
	emp.setEmpId(user);
	emp.setActualShiftEnd(new Date(date.getTime()));
	
	try {
		template.update(sql);
	}
	catch(Exception e) {
		throw e;
	}
	
    return emp;	
}

public Employee startLunch(String user) {
	Timestamp date = getDate();
    String sql="update employee_time_clock set lunch_start_date="+date+", db_date_modified="+date+" where emp_id="+user;
    Employee emp = new Employee();
	emp.setEmpId(user);	
	emp.setLunchStart(new Date(date.getTime()));
	
	try {
		template.update(sql);
	}
	catch(Exception e) {
		throw e;
	}
	
    return emp;    
}

public Employee endLunch(String user) { 
	Timestamp date = getDate();
    String sql="update employee_time_clock set lunch_end_date="+date+", db_date_modified="+date+" where emp_id="+user;
    Employee emp = new Employee();
	emp.setEmpId(user);
	emp.setLunchEnd(new Date(date.getTime()));
	
	try {
		template.update(sql);
	}
	catch(Exception e) {
		throw e;
	}
    return emp;    
}

public Employee startBreak(String user) {	
	Timestamp date = getDate();
    String sql="update employee_time_clock set break_start_date="+date+", db_date_modified="+date+" where emp_id="+user;
    Employee emp = new Employee();
	emp.setEmpId(user);
	emp.setBreakStart(new Date(date.getTime()));
	
	try {
		template.update(sql);
	}
	catch(Exception e) {
		throw e;
	}
    return emp;    
}

public Employee endBreak(String user) {	
	Timestamp date = getDate();
    String sql="update employee_time_clock set break_end_date="+date+", db_date_modified="+date+" where emp_id="+user;
    Employee emp = new Employee();
	emp.setEmpId(user);
	emp.setBreakEnd(new Date(date.getTime()));
	
	try {
		template.update(sql);
	}
	catch(Exception e) {
		throw e;
	}
	
    return emp;    
}

public boolean checkIfShiftStarted(String user) { 
	Timestamp date = getDate();
    String sql="select * from employee_time_clock where emp_id="+user+" and trunc(actual_start_shift) = trunc(sysdate)";
    Employee emp = null;
	
	try {
		emp = template.queryForObject(sql, new Object[]{user},new BeanPropertyRowMapper<Employee>(Employee.class));
	}
	catch(Exception e) {
		throw e;
	}
	
    return true;    
}

public boolean checkIfLunchBreakStarted(String user) { 
	Timestamp date = getDate();
    String sql="select lunch_start_date, break_start_date from employee_time_clock where emp_id="+user+" and trunc(actual_start_shift) = trunc(sysdate)";
    Employee emp = null;
	
	try {
		emp = template.queryForObject(sql, new Object[]{user},new BeanPropertyRowMapper<Employee>(Employee.class));
	}
	catch(Exception e) {
		throw e;
	}
	
    return true;    
}

public List<Employee> report(String empId, String period, String timeclock) { 
	
	String sql = null;

	if(timeclock.equals("shift")) {
		if(sql.equals("1d")) {
			sql="select actual_start_shift, actual_end_shift from employee_time_clock where emp_id=? and trunc(actual_start_shift)=trunc(sysdate)";
		}
		else if(sql.equals("1w")) {
			sql="select actual_start_shift, actual_end_shift from employee_time_clock where emp_id=? and actual_start_shift >= DATEADD(day, 7, GETDATE())";
		}
		else if(sql.equals("1m")) {
			sql="select actual_start_shift, actual_end_shift from employee_time_clock where emp_id=? and actual_start_shift >= DATEADD(day, 30, GETDATE())";
		}
		else if(sql.equals("3m")) {
			sql="select actual_start_shift, actual_end_shift from employee_time_clock where emp_id=? and actual_start_shift >= DATEADD(day, 90, GETDATE())";
		}
	}
	else if(timeclock.equals("lunch")) {
		if(sql.equals("1d")) {
			sql="select lunch_start_date, lunch_end_date from employee_time_clock where emp_id=? and trunc(lunch_start_date)=trunc(sysdate)";
		}
		else if(sql.equals("1w")) {
			sql="select lunch_start_date, lunch_end_date from employee_time_clock where emp_id=? and lunch_start_date >= DATEADD(day, 7, GETDATE())";
		}
		else if(sql.equals("1m")) {
			sql="select lunch_start_date, lunch_end_date from employee_time_clock where emp_id=? and lunch_start_date >= DATEADD(day, 30, GETDATE())";
		}
		else if(sql.equals("3m")) {
			sql="select lunch_start_date, lunch_end_date from employee_time_clock where emp_id=? and lunch_start_date >= DATEADD(day, 90, GETDATE())";
		}
	}
	else if(timeclock.equals("break")) {
		if(sql.equals("1d")) {
			sql="select break_start_date, break_end_date from employee_time_clock where emp_id=? and trunc(break_start_date)=trunc(sysdate)";
		}
		else if(sql.equals("1w")) {
			sql="select break_start_date, break_end_date from employee_time_clock where emp_id=? and break_start_date >= DATEADD(day, 7, GETDATE())";
		}
		else if(sql.equals("1m")) {
			sql="select break_start_date, break_end_date from employee_time_clock where emp_id=? and break_start_date >= DATEADD(day, 30, GETDATE())";
		}
		else if(sql.equals("3m")) {
			sql="select break_start_date, break_end_date from employee_time_clock where emp_id=? and break_start_date >= DATEADD(day, 90, GETDATE())";
		}
	}
	
    List<Employee> empList = null;
	
	try {
		empList = template.query(sql, new Object[]{empId},new BeanPropertyRowMapper<Employee>(Employee.class));
	}
	catch(Exception e) {
		throw e;
	}
	
    return empList;    
}

private Timestamp getDate() {
	long now = System.currentTimeMillis();
    Timestamp sqlTimestamp = new Timestamp(now);
    return sqlTimestamp;
}
}