<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>

	<head>
<title>Form Hotel</title>
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
				<br/>
				<a href="listSaleOff"> 
					List sale off
				</a>
			    <a href="${pageContext.request.contextPath}/logout.jsp">
					Exit</a>
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

</html>
