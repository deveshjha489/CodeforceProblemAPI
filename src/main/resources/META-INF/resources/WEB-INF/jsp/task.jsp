<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="CSS/index.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Codeforces Source File Generator</title>
</head>
<body>
	<div id="loginBox">
		<center>
			<!-- <c:forEach items="${taskList}" var="em">
				<li>${em}</li>
			</c:forEach>-->
			<table class="table">
				<tbody>
					<c:forEach items="${taskList}" var="em">
						<tr>
							<td>${em}</td>
						</tr>

					</c:forEach>
				</tbody>
			</table>
			<form name="generateFile" action="generateFile" method="POST">
				<ul>
					<input type="hidden" name='contestID' value="${contestID}" />
					<label>Problem ID:</label>
					<input type='text' name='problemID' />
					<label>&nbsp;</label>
					<input type="submit" value="Generate" class="loginButton">
				</ul>
			</form>
		</center>
	</div>
</body>
</html>