<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<t:head>Articles list</t:head>
<t:ADMIN>

	<p>
		<a href="${pageContext.request.contextPath}/newAccount.jsp"><h3>CREATE
				NEW USER</h3></a>
	</p>
	<!-- link to ControllerArticleManager for new article -->
	<p>
		<a href="/BLOG/ControllerArticleManager?IDarticolo=0"><h3>INSERT
				NEW ARTICLE</h3></a>
	</p>

	<!-- loop through listIDRistorante (from ControllerSelectArticle) to create a table of all articles in the DB
and a link to forward each IDarticolo to ControllerArticleManager.Get -->
	<table>
		<c:forEach items="${listIDRistorante}" var="art">
			<tr>
				<td>${art.ristorante}</td>
				<td><a
					href="/BLOG/ControllerArticleManager?IDarticolo=${art.id}">edit</a></td>
			</tr>
		</c:forEach>
	</table>
</t:ADMIN>
