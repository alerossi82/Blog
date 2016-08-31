<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="col-sm-3 col-sm-offset-1 blog-sidebar">
	<div class="sidebar-module sidebar-module-inset">
		<h4>About</h4>
		<p>You can find over 4.000 restaurants in Prague, but how many of
			them are really worth a visit? This blog represents a selection of my
			favorite ones, based on food quality, service and price. All the
			restaurants described in this blog are non-smoking only - because
			good food and cigarette smell do not get on well.</p>
	</div>

	<div class="sidebar-module">
		<p>
			<input placeholder="search">
		</p>
		<br />
		<h4>Articoli recenti</h4>

		<!-- links to most recent articles -->
		<div class="recent_items">
			<c:forEach var="articolo" items="${hvm.listaAllArticoli}" begin="0"
				end="1">
				<p>
					<a href="/BLOG/ControllerDisplayArticle?ID=${articolo.id}">
						${articolo.ristorante}</a>
				</p>
			</c:forEach>
		</div>

		<button class="more">more</button>

		<!-- hidden articles -->
		<div class="hidden_items" hidden="true">
			<c:forEach var="articolo" items="${hvm.listaAllArticoli}" begin="2"
				end="${hvm.totArticoliinDB}">
				<p>
					<a href="/BLOG/ControllerDisplayArticle?ID=${articolo.id}">
						${articolo.ristorante}</a>
				</p>
			</c:forEach>
			<!-- this button will be initially hidden -->
			<button class="less">less</button>
		</div>

		<div class="sidebar-module">
			<h4>Elsewhere</h4>
			<ol class="list-unstyled">
				<li><a href="https://github.com/alerossi82">GitHub</a></li>
				<li><a
					href="https://www.linkedin.com/in/alessandro-rossi-4844374?trk=hp-identity-name">LinkedIn</a></li>
			</ol>
		</div>
	</div>
	<!-- /.blog-sidebar -->