<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<html lang="en">

<body>
	<t:masthead />

	<div class="container">
		<t:header />
		<div class="row">
			<div class="col-sm-8 blog-main">
				<jsp:doBody />
			</div>
			<!-- blog-main -->

			<t:sidebar />

		</div><!-- /.row -->
	</div><!-- /.container -->

	<t:footer />

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	
	<script src="/BLOG/js/bootstrap.min.js"></script>
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="/BLOG/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>
