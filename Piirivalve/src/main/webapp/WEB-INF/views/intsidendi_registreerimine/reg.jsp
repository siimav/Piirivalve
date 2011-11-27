<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib  uri="http://www.springframework.org/tags/form" prefix="fo" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags/form/fields" prefix="field" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- <link rel="stylesheet" type="text/css" href="/Piirivalve/src/main/webapp/styles/main.css" /> -->
<!-- <script type="text/javascript"> -->
<%-- 	<%@ include file="CalendarControl.js"  %> --%>
<!-- </script> -->
<title>midagi</title>
</head>
<body>

<!-- http://www.javabeat.net/tips/230-spring-framework-form-tags.html -->

<!-- http://www.java-tips.org/java-ee-tips/javaserver-pages/storing-data-in-a-session-object.html -->

<!-- https://engineering.purdue.edu/ECN/Support/KB/Docs/JavascriptCalendar -->

<!-- http://www.roseindia.net/tutorial/spring/spring3/web/spring-3-mvc-registration-example.html -->


<div id="main_wrapper">
<fo:form action="http://localhost:8080/Piirivalve/reg" method="POST" commandName="intsident">
	<div id="vasak_div">
		<table border="0">
			<tr><td>kood: </td><td><fo:input path="kood" /></td></tr>
			<tr><td>liik: </td>
			<td height="30px">
			<fo:select path="intsidendi_liik">
				<c:forEach var="ints" items="${intsidendi_liiks}">
					<fo:option value="${ints.intsidendi_liik_ID}">${ints.nimetus}</fo:option>
				</c:forEach>
			</fo:select>			
			</td></tr>
			<tr><td>nimetus: </td><td><fo:input path="nimetus" /></td></tr>
			<tr><td>piirilõik: </td>
				<td>
				<fo:select path="piiriloik" style="width:150px; height:25px; font-size:13px;" >
				<c:forEach var="piir" items="${piiriloiks}">
					<fo:option value="${piir.piiriloik_ID}">${piir.nimetus}</fo:option>
				</c:forEach>
				</fo:select>
				</td>
			</tr>
			<tr><td>koordnaadid: </td><td><fo:input path="GPS_latituud" style="width:65px"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fo:input path="GPS_longituud" style="width:65px"/><td/></tr>
			<tr><td>algus: </td><td><field:datetime dateTimePattern="${intsident_toimumise_algus_date_format}" field="toimumise_algus" id="algus" required="true"/></td></tr>
			<tr><td>lopp: </td><td><field:datetime dateTimePattern="${intsident_toimumise_lopp_date_format}" field="toimumise_lopp" id="lopp" required="true"/></td></tr>
		</table>
 	</div> 
	
	<div id="parem_div">
		<table>
			<tr><td>Kirjeldus</td><td></td></tr>
			<tr><td><fo:textarea path="kirjeldus" rows="4" cols="25"></fo:textarea></td></tr>
			<tr height=50px><td></td></tr>
			<tr><td>Kommentaar</td><td></td></tr>
			<tr><td><fo:textarea path="kommentaar" rows="4" cols="25"></fo:textarea></td></tr>
		</table>
		<br/><br/>
		<input type="submit" name="mysubmit" value="Salvesta" class="btn_reg"/>
		<input type="reset" value="Loobu" class="btn_reg">
 	</div> 

	</fo:form>
	
</div>



</body>
</html>