<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lisa piirivalvur</title>
</head>
<body>

<form name="input" action="/Piirivalve/intsident/${id}/lisa_piirivalvur" method="post">
    <c:forEach var = "piirivalvur" items = "${piirivalvurid}">
        <input type = "checkbox" name = "ids" value = "${piirivalvur.piirivalvur_ID}" /> <c:out value = "${piirivalvur.getName()}" /> <br />
    </c:forEach>
	<input type="submit" value="Submit" />
</form> 

</body>
</html>
