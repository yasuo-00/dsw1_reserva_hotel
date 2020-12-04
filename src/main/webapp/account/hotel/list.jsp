<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>

	<head>
<title>Title</title>
	</head>

	<body>
		<%
			String contextPath = request.getContextPath().replace("/", "");
		%>
		<div align="center">
			<h1>
				Welcome
			</h1>
			<h2>
				<a href="${pageContext.request.contextPath}/logout.jsp"> 
					Exit
				</a>
				<br/>
				<br/>
				<c:if test="${(sessionScope.loggedUser.bookingSiteUrl == null) && (sessionScope.loggedUser.hotelCnpj == null) && (sessionScope.loggedUser != null)}">
				<form action="/<%= contextPath %>/Hotels/register" method="POST">
							<input type="submit" value="Register">
						</form>
						</c:if>
			</h2>
			<h3>List</h3>
			<br/>
		</div>
		<div align="center">
			<table border="1">
				<tr>
					<th> CNPJ</th>
					<th> Name</th>
					<th> Phone</th>
					<th> City</th>
					<th> Daily Rate</th>
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
							<input type="submit" value="Edit">
						</form>
							<form action="/<%= contextPath %>/Hotels/remove" method="POST">
							<input type="hidden" value='${ hotel.cnpj}' name ="cnpj">
							<input type="submit" value="Remove">
						</form>
						</td>
						</c:if>
					</tr>
				</c:forEach>
			</table>
		</div>
	</body>

</html>