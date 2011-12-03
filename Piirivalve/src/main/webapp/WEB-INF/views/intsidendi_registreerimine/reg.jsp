<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
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
<spring:url value="/reg" var="url" />
<fo:form action="${url}" method="POST" commandName="intsident">
	<div id="vasak_div">
		<table border="0">
			<tr>
				<td>kood<span style="color:red;">*</span></td>
				<td><fo:input path="kood" cssClass="input_width"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;liik<span style="color:red;">*</span>

				<fo:select path="intsidendi_liik" cssClass="reg_combobox">
					<c:forEach var="ints" items="${intsidendi_liiks}">
						<fo:option value="${ints.id}">${ints.nimetus}</fo:option>
					</c:forEach>
				</fo:select>	

				</td>
			</tr>
<!-- 			<tr> -->
<!-- 				<td>liik<span style="color:red;">*</span></td> -->
<!-- 				<td height="30px"> -->
<%-- 				<fo:select path="intsidendi_liik"> --%>
<%-- 					<c:forEach var="ints" items="${intsidendi_liiks}"> --%>
<%-- 						<fo:option value="${ints.id}">${ints.nimetus}</fo:option> --%>
<%-- 					</c:forEach> --%>
<%-- 				</fo:select>			 --%>
<!-- 				</td> -->
<!-- 			</tr> -->
			<tr><td>nimetus<span style="color:red;">* </span></td><td><fo:input path="nimetus" cssClass="reg_input_adjust"/></td></tr>
			<tr><td>piirilõik<span style="color:red;">*</span></td>
				<td>
				<fo:select path="piiriloik" style="width:185px; height:25px; font-size:13px;" >
				<c:forEach var="piir" items="${piiriloiks}">
					<fo:option value="${piir.id}">${piir.nimetus}</fo:option>
				</c:forEach>
				</fo:select>
				</td>
			</tr>
			<tr><td>koordnaadid<span style="color:red;">*</span></td><td><fo:input path="GPS_latituud" style="width:80px"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fo:input path="GPS_longituud" style="width:80px"/><td/></tr>
			<tr><td>algus<span style="color:red;">* </span></td><td><field:datetime dateTimePattern="yyyy-MM-dd" field="toimumise_algus" id="algus" required="true" label=" "/></td></tr>
			<tr><td>lopp<span style="color:red;">* </span></td><td><field:datetime dateTimePattern="yyyy-MM-dd" field="toimumise_lopp" id="lopp" required="true" label=" "/></td></tr>
		</table>
 	</div> 

	<div id="parem_div">
		<table>
			<tr><td>Kirjeldus<span style="color:red;">*</span></td><td></td></tr>
			<tr><td><fo:textarea path="kirjeldus" rows="4" cols="25"></fo:textarea></td></tr>
			<tr height=50px><td></td></tr>
			<tr><td>Kommentaar</td><td></td></tr>
			<tr><td><fo:textarea path="kommentaar" rows="4" cols="25"></fo:textarea></td></tr>
		</table>
		<br/><br/>
		<input type="reset" value="Loobu" class="btn_reg">
		<input type="submit" name="mysubmit" value="Salvesta" class="btn_reg"/>	
 	</div> 

	<table>
	<tr><td><FONT color="red"><fo:errors path="kood"/></FONT></td></tr>
	<tr><td><FONT color="red"><fo:errors path="nimetus"/></FONT></td></tr>
<%-- 	<tr><td><FONT color="red"><fo:errors path="toimumise_algus"/></FONT></td></tr> --%>
<%-- 	<tr><td><FONT color="red"><fo:errors path="toimumise_lopp"/></FONT></td></tr> --%>
	<tr><td><FONT color="red"><fo:errors path="kirjeldus"/></FONT></td></tr>
	<tr><td><FONT color="red"><fo:errors path="GPS_latituud"/></FONT></td></tr>
	</table>

	<% 
	java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd");
	String dateAsString = simpleDateFormat.format(new java.util.Date());
	%>

	<fo:input path="avaja" cssClass="hidden" value="avaja"/>
	<fo:input path="avatud" cssClass="hidden" value="<%= dateAsString %>"/>
	<fo:input path="sulgeja" cssClass="hidden" value="sulgeja"/>
	<fo:input path="suletud" cssClass="hidden" value="<%= dateAsString %>"/>
	<fo:input path="muutja" cssClass="hidden" value="muutja"/>
	<fo:input path="muudetud" cssClass="hidden" value="<%= dateAsString %>"/>

	</fo:form>

</div>



</body>
</html>