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
				<a href="/<%=contextPath%>/SaleOffs"> 
					Entidade
				</a> 
				&nbsp;&nbsp;&nbsp;
				<a href="${pageContext.request.contextPath}/logout.jsp"> 
					Exit
				</a>
				<br/>
				<br/>
				<c:if test="${sessionScope.loggedUser.hotelCnpj != null}">
				<form action="/<%= contextPath %>/SaleOffs/register" method="POST">
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
				<c:forEach var="saleOff" items="${requestScope.saleOffList}" varStatus="status">
					<tr>
						<td><c:out value="${saleOff.hotelCnpj}" /></td>
						<td><c:out value="${saleOff.bookingSiteUrl}" /></td>
						<td><c:out value="${saleOff.initialDate}" /></td>
						<td><c:out value="${saleOff.finalDate}" /></td>
						<td><c:out value="${saleOff.discount}" /></td>
						<c:if test="${sessionScope.loggedUser.hotelCnpj != null}">
						<td><form action="/<%= contextPath %>/SaleOffs/edit" method="POST">
							<input type="hidden" value='${ saleOff.cnpj}' name="cnpj">
							<input type="submit" value="Edit">
						</form>
							<form action="/<%= contextPath %>/SaleOffs/remove" method="POST">
							<input type="hidden" value='${ saleOff.cnpj}' name ="cnpj">
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