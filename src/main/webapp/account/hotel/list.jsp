<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
			<h1>
				<fmt:message key="welcome"/>
			</h1>
			<h2>
				<a href="${pageContext.request.contextPath}/logout.jsp"> 
					<fmt:message key="exit"/>
				</a>
				<br/>
				<c:if test="${sessionScope.loggedUser!=null && sessionScope.loggedUser.bookingSiteUrl == null && sessionScope.loggedUser.hotelCnpj == null}">
				&nbsp;&nbsp;&nbsp;
			    <a href="${pageContext.request.contextPath}/account/admin/adminMenu.jsp">
					<fmt:message key="go_back" /></a>
				<br/>
				</c:if>
				<br/>
				<c:if test="${(sessionScope.loggedUser.bookingSiteUrl == null) && (sessionScope.loggedUser.hotelCnpj == null) && (sessionScope.loggedUser != null)}">
				<form action="/<%= contextPath %>/Hotels/register" method="POST">
							<input type="submit" value="<fmt:message key="register"/>">
						</form>
						</c:if>
			</h2>
			<h3><fmt:message key="list"/></h3>
			<br/>
		</div>
		<div align="center">
			<table border="1">
				<tr>
					<th> <fmt:message key="cnpj"/></th>
					<th> <fmt:message key="name"/></th>
					<th> <fmt:message key="phone"/></th>
					<th> <fmt:message key="city"/></th>
					<th> <fmt:message key="hotel_dailyRate"/></th>
				</tr>
				<c:forEach var="hotel" items="${requestScope.hotelList}" varStatus="status">
					<tr>
						<td><c:out value="${hotel.cnpj}" /></td>
						<td><c:out value="${hotel.name}" /></td>
						<td><c:out value="${hotel.phone}" /></td>
						<td><c:out value="${hotel.city}" /></td>
						<td><c:out value="${hotel.dailyRate}" /></td>
						<c:if test="${(sessionScope.loggedUser.bookingSiteUrl == null) && (sessionScope.loggedUser.hotelCnpj == null) && (sessionScope.loggedUser != null)}">
						<td><form action="/<%= contextPath %>/Hotels/edit" method="POST">
							<input type="hidden" value='${ hotel.cnpj}' name="cnpj">
							<input type="submit" value="<fmt:message key="button_edit"/>">
						</form>
							<form action="/<%= contextPath %>/Hotels/remove" method="POST">
							<input type="hidden" value='${ hotel.cnpj}' name ="cnpj">
							<input type="submit" value="<fmt:message key="button_remove"/>">
						</form>
						</td>
						</c:if>
					</tr>
				</c:forEach>
			</table>
		</div>
	</body>
</fmt:bundle>
</html>