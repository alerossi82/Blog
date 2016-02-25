<%@ tag language="java" pageEncoding="ISO-8859-1"%>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title><jsp:doBody /></title>

<!-- Bootstrap core CSS -->
<link href="/BLOG/css/bootstrap.min.css" rel="stylesheet">

<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<link href="/BLOG/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="/BLOG/css/blog.css" rel="stylesheet">

<!-- JQuery -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js">
	
</script>

<script>
	/* JQuery function for sidebar */
	/* the sidebar initially shows 3 articles only */
	$(document).ready(function() {
		/* clicking on more, the full list is displayed, button more disappears and button less shows up */
		$(".more").click(function() {
			$(".more").hide();
			$(".hidden_items").slideDown("slow");
		});
		/* clicking less, hidden_items hides and less hide, more shows up */
		$(".less").click(function() {
			$(".hidden_items").hide();
			$(".more").show();
		});
	});
</script>

<script>
	$(document).ready(function() {
		$("#user").click(function() {
			$(".blog-nav-list").toggle();
		});
	});
</script>

</head>
