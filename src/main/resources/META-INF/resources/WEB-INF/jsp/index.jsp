<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="CSS/index.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Codeforces Problems By Tag</title>
</head>
<body style="margin-top : 100px">
	<center>
	<h1>CodeforceProblemParser</h1>
		
			<div>
				<h3>Get Problems by Contest ID from codeforce</h3>
				<h3>URL :
					https://codeforce-api.herokuapp.com/contest/{contest_ID}</h3>
				<a href="https://codeforce-api.herokuapp.com/contest/1352" target="_blank">Try
					It !</a>
			</div>
		
		
			<div>
				<h3>Get Problems by tag from codeforce</h3>
				<h3>URL :https://codeforce-api.herokuapp.com/tags/{tagname}</h3>
				<a href="https://codeforce-api.herokuapp.com/tags/bitmasks" target="_blank">Try
					It !</a>
			</div>
		
</center>
</body>
</html>