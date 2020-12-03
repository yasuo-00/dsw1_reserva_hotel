<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
				<a href="/<%=contextPath%>/BookingSites"> 
					Entity
				</a> 
				&nbsp;&nbsp;&nbsp;
				<a href="${pageContext.request.contextPath}/logout.jsp"> 
					Exit
				</a> 
				<br/>
				<br/>
				<a href="/<%=contextPath%>/BookingSites/register">
					Create
				</a> 
			</h2>
			<h3>List</h3>
			<br/>
		</div>
		<div align="center">
			<table border="1">
				<tr>
					<th>URL</th>
					<th>Name</th>
					<th>Phone</th>
				</tr>
				<c:forEach var="bookingSite" items="${requestScope.bookingSiteList}" varStatus="status">
					<tr>
						<td><c:out value="${bookingSite.url}" /></td>
						<td><c:out value="${bookingSite.name}" /></td>
						<td><c:out value="${bookingSite.phone}" /></td>
						<td><a
							href="/<%= contextPath %>/BookingSites/edit?id=<c:out value='${bookingSite.url}' />">
								Update
						</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</body>

</html>