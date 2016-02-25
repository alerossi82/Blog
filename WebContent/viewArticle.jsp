<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<t:head>View Article</t:head>
<t:TEMPLATE>
	<div class="blog-post">
		<h2 class="blog-post-title">${hvm.articolo.ristorante}</h2>
		<p class="blog-post-meta">${hvm.articolo.data}</p>

		<p class="voto">
			RATING:
			<!-- add as many stars as per IDVoto -->
			<c:forEach begin="1" end="${hvm.articolo.voto}">
				<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
			</c:forEach>
			<!-- remaining stars are empty -->
			<c:forEach begin="1" end="${5-hvm.articolo.voto}">
				<span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span>
			</c:forEach>
		</p>

		<img src="${pageContext.request.contextPath}/img/${hvm.articolo.foto}"
			style="width: 300px; float: left; margin-right: 20px;"
			class="img-thumbnail">

		<dl>
			<dt>Cuisine:</dt>
			<dd>${hvm.articolo.cucina}</dd>
			<dt>Location:</dt>
			<dd>${hvm.articolo.area}</dd>
			<dt>Price:</dt>
			<dd>${hvm.articolo.prezzo}</dd>
		</dl>

		<!-- set body of the article -->
		<p>${hvm.articolo.articolo}</p>
	</div>
	<!-- /.blog-post -->

	<!-- link to homepage -->
	<nav>
	<ul class="pager">
		<li><a href="/BLOG/ControllerHome">Back</a></li>
	</ul>
	</nav>

</t:TEMPLATE>