<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<body>


<p>Add SaleOff</p>
<form action="../../SaleOffs/insert" method="POST">
<input type="hidden" value="${sessionScope.loggedUser.hotelCnpj}" name="hotelCnpj"/>
<input type="text" value="Initial Date" name="initialDate" />
<input type="text" value="Final Date" name="finalDate" />
<input type="text" value="Discount" name="discount"/>
<input type="text" value="Booking Site" name="bookingSiteUrl"/>
<input type="submit" value="Add" />
</form>

<p>List SaleOff</p>
<form action="../../SaleOffs/list" method="POST">
<input type="submit" value="Listar" />
</form>



</body>
</html>
