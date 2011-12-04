<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="ee.itcollege.jejee.entities.Piiriloik"%>
<%@page import="ee.itcollege.jejee.entities.Piirivalvur"%>
<%@page import="ee.itcollege.jejee.entities.Intsident"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib  uri="http://www.springframework.org/tags/form" prefix="fo" %>
<%@ taglib tagdir="/WEB-INF/tags/form/fields" prefix="field" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Piirivalvuri valik</title>
</head>
<body>

<div align="center" style="background-color: #EEEEEE;"><br>
	<spring:url value="/detail/${pints.id}/p/${pvalvur.id}/muuda_piirivalvur" var="url" />
	<form name="myform" action="${url}" method="GET">
	<table>
	<c:forEach var="piir" items="${piirivalvurid}">
		<tr>
			<td width="150px">
				<span>${piir.perekonnanimi}, ${piir.eesnimed}</span>
			</td>
			<td>
				<input type="radio" name="valik" value="${piir.id}" style="border:none;">
			</td>
		</tr>
	</c:forEach>
	</table>
	<br />
	<input type="submit" value="<spring:message code='label_muuda'/>">&nbsp;&nbsp;&nbsp;<input type="Button" value="<spring:message code='label_tagasi'/>" onclick="history.back()">
	</form>
</div>

</body>
</html>