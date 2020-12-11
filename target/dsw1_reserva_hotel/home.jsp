<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<fmt:bundle basename="message">
<body>
  <h1><fmt:message key="page.label" /></h1>
        <c:if test="${messages.isThereError}">
            <div id="error">
                <ul>
                    <c:forEach var="error" items="${messages.error}">
                        <li> ${error} </li>
                        </c:forEach>
                </ul>
            </div>
        </c:if>
<form action="index.jsp" method="POST">
	<label for="email">Email:</label><input type="text" name="email">
	<label for="password">Senha:</label><input type="password" name="password">
	<input type="submit" value="Entrar" name="bOK">
</form>

<p>Deseja ver todos os hotéis disponíveis?</p>
<form action="Hotels/">
<input type="submit" value="Listar" />
</form>

<p>Deseja ver todos os sites disponíveis?</p>
<form action="BookingSites/">
<input type="submit" value="Listar" />
</form>

<p>Deseja procurar os hotéis de uma cidade?</p>
<form method="GET" action="Hotels/listByCity">
	<label for="city">Cidade:</label><input type="text" name="city">
	<input type="submit" value="Ver hotéis da cidade">
</form>

</body>
</fmt:bundle>
</html>
