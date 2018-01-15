<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Demo | Welcome</title>
	</head>
	<body>
COMPLEX SEARCH
<form action="/complexSearch" method="post">
   Search text <br>
   <input type="text" name="texstSearch" > <br>

   min price <br>
   <input type="text" name="min" > <br>

   max price <br>
   <input type="text" name="max" > <br>

  <input type="submit" value="search">
</form>
	</body>
</html>