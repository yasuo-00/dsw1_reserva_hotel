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
				<fmt:message key="bookingSites.welcome" />
			</h1>
			<h2>
				<a href="/<%=contextPath%>/bookingSites"> 
					<fmt:message key="bookingSite.entity" />
				</a> 
				&nbsp;&nbsp;&nbsp;
				<a href="${pageContext.request.contextPath}/logout.jsp"> 
					<fmt:message key="exit.link" />
				</a> 
				<br/>
				<br/>
				<a href="/<%=contextPath%>/bookingSites/register">
					<fmt:message key="bookingSites.create" />
				</a> 
			</h2>
			<h3><fmt:message key="bookingSites.list" /></h3>
			<br/>
		</div>
		<div align="center">
			<table border="1">
				<tr>
					<th><fmt:message key="bookingSite.url" /></th>
					<th><fmt:message key="bookingSite.name" /></th>
					<th><fmt:message key="bookingSite.phone" /></th>
					<th><fmt:message key="bookingSite.email" /></th>
					<th><fmt:message key="bookingSite.password" /></th>
					<th><fmt:message key="actions.link" /></th>
				</tr>
				<c:forEach var="bookingSite" items="${requestScope.bookingSiteList} varStatus="status">
					<tr>
						<td><c:out value="${bookingSite.url}" /></td>
						<td><c:out value="${bookingSite.name}" /></td>
						<td><c:out value="${bookingSite.phone}" /></td>
						<td><c:out value="${userList[status.index].email}" /></td>
						<td><c:out value="${userList[status.index].password}" /></td>
						<td><a
							href="/<%= contextPath %>/bookingSites/edit?id=<c:out value='${bookingSite.url}' />">
								<fmt:message key="bookingSites.update" />
						</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</body>
</fmt:bundle>

</html>