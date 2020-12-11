<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<fmt:bundle basename="message">
	<head>
<title><fmt:message key="hotel"/></title>
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
				<br/>
				<a href="listAllFromHotel"> 
					<fmt:message key="saleoff_list"/>
				</a>
			    <a href="${pageContext.request.contextPath}/logout.jsp">
					<fmt:message key="exit"/></a>
					<br/>
							<c:if test="${sessionScope.loggedUser!=null && sessionScope.loggedUser.bookingSiteUrl == null && sessionScope.loggedUser.hotelCnpj == null}">
				&nbsp;&nbsp;&nbsp;
			    <a href="${pageContext.request.contextPath}/account/admin/adminMenu.jsp">
					<fmt:message key="go_back" /></a>
				<br/>
				</c:if>
				<br/>
			</h2>
		</div>
		<div align="center">
			<c:choose>
				<c:when test="${hotel != null}">
					<form action="update" method="post">
						<%@include file="fields.jsp"%>
					</form>
				</c:when>
				<c:otherwise>
					<form action="insert" method="post">
						<%@include file="fields.jsp"%>
					</form>
				</c:otherwise>
			</c:choose>
		</div>
	</body>
</fmt:bundle>

</html>
