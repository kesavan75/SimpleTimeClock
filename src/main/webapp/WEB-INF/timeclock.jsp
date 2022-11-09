<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Simple Time Clock Application</title>
<script type="text/javascript">

var empType = $EmpType;

function toggle_visibility(e) {
	if(e == 'employee') {
		e.style.display = 'block';
		document.getElementById('admin').style.display = 'none';		
	}
	else if(e == 'admin') {
		e.style.display = 'block';
		document.getElementById('employee').style.display = 'none';		
	}
}

function timeclock(btn){  
	var tc = document.employee-form.timeclock.value;	
	var prd = document.employee-form.period.value;
	
	if(btn == 'start' && tc == 'shift') {
    	document.employee-form.action == "/SimpleTimeClock/startShift";
    	document.employee-form.submit();
	}
	else if(btn == 'end' && tc == 'shift') {
    	document.employee-form.action = "/SimpleTimeClock/endShift";
    	document.employee-form.submit();
	}
	else if(btn == 'start' && tc == 'break') {
    	document.employee-form.action = "/SimpleTimeClock/startBreak";
    	document.employee-form.submit();
	}
	else if(btn == 'end' && tc == 'break') {
    	document.employee-form.action = "/SimpleTimeClock/endBreak";
    	document.employee-form.submit();
	}
	else if(btn == 'start' && tc == 'lunch') {
    	document.employee-form.action = "/SimpleTimeClock/startLunch";
    	document.employee-form.submit();
	}
	else if(btn == 'end' && tc == 'lunch') {
    	document.employee-form.action = "/SimpleTimeClock/endLunch";
    	document.employee-form.submit();
	}
	
	if(btn == 'report') {
    	document.employee-form.action = "/SimpleTimeClock/report";    	
    	document.employee-form.submit();
	}
} 
</script>
</head>
<body>
	<form id="employee-form" method="post">
	<center>
		<h2>Employee Time Clock</h2>
			<div style="background-color: #1a53ff;">                
                    <li>
                        <a style="color: #fff; font-size: 14px;" href="javascript:toggle_visibility('employee')">Employee</a>
                    </li>
                    <li>
                        <a style="color: #fff; font-size: 14px;" href="javascript:toggle_visibility('admin')">Administrator</a>
                    </li>                    
                </ul>				
			</div>
			<div id="employee">				
			<table width=50% border=0 cellspacing=20 cellpadding=20 align=center>												
					    <tr>
					    	<td width=30% style="padding:5px">Name:</td>							
							<td width=30% style="padding:5px;">Joel Howard</td>						
						</tr>
						<tr>							
							<td width=30% style="padding:5px">Department:</td>
							<td width=30% style="padding:5px">Software</td>
						</tr>						
						<tr>							
							<td width=30% style="padding:5px">Time Clock</td>
							<td width=30% style="padding:5px"><select id="timeclock" name="timeclock">
								<option value="api">Shift</option>
								<option value="other">Break</option>
								<option value="other">Lunch</option>
								</select>
							</td>
						</tr>						
					</table>
					<p></p>
					<table width=60% border=0 cellspacing=20 cellpadding=20 align=center>
					<tr>
					<td align="center"><button type="button" value="start" onClick="timeclock('start')" style="margin-top:20px;">Start</button></td>
					<td align="center"><button type="button" value="end" onClick="timeclock('end')" style="margin-top:20px;">End</button></td>					</tr>
					</table>
			</div>	
			<div id="admin">
			<h2>Employee Time Clock Report</h2>
			<table width=50% border=0 cellspacing=20 cellpadding=20 align=center>												
					    <tr>							
							<td width=30% style="padding:5px;">Employee Id:</td>							
							<td width=30% style="padding:5px;"><input type="text" id="empId"></td>
						</tr>
						<tr>							
							<td width=30% style="padding:5px">Period</td>
							<td width=30% style="padding:5px"><select id="period">
								<option value="1d">One Day</option>
								<option value="1w">Last Week</option>
								<option value="1m">Last Month</option>
								<option value="3m">Last 3 Months</option>
								</select></td>
						</tr>
						<tr>							
							<td width=30% style="padding:5px">Time Clock</td>							
							<td width=30% style="padding:5px"><select id="timeclock">
								<option value="shift">Shift</option>
								<option value="lunch">Lunch</option>
								<option value="break">Break</option>								
								</select>
							</td>
						</tr>						
					</table>
					<p></p>
					<table width=60% border=0 cellspacing=20 cellpadding=20 align=center>
					<tr>
					<td align="center"><button type="button" value="submit" onClick="timeclock('report')" style="margin-top:20px;">Start</button></td>
					</tr>
					</table>
			</div>	
			</center>
			</form>
			</body>
</html>