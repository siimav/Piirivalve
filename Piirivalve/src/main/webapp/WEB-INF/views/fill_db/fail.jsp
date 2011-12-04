<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>midagi</title>
</head>
<body>
	<c:if test="">

	</c:if>
	<c:choose>
		<c:when test="${error != null}">
			<p><spring:message code="label_db_fill_fail"/></p>
			<p><c:out value="${error}"></c:out></p>
		</c:when>
		<c:otherwise>
			<p><spring:message code="label_db_fill_not_empty"/></p>
		</c:otherwise>
	</c:choose>
</body>
</html>
