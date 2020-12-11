<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<fmt:bundle basename="message">
<body>

<p><fmt:message key="saleoff_list"/></p>
<form action="../../SaleOffs/listAllFromHotel" method="POST">
<input type="hidden" value="${sessionScope.loggedUser.hotelCnpj}" name="hotelCnpj"/>
<input type="submit" value="<fmt:message key="button_list"/>" />
</form>



</body>
</fmt:bundle>
</html>
