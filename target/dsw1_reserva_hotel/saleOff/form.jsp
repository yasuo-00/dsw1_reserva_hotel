<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<fmt:bundle basename="message">

	<head>
<title>Title Sale Off Form</title>
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
					<fmt:message key="saleOff.listSaleOff" />
				</a>
				&nbsp;&nbsp;&nbsp;
			    <a href="${pageContext.request.contextPath}/logout.jsp">
					<fmt:message key="exit.link" /></a>
				<br/>
			</h2>
		</div>
		<div align="center">
			<c:choose>
				<c:when test="${saleOff != null}">
					<form action="<%=request.getContextPath()%>/SaleOffs/update" method="post">
						<%@include file="fields.jsp"%>
					</form>
				</c:when>
				<c:otherwise>
					<form action="<%=request.getContextPath()%>/SaleOffs/insert" method="post">
						<%@include file="fields.jsp"%>
					</form>
				</c:otherwise>
			</c:choose>
		</div>
		<c:if test="${!empty requestScope.messages}">
			<ul class="error">
				<c:forEach items="${requestScope.messages}" var="message">
					<li>${message}</li>
				</c:forEach>
			</ul>
		</c:if>
	</body>
</fmt:bundle>

</html>
