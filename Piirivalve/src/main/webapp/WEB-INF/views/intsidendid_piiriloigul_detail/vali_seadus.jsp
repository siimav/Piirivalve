<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib  uri="http://www.springframework.org/tags/form" prefix="fo" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vali seadus</title>
</head>
<body>

<spring:url value="/detail/${pints.id}/p/${pvalvur.id}/lisa_seadus" var="url" />
<spring:url value="/detail/${pints.id}/p/${pvalvur.id}" var="url_back" />
	<form name="myform" action="${url}" method="GET">
	<table>
	<c:forEach var="sp" items="${sp}">
	<tr>
	<td>
		<input type="checkbox" name="valik" value="${sp.id}" style="border:none;">${sp.seadus.nimetus}: ${sp.paragrahv} lg${sp.pais} - ${sp.tekst}<br>
	</td>	
	</tr>
	</c:forEach>
	</table>
	<br />
	<input type="submit" value="Muuda">&nbsp;&nbsp;&nbsp;<input type="Button" value="Tagasi" onclick="window.location='${url_back}'">
	</form>


</body>
</html>