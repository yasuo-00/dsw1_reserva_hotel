<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<body>


<p>CRUD Hotel</p>
<form action="../../Hotels/list" method="POST">
<input type="submit" value="Listar" />
</form>

<p>CRUD Site de Reserva</p>
<form action="../../BookingSites/" method="POST">
<input type="submit" value="Listar" />
</form>


</body>
</html>
