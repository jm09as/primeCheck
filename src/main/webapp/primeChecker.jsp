<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="primeChecker.css">
<title>Prime Checker</title>
</head>
<h2 id="title">Üdvözöllek a prímszám ellenőrző programban !</h2>
<body id="body">
	<div class="primeBox">
		<form action="prime" method="get">
			<p id="question">Kérlek add meg a számot!</p>
			<input id="put" type="number" name="prime"> <br>
			<input id="button" type="submit" value="Számol">
		</form>
	</div>
	<h3 class="primeBox">${result}</h3>
</body>
</html>