<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<table border="1">
	<caption>
		<c:choose>
			<c:when test="${bookingSite != null}">
				<fmt:message key="bookingSite.update" />
			</c:when>
			<c:otherwise>
				<fmt:message key="bookingSite.create" />
			</c:otherwise>
		</c:choose>
	</caption>
	<c:if test="${bookingSite != null}">
		<input type="text" name="url" value="${bookingSite.url}" readonly="readonly" />
	</c:if>
	<tr>
		<td><label for="name"> <fmt:message key="bookingSite.name" />
		</label></td>
		<td><input type="text" id="name" name="name" size="45"
			required value="${bookingSite.name}" /></td>
	</tr>
	<tr>
		<td><label for="phone"> <fmt:message key="bookingSite.phone" />
		</label></td>
		<td><input type="text" id="phone" name="phone" size="45" required
			value="${bookingSite.phone}" /></td>
	</tr>
	<tr>
		<td><label for="email"> <fmt:message key="bookingSite.email" />
		</label></td>
		<td><input type="text" id="email" name="email" size="45" required
			value="${bookingSite.email}" /></td>
	</tr>
	<tr>
		<td><label for="password"> <fmt:message key="bookingSite.password" />
		</label></td>
		<td><input type="password" id="password" name="password" size="45" required
			value="${bookingSite.password}" /></td>
	</tr>
	<tr>
		<td colspan="2" align="center"><input type="submit"
			value="<fmt:message key="save.link" />" /></td>
	</tr>
</table>