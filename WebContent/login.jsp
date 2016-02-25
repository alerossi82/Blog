<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<t:head>Log-in</t:head>

<t:ADMIN>

	<form action="/BLOG/ControllerUser" method="post">
		<h2>LOG-IN</h2>
		<!-- pass value login to controller when form is submitted -->
		<input type="hidden" name="action" value="login" />
		<table>
			<tr>
				<td>E-MAIL</td>
				<td><input type="text" name="email" value="" /></td>
			</tr>
			<tr>
				<td>PASSWORD</td>
				<td><input type="password" name="password" value="" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" class="btn btn-default"
					value="Login" /></td>
			</tr>
		</table>
	</form>
	
	<br />
	<!-- validation message -->
	<p>${model.message}</p>
</t:ADMIN>
