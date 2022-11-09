<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Simple Time Clock Application</title>
</head>
<body>
	<center>
		<h2>Employee Login</h2>
		<h3>
			<form id="login-form" method="post" action="/SimpleTimeClock/login">
					<div style="align-items: center; width:100%;">						
						<table width=50% border=0 cellspacing=20 cellpadding=20 align=center>												
					    <tr>							
							<td width=30% style="padding:5px;">User Name:</td>							
							<td width=30% style="padding:5px;"><input type="text" id="name-input"></td>
						</tr>
						<tr>							
							<td width=30% style="padding:5px">Password:</td>
							<td width=30% style="padding:5px"><input type="text" id="password-input" name="oname"></td>
						</tr>
					</table>
					<p></p>
					<table width=60% border=0 cellspacing=20 cellpadding=20 align=center>
					<tr>
					<td align="center"><button type="submit" value="login" onClick="" style="margin-top:20px;">Login</button></td>
					</tr>
					</table>
					<br></br>					
					</div>							
					</form>
		</h3>
	</center>
</body>
</html>