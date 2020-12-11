<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fmt:bundle basename="message">
<table border="1">
	<caption>
		<c:choose>
			<c:when test="${hotel != null}">
				<fmt:message key="update" />
			</c:when>
			<c:otherwise>
				<fmt:message key="create" />
			</c:otherwise>
		</c:choose>
	</caption>
	<tr>
		<td><label for="cnpj"> <fmt:message key="cnpj" />
		</label></td>
		<c:choose>
		<c:when test="${hotel != null}">
		<td><input type="text" id="cnpj" name="cnpj" size="45"
			required value="${hotel.cnpj}" readonly="readonly" /></td>
			</c:when>
			<c:otherwise>
			<td><input type="text" id="cnpj" name="cnpj" size="45"
			required value="${hotel.cnpj}" /></td>
			</c:otherwise>
			</c:choose>
	</tr>
	<tr>
		<td><label for="name"> <fmt:message key="name" />
		</label></td>
		<td><input type="text" id="name" name="name" size="45"
			required value="${hotel.name}" /></td>
	</tr>
	<tr>
		<td><label for="phone"> <fmt:message key="phone" />
		</label></td>
		<td><input type="text" id="phone" name="phone" size="45" required
			value="${hotel.phone}" /></td>
	</tr>
	<tr>
		<td><label for="city"> <fmt:message key="city" />
		</label></td>
		<td><input type="text" id="city" name="city" size="45" required
			value="${hotel.city}" /></td>
	</tr>
	<tr>
		<td><label for="email"> <fmt:message key="email" />
		</label></td>
		<td><input type="text" id="email" name="email" size="45" required
			value="${user.email}" /></td>
	</tr>
	<tr>
		<td><label for="password"> <fmt:message key="password" />
		</label></td>
		<td><input type="password" id="password" name="password" size="45" required
			value="${user.password}" /></td>
	</tr>
	<tr>
		<td><label for="dailyRate"> <fmt:message key="hotel_dailyRate" />
		</label></td>
		<td><input type="number" id="dailyRate" name="dailyRate" required
			min="0.01" step="any" size="5" value="${hotel.dailyRate}" /></td>
	</tr>
	<tr>
		<td colspan="2" align="center"><input type="submit"
			value="<fmt:message key="button_save" />" /></td>
	</tr>
</table>
</fmt:bundle>