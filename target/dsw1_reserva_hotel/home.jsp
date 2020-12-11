<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<fmt:bundle basename="message">
<body>
        
<form action="index.jsp" method="POST">
	<label for="email"><fmt:message key="email" /></label><input type="text" name="email">
	<label for="password"><fmt:message key="password" /></label><input type="password" name="password">
	<input type="submit" value="<fmt:message key="button_enter" />" name="bOK">
</form>

<p><fmt:message key="show_hotels_list" /></p>
<form action="Hotels/">
<input type="submit" value="<fmt:message key="button_list" />" />
</form>

<p><fmt:message key="show_sites_list" /></p>
<form action="BookingSites/">
<input type="submit" value="<fmt:message key="button_list" />" />
</form>

<p><fmt:message key="hotels_city_list" /></p>
<form method="GET" action="Hotels/listByCity">
	<label for="city"><fmt:message key="city" /></label><input type="text" name="city">
	<input type="submit" value="<fmt:message key="button_list" />">
</form>

</body>
</fmt:bundle>
</html>
