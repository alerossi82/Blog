<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<title>home page</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/homepage/style sheet homepage.css">
</head>

<body>
	<h1>NOME DEL BLOG</h1>
	<img src="${pageContext.request.contextPath}/pictures/frontespizio.jpg" alt="frontespizio" width="800" />

	<ul>
		<li><input value="cerca nel blog"></li>
		<li><a href="login.jsp"> login </a></li>
		<li><a href="newAccount.jsp"> new user </a></li>
		<li><a class="home" href=""> Home </a></li>
		<li><a class="english" href=""> English </a></li>
		<li>Articoli recenti</li>
		
		<!-- create list of articles in the right side menu -->
		<c:choose>
			<c:when test="${hvm.showListOfAllArticles==true }">
			<!-- generate links to all articles -->
				<c:forEach var="articolo" items="${hvm.listaAllArticoli}">
					<li><a href="/BLOG/ControllerDisplayArticle?ID=${articolo.id}"> ${articolo.ristorante}</a></li>
				</c:forEach>
			</c:when>
			<c:otherwise>
			<!-- generate links to the three most recent articles -->
				<c:forEach  var="articolo" items="${hvm.listaAllArticoli}" begin="0" end="2" >
					<li><a href="/BLOG/ControllerDisplayArticle?ID=${articolo.id}"> ${articolo.ristorante}</a></li>
				</c:forEach>
				<!-- set value of boolean showListOfAllArticles to true -->
				<li><a href="/BLOG/ControllerHome?showListOfAllArticles=true">more</a></li>
			</c:otherwise>
		</c:choose>
		
		
		<li>Archivio</li>
		<li><a href=""> Gennaio 2015</a></li>
		<li><a href=""> Dicembre 2014 </a></li>
		<li><a href=""> Novembre 2014 </a></li>
		<li><a class="more" href=""> more </a></li>
	</ul>

	<div id="main">
	
	<!-- this view gets the HomeViewModel attribute (hvm) from ControllerHome -->
	<!-- cicle through all Articolo objects in listaArticolo -->
		<c:forEach var="articolo" items="${hvm.listaArticoliRM}">
		
		<!-- set data, restaurant name and picture -->
			<h4>${articolo.data}</h4>
			<h4>${articolo.ristorante}</h4>
					<img src="${pageContext.request.contextPath}/pictures/${articolo.foto}" alt="immagine articolo"
						width="391" height="274" />
						
		<!-- set giudizio, cucina, area e prezzo -->
					<div id="giudizio">
						GIUDIZIO
								<p>${articolo.voto}</p>
					</div>
					
					<dl>
						<dt>Cucina:</dt>
									<dd>${articolo.cucina}</dd>
							
						<dt>Area:</dt>
									<dd>${articolo.area}</dd>
							
						<dt>Fascia di prezzo:</dt>
									<dd>${articolo.prezzo}
					</dl>
					
	<!-- set the text of the article -->
					<div id="recensione">
						<p>${articolo.articolo}
						</p>
						<a href="link">continua a leggere</a>
						<%-- <p style="display:none">${articolo.articolo}</p> --%>
					</div>
					<hr />
		</c:forEach>
	</div>
	
	<!-- footer -->
		<div id="footer">
		<!-- if page 1, show next page only -->
		<!-- if last page, show current page only -->
			<c:choose>
				<c:when test="${hvm.currentPage<=1 }">
					<!-- get current page from controller,increase it by 1 and forward to controller -->
					<a href="/BLOG/ControllerHome?page=${hvm.currentPage+1}">next page</a>
				</c:when>
				
				<c:when test="${hvm.currentPage>=hvm.totPages}">
					<!-- get current page from controller,decrease it by 1 and forward to controller -->
					<a href="/BLOG/ControllerHome?page=${hvm.currentPage-1}">previous page</a>
				</c:when>
				
				<c:otherwise>
					<a href="/BLOG/ControllerHome?page=${hvm.currentPage-1}">previous page</a>
					<a href="/BLOG/ControllerHome?page=${hvm.currentPage+1}">next page</a> 
				</c:otherwise>
			</c:choose>
		</div>

</body>
</html>