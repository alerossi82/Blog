<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>new/edit articolo</title>
</head>

<body>
	<h1>NOME DEL BLOG</h1>

	<img src="nuovo articolo/frontespizio.jpg" width="800"
		alt="FOTO IMMAGINE DEL BLOG" />

<!-- populates the form using the object newEditArticolo from servlet ControllerNuovoArticolo -->
<!-- the parameteres are then passed to the servlet ControllerEdit -->
	<form action="/BLOG/ControllerEdit" method="post">
	<input type="hidden" name="action" value="nuovoArticolo">
	
<!-- inputs the ID of the article in the cell; if the article was created with ID 0 (new article), the cell is left blank -->
	<c:choose>
		<c:when test="${nea.articolo.id>0}">
			ID articolo <input name="ID" placeholder="ID articolo" value="${nea.articolo.id}" readonly="readonly"/>
		</c:when>
		<c:otherwise>
			ID articolo <input name="ID" placeholder="ID articolo" value="0" readonly="readonly"/> 
		</c:otherwise>
	</c:choose>
	 
	<input name="restaurant" placeholder="Inserisci nome ristorante" size="110" value="${nea.articolo.ristorante}"/>
		
		<table ID="table1" cellpadding="5" cellspacing="5">
			<tr>
				<td><label> area </label></td>
				<td><select name="location">
<!-- for each object in nea.listArea, checks the ID and adds the name to the select menu
if the ID of object in listArea matches the IDArea of the article, it is set as selected -->
				<c:forEach var="area" items="${nea.listaArea}">
					<c:choose>
						<c:when test="${area.ID==nea.articolo.IDArea}">
							<option value="${area.ID}" selected="selected"> ${area.nome}</option>
						</c:when>
						<c:otherwise>
						<option value="${area.ID}"> ${area.nome}</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				</select></td>
			</tr>
<!-- for each object in nea.listCucina, checks the ID and adds the name to the select menu
if the ID of object in listCucina matches the IDCucina of the article, it is set as selected -->
			<tr>
				<td><label> cucina</label></td>
				<td><select name="cucina">
				<c:forEach var="cucina" items="${nea.listaCucina}">
					<c:choose>
						<c:when test="${cucina.ID==nea.articolo.IDCucina}">
							<option value="${cucina.ID}" selected="selected"> ${cucina.nome}</option>
						</c:when>
						<c:otherwise>
							<option value="${cucina.ID}"> ${cucina.nome}</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				</select></td>
			</tr>
<!-- for each object in nea.listPrezzo, checks the ID and adds the name to the select menu
if the ID of object in listPrezzo matches the IDPrezzo of the article, it is set as selected -->
			<tr>
				<td><label> prezzo </label></td>
				<td><select name="prezzo">
					<c:forEach var="prezzo" items="${nea.listaPrezzo}">
						<c:choose>
							<c:when test="${prezzo.ID==nea.articolo.IDPrezzo}">
								<option name="IDPrezzo" value="${prezzo.ID}" selected="selected"> ${prezzo.nome} </option>
							</c:when>
							<c:otherwise>
								<option name="IDPrezzo" value="${prezzo.ID}"> ${prezzo.nome} </option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</select></td>
			</tr>

			<tr>
				<td><a href="http://www.ambi.cz/cz/restaurace/"> website </a></td>
			</tr>

			<tr>
				<td><input name="data" placeholder="data articolo" size="8" value="${nea.articolo.data}"></td>
			</tr>
		</table>

	<textarea name="recensione">
		${nea.articolo.articolo}
 	</textarea>

		<table ID=table2 cellpadding="5" cellspacing="5">
			<tr>
				<td><label> Qualita' cibo </label></td>
				<td><select name="cibo">
						<option>Ottimo</option>
						<option>Medio</option>
						<option>Scadente</option>
				</select></td>
			</tr>
			<tr>
				<td><label> Qualita' del servizio </label></td>
				<td><select name="servizio">
						<option>Ottimo</option>
						<option>Medio</option>
						<option>Scadente</option>
				</select></td>
			</tr>

			<tr>
				<td><label> Atmosfera </label></td>
				<td><select name="atmosfera">
						<option>Ottimo</option>
						<option>Medio</option>
						<option>Scadente</option>
				</select></td>
			</tr>
			
			<tr>
				<td><label> VOTO FINALE </label></td>
<!-- for each object in nea.listVoto, checks the ID and adds the name to the select menu
if the ID of the object in listVoto matches the IDVoto of the article, it is set as selected -->
				<td><select name="voto">
					<c:forEach var="voto" items="${nea.listaVoto}">
						<c:choose>
							<c:when test="${voto.ID==nea.articolo.IDVoto}">
								<option value="${voto.ID}" selected="selected"> ${voto.nome}</option>
							</c:when>
							<c:otherwise>
								<option value="${voto.ID}"> ${voto.nome}</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</select></td>
			</tr>


			<tr>
				<td><img src=... alt="VUOTO/FOTO ATTUALE" height=150 width=300></img></td>
			</tr>

		</table>

		<table ID=table3 cellpadding="5" cellspacing="5">
			<tr>
				<c:choose>
					<c:when test="${nea.articolo.foto==''}">
						<td><input name="foto" placeholder="file name"/></td>
					</c:when>
					<c:otherwise>
						<td><input name="foto" value="${nea.articolo.foto}"/></td>
					</c:otherwise>
				</c:choose>
			</tr>
			<tr>
				<td><button>carica nuova foto</button></td>
			</tr>
			<tr>
				<td>
					<button>cancella foto</button>
				</td>
			</tr>
			<tr>
				<td>
					<button>PREVIEW</button>
				</td>
			</tr>
			<tr>
				<td><input type="submit" value="SUBMIT"></td>
			</tr>
			<tr>
				<td><button>CANCEL</button></td>
			</tr>
		</table>

	</form>
</body>
</html>


<style type="text/css">
body {
	width: 900px;
	border: solid black;
	padding: 10px;
}

h1 {
	width: 800px;
	padding: 5px;
}

img {
	margin-bottom: 10px;
	text-align: center;
	vertical-align: middle
}

table {
	margin: 10px 0px 10px 0px;
	border: solid 0px;
}

label {
	border: solid;
	padding: 3px;
}

a {
	color: blue;
}

textarea {
	font-size: 30px;
	width: 800px;
	height: 1000px;
	text-align: left;
	vertical-align: middle;
}
</style>