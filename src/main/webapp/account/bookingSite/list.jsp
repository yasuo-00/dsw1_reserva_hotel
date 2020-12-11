<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<fmt:bundle basename="message">
	
<head>
<title><fmt:message key="title_list"/></title>
</head>

<body>
	<%
		String contextPath = request.getContextPath().replace("/", "");
	%>
	<div align="center">
		<h1><fmt:message key="welcome"/></h1>
		<h2>
			<a href="${pageContext.request.contextPath}/logout.jsp"> <fmt:message key="exit"/> </a> <br />
			<br /> 
			<c:if test="${sessionScope.loggedUser.bookingSiteUrl == null && sessionScope.loggedUser.hotelCnpj == null && sessionScope.loggedUser.email != null}">
			<form action="/<%=contextPath%>/BookingSites/register"
							method="POST">
							<input type="hidden" value='${ bookingSite.url}' name="url">
							<input type="submit" value="<fmt:message key="register"/>">
						</form>
			</c:if>
		</h2>
		<h3><fmt:message key="list"/></h3>
		<br />
	</div>
	<div align="center">
		<table border="1">
			<tr>
				<th><fmt:message key="url"/></th>
				<th><fmt:message key="name"/></th>
				<th><fmt:message key="phone"/></th>
			</tr>
			<c:forEach var="bookingSite" items="${requestScope.bookingSiteList}"
				varStatus="status">
				<tr>
					<td><c:out value="${bookingSite.url}" /></td>
					<td><c:out value="${bookingSite.name}" /></td>
					<td><c:out value="${bookingSite.phone}" /></td>
					<c:if test="${sessionScope.loggedUser.bookingSiteUrl == null && sessionScope.loggedUser.hotelCnpj == null && sessionScope.loggedUser.email != null}">
					<td><form action="/<%=contextPath%>/BookingSites/edit"
							method="POST">
							<input type="hidden" value='${bookingSite.url}' name="url">
							<input type="submit" value="<fmt:message key="button_edit"/>">
						</form>
						<form action="/<%=contextPath%>/BookingSites/remove"
							method="POST">
							<input type="hidden" value='${bookingSite.url}' name="url">
							<input type="submit" value="<fmt:message key="button_remove"/>">
						</form></td>
						</c:if>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</fmt:bundle>
</html>