<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<body>

<form method="POST">
	<label for="username">Usuário:</label><input type="text" name="username">
	<label for="password">Senha:</label><input type="password" name="password">
	<input type="submit" value="Entrar">
</form>

<p>Ainda não é registrado?</p>
<button>Registre-se!</button>

<p>Deseja ver todos os hotéis disponíveis?</p>
<button>Listar hotéis</button>

<p>Deseja procurar os hotéis de uma cidade?</p>
<form method="GET">
	<label for="city">Cidade:</label><input type="text" name="city">
	<input type="submit" value="Ver hotéis da cidade">
</form>

</body>
</html>
