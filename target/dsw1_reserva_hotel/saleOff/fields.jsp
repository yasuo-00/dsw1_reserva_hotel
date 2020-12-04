<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<table border="1">
	<caption>
		<c:choose>
			<c:when test="${saleOff != null}">
				<fmt:message key="saleOff.update" />
			</c:when>
			<c:otherwise>
				<fmt:message key="saleOff.create" />
			</c:otherwise>
		</c:choose>
	</caption>
	<c:if test="${saleOff != null}">
		<input type="text" name="cpnj" value="${saleOff.hotelCnpj}" readonly="readonly" />
	</c:if>
	<tr>
		<td><label for="cnpj"> <fmt:message key="saleOff.cnpj" />
		</label></td>
		<td><input type="text" id="cnpj" name="cnpj" size="45"
			required value="${saleOff.hotelCnpj}" /></td>
	</tr>
	<tr>
		<td><label for="initialDate"> <fmt:message key="saleOff.initialDate" />
		</label></td>
		<td><input type="text" id="initialDate" name="initialDate" size="45" required
			value="${saleOff.initialDate}" /></td>
	</tr>
	<tr>
		<td><label for="finalDate"> <fmt:message key="saleOff.finalDate" />
		</label></td>
		<td><input type="finalDate" id="finalDate" name="finalDate" size="45" required
			value="${saleOff.finalDate}" /></td>
	</tr>
	<tr>
		<td><label for="discount"> <fmt:message key="saleOff.discount" />
		</label></td>
		<td><input type="number" id="discount" name="discount" required
			min="0.01" step="any" size="5" value="${saleOff.discount}" /></td>
	</tr>
	<tr>
		<td colspan="2" align="center"><input type="submit"
			value="<fmt:message key="save.link" />" /></td>
	</tr>
</table>