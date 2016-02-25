<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- generate view for the article selected in Home page  -->
<!-- this view gets an attribute HomeViewModel hvm from ControllerDisplayArticolo -->
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>view Articolo</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/homepage/style sheet homepage.css">
</head>

<body>
	<h1>NOME DEL BLOG</h1>
	<img src="${pageContext.request.contextPath}/pictures/frontespizio.jpg"
		alt="frontespizio" width="800" />

	<div id="main">

		<!-- set data, restaurant name and picture -->
		<h4>${hvm.articolo.data}</h4>
		<h4>${hvm.articolo.ristorante}</h4>
		<img
			src="${pageContext.request.contextPath}/pictures/${hvm.articolo.foto}"
			alt="immagine articolo" width="391" height="274" />

		<!-- set giudizio, cucina, area e prezzo -->
		<div id="giudizio">
			GIUDIZIO
			<p>${hvm.articolo.voto}</p>
		</div>

		<dl>
			<dt>Cucina:</dt>
			<dd>${hvm.articolo.cucina}</dd>

			<dt>Area:</dt>
			<dd>${hvm.articolo.area}</dd>

			<dt>Fascia di prezzo:</dt>
			<dd>${hvm.articolo.prezzo}
		</dl>

		<!-- set the text of the article -->
		<div id="recensione">
			<p>${hvm.articolo.articolo}</p>
		</div>
		<hr />
	</div>
</body>

</html>