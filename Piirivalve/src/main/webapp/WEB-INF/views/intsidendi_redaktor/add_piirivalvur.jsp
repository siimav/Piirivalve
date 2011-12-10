<%@page import="ee.itcollege.jejee.entities.Piirivalvur"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib  uri="http://www.springframework.org/tags/form" prefix="fo" %>
<%@ taglib tagdir="/WEB-INF/tags/form/fields" prefix="field" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<META http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="add_piirivalvur_pealkiri"/></title>
</head>
<body>

<spring:url value="/intsident/${id}/lisa_piirivalvur" var="url" />
<fo:form action="${url}" method="POST" commandName="piirivalvur_intsidendis">
	<spring:message code="label_alates" var="str_alates"/>
    <field:datetime dateTimePattern="${dateFormat}" field="alates" id="alates" required="true" label="${str_alates}"/>
    <spring:message code="label_kuni" var="str_kuni"/>
    <field:datetime dateTimePattern="${dateFormat}" field="kuni" id="kuni" required="true" label="${str_kuni}"/>
	<spring:message code="label_kirjeldus"/> <br /> <fo:textarea path="kirjeldus" rows="4" cols="25" required="true"></fo:textarea> <br />
	<spring:message code="label_kommentaar"/> <br /> <fo:textarea path="kommentaar" rows="4" cols="25"></fo:textarea> <br /><br />
	
	<spring:message code="label_vali_piirivalvurid"/>: <br />
	<c:set var="i" value="0" />
    <c:forEach var = "piirivalvur" items = "${piirivalvurid}">
        <input type = "checkbox" name = "ids" value = "${piirivalvur.id}"        
        <c:if test="${checks != null}">
        	<c:out value="${checks[i]}" />
        </c:if>        
        /> <c:out value = "${piirivalvur.getName()}" /> <br />
        <c:set var="i" value="${i + 1}" />
    </c:forEach>
    
    <br />
	<input type="submit" value="<spring:message code="button_submit"/>" />	
</fo:form>

</body>
</html>
