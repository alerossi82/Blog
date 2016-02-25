<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- get email value from session value set in ControllerUser-->
<c:set var="email" value="${sessionScope.email}" />

<div class="blog-masthead">
	<div class="container">
		<nav class="blog-nav">
			<a class="blog-nav-item" href="/BLOG/ControllerHome">Home</a>

			<!-- switch between login and logout according to the value of var email -->
			<c:choose>
				<c:when test="${email==null}">
					<!-- the login link forwards directly to view login -->
					<a class="blog-nav-item"
						href="${pageContext.request.contextPath}/login.jsp">Log-in</a>
				</c:when>
				<c:otherwise>
					<a href="#" class="blog-nav-item" id="user"> Hello, <c:out
							value="${email}" /></a>

					<ul class="blog-nav-list" hidden="true">
						<li><a class="blog-nav-item"
							href="${pageContext.request.contextPath}/ControllerAdmin">Admin</a>
						</li>
						<li><a class="blog-nav-item"
							href="${pageContext.request.contextPath}/ControllerArticleManager?IDarticolo=0">New
								article</a></li>
						<li><a class="blog-nav-item" href="${pageContext.request.contextPath}/newAccount.jsp">New user</a>
						</li>
						<li><a class="blog-nav-item"
							href="${pageContext.request.contextPath}/ControllerUser?action=logout">Log-out</a></li>
					</ul>
				</c:otherwise>
			</c:choose>
		</nav>
	</div>
</div>
