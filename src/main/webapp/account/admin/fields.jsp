<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<table border="1">
	<caption>
		<c:choose>
			<c:when test="${user != null}">
				<fmt:message key="users.update" />
			</c:when>
			<c:otherwise>
				<fmt:message key="users.create" />
			</c:otherwise>
		</c:choose>
	</caption>
	<c:if test="${user != null}">
		<input type="hidden" name="id" value="<c:out value='${user.id}' />" />
	</c:if>
	<tr>
		<td><label for="nome"><fmt:message key="user.name" />
		</label></td>
		<td><input type="text" name="name" size="45" required
			value="<c:out value='${user.name}' />" /></td>
	</tr>
	<tr>
		<td><label for="login"><fmt:message key="user.login" />
		</label></td>
		<td><input type="text" name="login" size="20" required
			value="<c:out value='${usuario.login}' />" /></td>
	</tr>
	<tr>
		<td><label for="senha"><fmt:message key="user.password" />
		</label></td>
		<td><input type="text" name="senha" size="20" required
			value="<c:out value='${usuario.senha}' />" /></td>
	</tr>
	<tr>
		<td colspan="2" align="center"><input type="submit"
			value="<fmt:message key="save.link" />" /></td>
	</tr>
</table>