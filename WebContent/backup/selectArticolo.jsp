<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>select articolo</title>
</head>

<body>
<!-- link to ControllerEdit for new article -->
<a href="/BLOG/ControllerEdit?IDarticolo=0">nuovo articolo</a>

<!-- loop through listIDRistorante (from ControllerSelectArticle) to create a list of all articles in the DB
and a link to forward each IDarticolo to ControllerEdit.Get -->
<c:forEach items="${listIDRistorante}" var="art"> 
	<p> ${art.ristorante} <a href="/BLOG/ControllerEdit?IDarticolo=${art.id}">edit</a> </p>
</c:forEach>
</body>
</html>
	