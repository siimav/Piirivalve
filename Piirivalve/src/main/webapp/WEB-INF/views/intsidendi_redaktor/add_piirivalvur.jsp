<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib  uri="http://www.springframework.org/tags/form" prefix="fo" %>
<%@ taglib tagdir="/WEB-INF/tags/form/fields" prefix="field" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lisa piirivalvur</title>
</head>
<body>

<fo:form action="/Piirivalve/intsident/${id}/lisa_piirivalvur" method="POST" commandName="piirivalvur_intsidendis">
    <field:datetime dateTimePattern="${dateFormat}" field="alates" id="alates" required="true" label="Alates"/>
    <field:datetime dateTimePattern="${dateFormat}" field="kuni" id="kuni" required="true" label="Kuni"/>
	Kirjeldus <br /> <fo:textarea path="kirjeldus" rows="4" cols="25"></fo:textarea> <br />
	Kommentaar <br /> <fo:textarea path="kommentaar" rows="4" cols="25"></fo:textarea> <br /><br />
	
	Vali piirivalvurid: <br />
    <c:forEach var = "piirivalvur" items = "${piirivalvurid}">
        <input type = "checkbox" name = "ids" value = "${piirivalvur.id}" /> <c:out value = "${piirivalvur.getName()}" /> <br />
    </c:forEach>
    
	<input type="submit" value="Submit" />
</fo:form>

</body>
</html>
