<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
              <li><a href="https://www.linkedin.com/in/alessandro-rossi-4844374?trk=hp-identity-name">LinkedIn</a></li>
            </ol>
          </div>
        </div><!-- /.blog-sidebar -->