<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<fmt:bundle basename="message">

	<head>
<title><fmt:message key="page.title" /></title>
	</head>

	<body>
		<%
			String contextPath = request.getContextPath().replace("/", "");
		%>
		<div align="center">
			<h1>
				<fmt:message key="hotels.welcome" />
			</h1>
			<h2>
			<!--  
				<a href="/<%=contextPath%>/livros"> 
					<fmt:message key="books.entity" />
				</a> 
				&nbsp;&nbsp;&nbsp;
				<a href="${pageContext.request.contextPath}/logout.jsp"> 
					<fmt:message key="exit.link" />
				</a> -->
				<br/>
				<br/>
				<a href="/<%=contextPath%>/hotels/register">
					<fmt:message key="hotels.create" />
				</a> 
			</h2>
			<h3><fmt:message key="hotels.list" /></h3>
			<br/>
		</div>
		<div align="center">
			<table border="1">
				<tr>
					<th><fmt:message key="hotel.CNPJ" /></th>
					<th><fmt:message key="hotel.name" /></th>
					<th><fmt:message key="actions.link" /></th>
				</tr>
				<c:forEach var="hotel" items="${requestScope.hotelList}">
					<tr>
						<td><c:out value="${hotel.CNPJ}" /></td>
						<td><c:out value="${hotel.nome}" /></td>
						<td><a
							href="/<%= contextPath %>/hotels/edit?id=<c:out value='${hotel.cnpj}' />">
								<fmt:message key="hotels.update" />
						</a> <c:if test="${hotel.qtdeLivros == 0}">
                                &nbsp;&nbsp;&nbsp;&nbsp;
                                <a
									href="/<%= contextPath %>/hotles/remove?id=<c:out value='${hotel.cnpj}' />"
									onclick="return confirm('<fmt:message key="confirm.link" />');">
									<fmt:message key="hotels.remove" />
								</a>
							</c:if></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</body>
</fmt:bundle>

</html>