<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Blog Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="${pageContext.request.contextPath}/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/css/blog.css" rel="stylesheet">
  </head>

  <body>

    <div class="blog-masthead">
      <div class="container">
        <nav class="blog-nav">
          <a class="blog-nav-item active" href="#">Home</a>
          <a class="blog-nav-item" href="#">Login</a>
          <a class="blog-nav-item" href="#">English</a>
          <a class="blog-nav-item" href="#">xxx</a>
          <a class="blog-nav-item" href="#">xxx</a>
        </nav>
      </div>
    </div>

    <div class="container">

      <div class="blog-header">
        <h1 class="blog-title">The Bootstrap Blog</h1>
        <p class="lead blog-description">The official example template of creating a blog with Bootstrap.</p>
      </div>

      <div class="row">

        <div class="col-sm-8 blog-main">
			
          <!-- generate blog post based on HomeViewModel attribute (hvm) from ControllerHome-->
		  <!-- cicle through all Articolo objects in listaArticolo -->
          	<c:forEach var="articolo" items="${hvm.listaArticoliRM}">
          		<div class="blog-post">
            	<h2 class="blog-post-title">${articolo.ristorante}</h2>
				<p class="blog-post-meta">${articolo.data} by <a href="#">Alessandro</a></p> 	
				
				<p class="voto"> VOTO:
					<!-- add as many stars as per IDVoto -->
					<c:forEach begin="1" end="${articolo.voto}">
						<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
					</c:forEach>
					<!-- remaining stars are empty -->
					<c:forEach begin="1" end="${5-articolo.voto}">
						<span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span>
					</c:forEach>
				</p>
			
				<img src="${pageContext.request.contextPath}/img/${articolo.foto}" style="width:300px; float:left; margin-right:20px;" class="img-thumbnail">

				<dl>
					<dt> Cucina:</dt>
						<dd> ${articolo.cucina} </dd>
					<dt> Area:</dt>
						<dd> ${articolo.area} </dd>
					<dt> Fascia di prezzo:</dt>
						<dd>${articolo.prezzo}</dd>
				</dl>
				
				<!-- set body of the article -->
				<p>${articolo.articolo}</p>
				</div><!-- /.blog-post -->
          	</c:forEach>
		  		  
          <nav>
	            <ul class="pager">
	            <!-- if page 1, show button Next only -->
				<!-- if last page, show button Previous only -->
				<!-- otherwise, show both buttons -->
		            <c:choose>
			            <c:when test="${hvm.currentPage<=1 }">
			              <!-- get current page from controller,increase it by 1 and forward to controller -->
			              	<li><a href="/BLOG/ControllerHome?page=${hvm.currentPage+1}">Next</a></li>
			              </c:when>
		              
			              <c:when test="${hvm.currentPage>=hvm.totPages}">
			              <!-- get current page from controller,decrease it by 1 and forward to controller -->
			              	<li><a href="/BLOG/ControllerHome?page=${hvm.currentPage-1}">Previous</a></li>
			              </c:when>
			              
			              <c:otherwise>
							<li><a href="/BLOG/ControllerHome?page=${hvm.currentPage-1}">Previous</a></li>
							<li><a href="/BLOG/ControllerHome?page=${hvm.currentPage+1}">Next</a></li> 
					      </c:otherwise>
		             </c:choose>
	            </ul>
          </nav>
        </div><!-- /.blog-main -->

        <div class="col-sm-3 col-sm-offset-1 blog-sidebar">
          <div class="sidebar-module sidebar-module-inset">
            <h4>About</h4>
            <p>Etiam porta <em>sem malesuada magna</em> mollis euismod. Cras mattis consectetur purus sit amet fermentum. Aenean lacinia bibendum nulla sed consectetur.</p>
          </div>
          
          <div class="sidebar-module">
			<input value="cerca nel blog">
			<p></p>
			<h4>Articoli recenti</h4>
			<!-- create list of articles in the right side menu -->
				<ol class="list-unstyled">
					<c:choose>
						<c:when test="${hvm.showListOfAllArticles==true }">
							<!-- generate links to all articles -->
							<c:forEach var="articolo" items="${hvm.listaAllArticoli}">
								<li> <a href="/BLOG/ControllerDisplayArticle?ID=${articolo.id}"> ${articolo.ristorante}</a> </li>
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
				</ol>
          </div>
          
          <div class="sidebar-module">
            <h4>Elsewhere</h4>
            <ol class="list-unstyled">
              <li><a href="#">GitHub</a></li>
              <li><a href="#">Twitter</a></li>
              <li><a href="#">Facebook</a></li>
            </ol>
          </div>
        </div><!-- /.blog-sidebar -->	
      </div><!-- /.row -->
    </div><!-- /.container -->

    <footer class="blog-footer">
      <p>Blog built  by <a href="">Alessandro Rossi</a></p>
      <p>
        <a href="#">Back to top</a>
      </p>
    </footer>


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="../../dist/js/bootstrap.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>