<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p>Intsidendid:</p>

<c:forEach var="ints" items="${intsidents}">
	<div>ID: ${ints.id}</div>
	<div>Kood: ${ints.kood}</div>
	<div>Nimetus: ${ints.nimetus}</div>
	<div>Kirjeldus: ${ints.kirjeldus}</div>
	<div>Kommentaar: ${ints.kommentaar}</div>
	<div>Algus: ${ints.toimumise_algus}</div>
	<div>Lõpp: ${ints.toimumise_lopp}</div>
	<div>Liik: ${ints.intsidendi_liik}</div>
	<div>Piir: ${ints.piiriloik.id}</div>
	<br/>
</c:forEach>

</body>
</html>