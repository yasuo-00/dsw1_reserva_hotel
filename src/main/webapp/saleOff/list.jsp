<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<fmt:bundle basename="message">
	<head>
<title><fmt:message key="list"/></title>
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
				<br/>
				<c:if test="${sessionScope.loggedUser.hotelCnpj != null}">
				<form action="/<%= contextPath %>/SaleOffs/register" method="POST">
							<input type="submit" value="<fmt:message key="button_register"/>">
						</form>
						</c:if>
			</h2>
			<h3><fmt:message key="ist"/></h3>
			<br/>
		</div>
		<div align="center">
			<table border="1">
				<tr>
					<th> <fmt:message key="cnpj"/></th>
					<th> <fmt:message key="url"/></th>
					<th> <fmt:message key="initial_date"/></th>
					<th> <fmt:message key="final_date"/></th>
					<th> <fmt:message key="discount"/></th>
				</tr>
				<c:forEach var="saleOff" items="${requestScope.saleOffList}" varStatus="status">
					<tr>
						<td><c:out value="${saleOff.hotelCnpj}" /></td>
						<td><c:out value="${saleOff.bookingSiteUrl}" /></td>
						<td><c:out value="${saleOff.initialDate}" /></td>
						<td><c:out value="${saleOff.finalDate}" /></td>
						<td><c:out value="${saleOff.discount}" /></td>
						<c:if test="${sessionScope.loggedUser.hotelCnpj != null}">
						<td><form action="/<%= contextPath %>/SaleOffs/edit" method="POST">
							<input type="hidden" value='${ saleOff.hotelCnpj}' name="hotelCnpj">
							<input type="hidden" value='${ saleOff.bookingSiteUrl}' name="bookingSiteUrl">
							<input type="hidden" value='${ saleOff.initialDate}' name="initialDate">
							<input type="hidden" value='${ saleOff.finalDate}' name="finalDate">
							<input type="hidden" value='${ saleOff.discount}' name="discount">
							<input type="submit" value="<fmt:message key="button_edit"/>">
						</form>
							<form action="/<%= contextPath %>/SaleOffs/remove" method="POST">
							<input type="hidden" value='${ saleOff.hotelCnpj}' name="hotelCnpj">
							<input type="hidden" value='${ saleOff.bookingSiteUrl}' name="bookingSiteUrl">
							<input type="hidden" value='${ saleOff.initialDate}' name="initialDate">
							<input type="hidden" value='${ saleOff.finalDate}' name="finalDate">
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