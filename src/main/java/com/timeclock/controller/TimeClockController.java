package com.timeclock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.timeclock.model.Employee;
import com.timeclock.model.EmployeeTimeClockReport;
import com.timeclock.service.TimeClockService;

@Controller
@RequestMapping("/SimpleTimeClock")
public class TimeClockController {

	@RequestMapping("/login")
	public ModelAndView validateEmployee (
			@RequestParam(value = "name-input", required = true) String user,
			@RequestParam(value = "password-input", required = true) String pwd) {
				
		TimeClockService service = new TimeClockService();
		Employee emp = service.validateEmployee(user, pwd);
		ModelAndView mv = null;
		if(emp != null) {
			mv.addObject("EmpType", emp.getEmpType());
			mv = new ModelAndView("timeclock");
		}
		else {
			mv = new ModelAndView("login"); 
			mv.addObject("message", "Username or password provided is not correct");
		}
		
		return mv;
	}
	
	@RequestMapping("/startShift")
	public ModelAndView startShift (
			@RequestParam(value = "user", required = true) String user) {
				
		TimeClockService service = new TimeClockService();
		ModelAndView mv = null;
		
		try {
			boolean shiftStarated = service.checkIfShiftStarted(user);			
			if(shiftStarated) {
				mv = new ModelAndView("timeclock");
				mv.addObject("message", "You already started shift");
				return mv;
			}
			
			Employee emp = service.startShift(user);
			if(emp != null) {
				mv = new ModelAndView("timeclock");
				mv.addObject("message", "You started the shift");
			}
		}
		catch(Exception e) {
			//Log
			System.out.println(e.getMessage());
		}
		
		return mv;
	}
	
	@RequestMapping("/endShift")
	public ModelAndView endShift (
			@RequestParam(value = "user", required = true) String user) {
				
		TimeClockService service = new TimeClockService();
		ModelAndView mv = null;
		
		try {
			if(!service.checkIfLunchBreakStarted(user)) {
				Employee emp = service.endShift(user);
				if(emp.getActualShiftEnd() != null) {					
					mv = new ModelAndView("timeclock");
					mv.addObject("message", "Your shift ended");
					return mv;
				}
			}
			else {
				mv = new ModelAndView("timeclock");
				mv.addObject("message", "Your lunch or break is active");
			}
		}
		catch(Exception e) {
			//Log
			System.out.println(e.getMessage());
		}
		
		return mv;
	}
	
	@RequestMapping("/startLunch")
	public ModelAndView startLunch (
			@RequestParam(value = "user", required = true) String user) {
				
		TimeClockService service = new TimeClockService();
		ModelAndView mv = null;
		
		try {
				if(service.checkIfShiftStarted(user)) {
					Employee emp = service.startLunch(user);
					if(emp != null && emp.getLunchStart() != null) {					
						mv = new ModelAndView("timeclock");
						mv.addObject("message", "You lumch time started");
						return mv;
					}						
				}
		}
		catch(Exception e) {
			//Log
			System.out.println(e.getMessage());
		}
		
		return mv;
	}
	
	@RequestMapping("/endLunch")
	public ModelAndView endLunch (
			@RequestParam(value = "user", required = true) String user) {
				
		TimeClockService service = new TimeClockService();
		ModelAndView mv = null;
		
		try {				
			if(service.checkIfShiftStarted(user)) {
				Employee emp = service.endLunch(user);				
				if(emp != null && emp.getLunchEnd() != null) {					
					mv = new ModelAndView("timeclock");
					mv.addObject("message", "You lumch time ended");
					return mv;
				}
			}
		}
		catch(Exception e) {
			//Log
			System.out.println(e.getMessage());
		}
		
		return mv;
	}
	
	@RequestMapping("/startBreak")
	public ModelAndView startBreak (
			@RequestParam(value = "user", required = true) String user) {
				
		TimeClockService service = new TimeClockService();
		ModelAndView mv = null;
		
		try {
			if(service.checkIfShiftStarted(user)) {
				Employee emp = service.startBreak(user);				
				if(emp != null && emp.getBreakStart() != null) {					
					mv = new ModelAndView("timeclock");
					mv.addObject("message", "You break time started");
					return mv;
				}
			}
		}
		catch(Exception e) {
			//Log
			System.out.println(e.getMessage());
		}
		
		return mv;
	}
	
	@RequestMapping("/endBreak")
	public ModelAndView endBreak (
			@RequestParam(value = "user", required = true) String user) {
				
		TimeClockService service = new TimeClockService();
		ModelAndView mv = null;
		
		try {
			if(service.checkIfShiftStarted(user)) {
				Employee emp = service.endBreak(user);				
				if(emp != null && emp.getBreakEnd() != null) {					
					mv = new ModelAndView("timeclock");
					mv.addObject("message", "Your break time ended");
					return mv;
				}					
			}
		}
		catch(Exception e) {
			//Log
			System.out.println(e.getMessage());
		}
		
		return mv;
	}
	
	@RequestMapping("/report")
	public ModelAndView report (
			@RequestParam(value = "empId", required = true) String empId,
			@RequestParam(value = "period", required = true) String period,
			@RequestParam(value = "timeclock", required = true) String timeclock) {
				
		TimeClockService service = new TimeClockService();
		ModelAndView mv = null;
		
		try {				
				EmployeeTimeClockReport tcReport = service.report(empId, period, timeclock);				
				if(tcReport != null) {					
					mv = new ModelAndView("timeclock");
					mv.addObject("reportlist", tcReport);
					return mv;
				}					
		}
		catch(Exception e) {
			//Log
			System.out.println(e.getMessage());
		}
		
		return mv;
	}
}