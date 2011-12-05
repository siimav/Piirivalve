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
<title>Registreerimine</title>
</head>
<body>

<div id="main_wrapper">
<spring:url value="/reg" var="url" />
<fo:form action="${url}" method="POST" commandName="intsident">
	<div id="vasak_div">
		<table border="0">
			<tr>
				<td><spring:message code="label_ee_itcollege_jejee_entities_intsident_kood"/><span style="color:red;">*</span></td>
				<td><fo:input path="kood" cssClass="input_width"/>&nbsp;&nbsp;<spring:message code="label_liik"/><span style="color:red;">*</span>   
				<fo:select path="intsidendi_liik" cssClass="reg_combobox">
	            	<c:forEach var="ints" items="${intsidendi_liiks}">
	            		<fo:option value="${ints.id}">${ints.nimetus}</fo:option>
	          		</c:forEach>
	        	</fo:select>
				</td>
			</tr>

			<tr><td><spring:message code="label_ee_itcollege_jejee_entities_intsident_nimetus"/><span style="color:red;">* </span></td><td><fo:input path="nimetus" cssClass="reg_input_adjust"/></td></tr>
			<tr><td><spring:message code="label_ee_itcollege_jejee_entities_piiriloik"/><span style="color:red;">*</span></td>
				<td>
				<fo:select path="piiriloik" style="width:185px; height:25px; font-size:13px;" >
				<c:forEach var="piir" items="${piiriloiks}">
					<fo:option value="${piir.id}">${piir.nimetus}</fo:option>
				</c:forEach>
				</fo:select>
				</td>
			</tr>
			<tr><td><spring:message code="label_koordinaadid"/><span style="color:red;">*</span></td><td><fo:input path="GPS_latituud" style="width:80px"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fo:input path="GPS_longituud" style="width:80px"/><td/></tr>
			<tr><td><spring:message code="label_algus"/><span style="color:red;">* </span></td><td><field:datetime dateTimePattern="yyyy-MM-dd" field="toimumise_algus" id="algus" required="true" label=" "/></td></tr>
			<tr><td><spring:message code="label_lopp"/><span style="color:red;">* </span></td><td><field:datetime dateTimePattern="yyyy-MM-dd" field="toimumise_lopp" id="lopp" required="true" label=" "/></td></tr>
		</table>
 	</div> 

	<div id="parem_div">
		<table>
			<tr><td><spring:message code="label_kirjeldus"/><span style="color:red;">*</span></td><td></td></tr>
			<tr><td><fo:textarea path="kirjeldus" rows="4" cols="25"></fo:textarea></td></tr>
			<tr height=50px><td></td></tr>
			<tr><td><spring:message code="label_kommentaar"/></td><td></td></tr>
			<tr><td><fo:textarea path="kommentaar" rows="4" cols="25"></fo:textarea></td></tr>
		</table>
		<br/><br/>
		<input type="reset" value="<spring:message code='label_loobu'/>" class="btn_reg">
		<input type="submit" name="mysubmit" value="<spring:message code='label_salvesta'/>" class="btn_reg"/>	
 	</div> 

	<div style="clear:both;">
	<table>
	<tr><td><FONT color="red"><fo:errors path="kood"/></FONT></td></tr>
	<tr><td><FONT color="red"><fo:errors path="nimetus"/></FONT></td></tr>
<%-- 	<tr><td><FONT color="red"><fo:errors path="toimumise_algus"/></FONT></td></tr> --%>
<%-- 	<tr><td><FONT color="red"><fo:errors path="toimumise_lopp"/></FONT></td></tr> --%>
	<tr><td><FONT color="red"><fo:errors path="kirjeldus"/></FONT></td></tr>
	<tr><td><FONT color="red"><fo:errors path="GPS_latituud"/></FONT></td></tr>
	</table>
	</div>	
	
	<% 
	java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd");
	String dateAsString = simpleDateFormat.format(new java.util.Date());
	%>

	<div>
	<fo:input path="avaja" cssClass="hidden" value="avaja"/>
	<fo:input path="avatud" cssClass="hidden" value="<%= dateAsString %>"/>
	<fo:input path="sulgeja" cssClass="hidden" value="sulgeja"/>
	<fo:input path="suletud" cssClass="hidden" value="<%= dateAsString %>"/>
	<fo:input path="muutja" cssClass="hidden" value="muutja"/>
	<fo:input path="muudetud" cssClass="hidden" value="<%= dateAsString %>"/>
	</div>
	
	</fo:form>

</div>



</body>
</html>
