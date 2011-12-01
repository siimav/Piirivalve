<%@page import="ee.itcollege.jejee.entities.Objekt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib  uri="http://www.springframework.org/tags/form" prefix="fo" %>
<%@ taglib tagdir="/WEB-INF/tags/form/fields" prefix="field" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lisa okjekt intsidenti</title>
</head>
<body>

<spring:url value="/intsident/${id}/lisa_objekt" var="url" />
<fo:form action="${url}" method="POST" commandName="objekt_intsidendis">
    <field:datetime dateTimePattern="${dateFormat}" field="alates" id="alates" required="true" label="Alates"/>
    <field:datetime dateTimePattern="${dateFormat}" field="kuni" id="kuni" required="true" label="Kuni"/>
	Kirjeldus <br /> <fo:textarea path="kirjeldus" rows="4" cols="25" required="true"></fo:textarea> <br />
	Kommentaar <br /> <fo:textarea path="kommentaar" rows="4" cols="25"></fo:textarea> <br /><br />
	
	Vali objektid: <br />
	<c:set var="i" value="0" />
    <c:forEach var = "objekt" items = "${objektid}">
        <input type = "checkbox" name = "ids" value = "${objekt.id}"
        <c:if test="${checks != null}">
        	<c:out value="${checks[i]}" />
        </c:if>        
        /> <c:out value = "${objekt.nimetus}" /> <br />
        <c:set var="i" value="${i + 1}" />
    </c:forEach>
    
    <br />
	<input type="submit" value="Submit" />	
</fo:form>

</body>
</html>