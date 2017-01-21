<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<t:head>Article manager</t:head>
<t:ADMIN>
	<!-- populates the form using the object nea (NewEditArticolo) from servlet ControllerArticleManager -->
	<!-- the parameteres are then passed to the servlet ControllerArticleManager -->
	<form action="/BLOG/ControllerArticleManager" method="post">

		<input type="hidden" name="action" value="nuovoArticolo">

		<table border="0">
			<tr>
				<!-- inputs the ID of the article in the cell; if the article was created with ID 0 (new article), the cell is left blank -->
				<c:choose>
					<c:when test="${nea.articolo.id>0}">
						<td>Article ID</td>
						<td><input name="ID" size="4" placeholder="ID articolo"
							value="${nea.articolo.id}" readonly="readonly" /></td>
					</c:when>
					<c:otherwise>
						<td>Article ID</td>
						<td><input name="ID" size="4" placeholder="ID articolo"
							value="0" readonly="readonly" /></td>
					</c:otherwise>
				</c:choose>
			</tr>

			<tr>
				<td>Restaurant</td>
				<td><input name="restaurant" size="50"
					placeholder="Insert restaurant name"
					value="${nea.articolo.ristorante}" /></td>
			</tr>

			<tr>
				<td><label>Location</label></td>
				<td><select name="location">
						<!-- for each object in nea.listArea, checks the ID and adds the name to the select menu
if the ID of object in listArea matches the IDArea of the article, it is set as selected -->
						<c:forEach var="area" items="${nea.listaArea}">
							<c:choose>
								<c:when test="${area.ID==nea.articolo.IDArea}">
									<option value="${area.ID}" selected="selected">
										${area.nome}</option>
								</c:when>
								<c:otherwise>
									<option value="${area.ID}">${area.nome}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
				</select></td>
			</tr>
			<!-- for each object in nea.listCucina, checks the ID and adds the name to the select menu
if the ID of object in listCucina matches the IDCucina of the article, it is set as selected -->
			<tr>
				<td><label> Cuisine</label></td>
				<td><select name="cucina">
						<c:forEach var="cucina" items="${nea.listaCucina}">
							<c:choose>
								<c:when test="${cucina.ID==nea.articolo.IDCucina}">
									<option value="${cucina.ID}" selected="selected">
										${cucina.nome}</option>
								</c:when>
								<c:otherwise>
									<option value="${cucina.ID}">${cucina.nome}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
				</select></td>
			</tr>
			<!-- for each object in nea.listPrezzo, checks the ID and adds the name to the select menu
if the ID of object in listPrezzo matches the IDPrezzo of the article, it is set as selected -->
			<tr>
				<td><label> Price </label></td>
				<td><select name="prezzo">
						<c:forEach var="prezzo" items="${nea.listaPrezzo}">
							<c:choose>
								<c:when test="${prezzo.ID==nea.articolo.IDPrezzo}">
									<option name="IDPrezzo" value="${prezzo.ID}"
										selected="selected">${prezzo.nome}</option>
								</c:when>
								<c:otherwise>
									<option name="IDPrezzo" value="${prezzo.ID}">
										${prezzo.nome}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
				</select></td>
			</tr>

			<tr>
				<td>Website</td>
				<td><input name="website" size="50"
					placeholder="insert website address"}></td>
			</tr>

			<tr>
				<td>Article date</td>
				<td><input name="data" placeholder="aaaa/mm/dd" size="12"
					value="${nea.articolo.data}"></td>
			</tr>
		</table>

		<textarea name="recensione">
		${nea.articolo.articolo}
 	</textarea>

		<table border="0">
			<tr>
				<td><label> Stars </label></td>
				<!-- for each object in nea.listVoto, checks the ID and adds the name to the select menu
if the ID of the object in listVoto matches the IDVoto of the article, it is set as selected -->
				<td><select name="voto">
						<c:forEach var="voto" items="${nea.listaVoto}">
							<c:choose>
								<c:when test="${voto.ID==nea.articolo.IDVoto}">
									<option value="${voto.ID}" selected="selected">
										${voto.nome}</option>
								</c:when>
								<c:otherwise>
									<option value="${voto.ID}">${voto.nome}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
				</select></td>
			</tr>

			<tr>
				<td><label>Picture</label></td>
				<td><select name="foto">
						<c:forEach var="img" items="${nea.listaImg}">
							<c:choose>
								<c:when test="${img==nea.articolo.foto}">
									<option value="img" selected="selected">${img}</option>
								</c:when>
								<c:otherwise>
									<option>${img}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
				</select></td>
			</tr>

			<tr>
				<td><label>CURRENT PICTURE</label></td>
			</tr>
			<tr>
				<td><img
					src="${pageContext.request.contextPath}/img/${nea.articolo.foto}"
					alt="no picture" height=150 width=300></img></td>
			</tr>

			<tr>
				<td><input type="submit" value="SUBMIT" name="submit"></td>
			</tr>
			<tr>
				<td><input type="submit" value="DELETE ARTICLE" name="submit"></td>
			</tr>
		</table>
	</form>

	<!-- button BACK moves back to view admin.jsp-->
	<form action="/BLOG/ControllerAdmin">
	<table>
			<tr>
				<td><input type="submit" value="BACK"></td>
			</tr>
	</table>
	</form>
</t:ADMIN>

