<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>midagi</title>
<spring:url value="/intsident/${intsident.id}/" var="url" />
<script language="javascript"> 
	function redirectTo(url) {		
		window.location = "${url}" + url;
	}
	
	function showNIY() {		
		alert("<spring:message code="msg_not_impelemnted"/>");
	}
</script> 

</head>
<body>

    <p><spring:message code="label_ee_itcollege_jejee_entities_intsident"/> ${intsident.kood} - ${intsident.piiriloik.nimetus} - ${intsident.nimetus}</p>
    
	<div class="div_left">

		<table width="100%" border="1">
			<tr>
				<th colspan="3" align="left" scope="col"><spring:message code="label_isikud"/></th>
			</tr>
			<c:forEach var="ii" items="${isikud_intsidendis}">			
				<tr>
					<td width="100%"><p>${ii.piiririkkuja.getName()}</p></td>
					<td><label> <input type="button" name="info" value="Info" onClick="showNIY()" />
					</label></td>
					<td><input type="button" name="kustuta" value="<spring:message code="label_kustuta"/>" onClick="redirectTo('kustuta_piiririkkuja/${ii.id}')" /></td>
				</tr>
			</c:forEach>
		</table>
	
	<p class="button_right">
	  <label>
	    <input type="button" name="lisa" value="<spring:message code="label_lisa"/>" onClick="redirectTo('lisa_piiririkkuja')" />
	  </label>
	</p>
	
	<br/><br/><br/>
	
		<table width="100%" border="1">
			<tr>
				<th colspan="3" align="left" scope="col"><spring:message code="label_ee_itcollege_jejee_entities_vahtkond_plural"/></th>
			</tr>
			<c:forEach var="vi" items="${vahtkonnad_intsidendis}">			
				<tr>
					<td width="100%"><p>${vi.vahtkond.nimetus}</p></td>
					<td><label> <input type="button" name="info" value="Info" onClick="showNIY()" />
					</label></td>
					<td><input type="button" name="kustuta" value="<spring:message code="label_kustuta"/>" onClick="redirectTo('kustuta_vahtkond/${vi.id}')" /></td>
				</tr>
			</c:forEach>
		</table>
	
	<p class="button_right">
	  <label>
	    <input type="button" name="lisa" value="<spring:message code="label_lisa"/>" onClick="redirectTo('lisa_vahtkond')" />
	  </label>
	</p>
	
	</div>
	
	
	<div class="div_right">

		<table width="100%" border="1">
			<tr>
				<th colspan="3" align="left" scope="col"><spring:message code="label_ee_itcollege_jejee_entities_objekt_plural"/></th>
			</tr>
			<c:forEach var="oi" items="${objektid_intsidendis}">			
				<tr>
					<td width="100%"><p>${oi.objekt.nimetus}</p></td>
					<td><label> <input type="button" name="info" value="Info" onClick="showNIY()" />
					</label></td>
					<td><input type="button" name="kustuta" value="<spring:message code="label_kustuta"/>" onClick="redirectTo('kustuta_objekt/${oi.id}')" /></td>
				</tr>
			</c:forEach>
		</table>
		
		<p class="button_right">
	  <label>
	    <input type="button" name="lisa" value="<spring:message code="label_lisa"/>" onClick="redirectTo('lisa_objekt')" />
	  </label>
	</p>
	
	<br/><br/><br/>
	
		<table width="100%" border="1">
			<tr>
				<th colspan="3" align="left" scope="col"><spring:message code="label_ee_itcollege_jejee_entities_piirivalvur_plural"/></th>
			</tr>
			<c:forEach var="pi" items="${piirivalvurid_intsidendis}">
				<tr>
					<td width="100%"><p>${pi.piirivalvur.getName()}</p></td>
					<td><label> <input type="button" name="info" value="Info" onClick="showNIY()" />
					</label></td>
					<td><input type="button" name="kustuta" value="<spring:message code="label_kustuta"/>" onClick="redirectTo('kustuta_piirivalvur/${pi.id}')" /></td>
				</tr>
			</c:forEach>
		</table>

	  	<p class="button_right">
	  	<label>
	    <input type="button" name="lisa" value="<spring:message code="label_lisa"/>" onClick="redirectTo('lisa_piirivalvur')" />
	  	</label>
	</p>

	
	</div>

</body>
</html>
