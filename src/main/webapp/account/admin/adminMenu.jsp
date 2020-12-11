<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<fmt:bundle basename="message">
<body>


<p>CRUD <fmt:message key="hotel"/></p>
<form action="../../Hotels/list" method="POST">
<input type="submit" value="<fmt:message key="button_list"/>" />
</form>

<p>CRUD <fmt:message key="booking_site"/></p>
<form action="../../BookingSites/" method="POST">
<input type="submit" value="<fmt:message key="button_list"/>" />
</form>


</body>
</fmt:bundle>
</html>
