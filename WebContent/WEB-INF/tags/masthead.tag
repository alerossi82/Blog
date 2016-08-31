<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- get email value from session value set in ControllerUser-->
<c:set var="email" value="${sessionScope.email}" />

<div class="blog-masthead">
	<div class="container">
		<nav class="blog-nav">
			<a class="blog-nav-item" href="/BLOG/ControllerHome">Home</a>
			
			<!-- check if logged in -->
			<!-- if logged out, show link to login -->
			<!-- otherwise, show username, link to logout and link to Admin view -->
			<c:choose>
			
				<c:when test="${email==null}">
					<!-- the login link forwards directly to view login -->
					<a class="blog-nav-item"
						href="${pageContext.request.contextPath}/login.jsp">Log-in</a>
				</c:when>
				
				<c:otherwise>
					<a href="#" class="blog-nav-item" id="user"> Hello, <c:out
							value="${email}" /></a>
							
					<a class="blog-nav-item"
						href="${pageContext.request.contextPath}/ControllerUser?action=logout">Log-out </a>
						
					<a class="blog-nav-item"
						href="${pageContext.request.contextPath}/ControllerAdmin">Admin </a>
				</c:otherwise>
				
			</c:choose>
		</nav>
	</div>
</div>
