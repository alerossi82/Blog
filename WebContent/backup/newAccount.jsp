<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/BLOG/ControllerUser" method="post">
	<p>CREATE NEW ACCOUNT</p>
		<input type="hidden" name="action" value="newAccount" /> 
		E-MAIL: <input type="text" name="email" value="" /> 
		PASSWORD:<input type="password"	name="password" value="" /> 
		<input type="submit" value="ok" />
</form>
<p>${model.message}</p>
</body>
</html>