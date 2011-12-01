<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>midagi</title>

<script language="javascript"> 
	function redirectTo(url) { 
		window.location = "/Piirivalve/intsident/${intsident.id}/" + url;
	} 
</script> 

</head>
<body>
 
    <p>Intsident ${intsident.kood} - ${intsident.piiriloik.nimetus} - ${intsident.nimetus}</p>
    
	<div class="div_left">

		<table width="100%" border="1">
			<tr>
				<th colspan="3" align="left" scope="col">Isikud</th>
			</tr>
			<c:forEach var="ii" items="${isikud_intsidendis}">			
				<tr>
					<td width="100%"><p>${ii.piiririkkuja.getName()}</p></td>
					<td><label> <input type="submit" name="inf3" id="inf4" value="Info" />
					</label></td>
					<td><input type="button" id="kustuta" value="Kustuta" onClick="redirectTo('kustuta_piiririkkuja/${ii.id}')" /></td>
				</tr>
			</c:forEach>
		</table>
	
	<p class="button_right">
	  <label>
	    <input type="button" id="lisa" value="Lisa" onClick="redirectTo('lisa_piiririkkuja')" />
	  </label>
	</p>
	
	<br/><br/><br/>
	
		<table width="100%" border="1">
			<tr>
				<th colspan="3" align="left" scope="col">Vahtkonnad</th>
			</tr>
			<c:forEach var="vi" items="${vahtkonnad_intsidendis}">			
				<tr>
					<td width="100%"><p>${vi.vahtkond.nimetus}</p></td>
					<td><label> <input type="submit" name="inf3" id="inf4" value="Info" />
					</label></td>
					<td><input type="button" id="kustuta" value="Kustuta" onClick="redirectTo('kustuta_vahtkond/${vi.id}')" /></td>
				</tr>
			</c:forEach>
		</table>
	
	<p class="button_right">
	  <label>
	    <input type="button" id="lisa" value="Lisa" onClick="redirectTo('lisa_vahtkond')" />
	  </label>
	</p>
	
	</div>
	
	
	<div class="div_right">

		<table width="100%" border="1">
			<tr>
				<th colspan="3" align="left" scope="col">Objektid</th>
			</tr>
			<c:forEach var="oi" items="${objektid_intsidendis}">			
				<tr>
					<td width="100%"><p>${oi.objekt.nimetus}</p></td>
					<td><label> <input type="submit" name="inf3" id="inf4" value="Info" />
					</label></td>
					<td><input type="button" id="kustuta" value="Kustuta" onClick="redirectTo('kustuta_objekt/${oi.id}')" /></td>
				</tr>
			</c:forEach>
		</table>
		
		<p class="button_right">
	  <label>
	    <input type="button" id="lisa" value="Lisa" onClick="redirectTo('lisa_objekt')" />
	  </label>
	</p>
	
	<br/><br/><br/>
	
		<table width="100%" border="1">
			<tr>
				<th colspan="3" align="left" scope="col">Piirivalvurid</th>
			</tr>
			<c:forEach var="pi" items="${piirivalvurid_intsidendis}">			
				<tr>
					<td width="100%"><p>${pi.piirivalvur.getName()}</p></td>
					<td><label> <input type="submit" name="inf3" id="inf4" value="Info" />
					</label></td>
					<td><input type="button" id="kustuta" value="Kustuta" onClick="redirectTo('kustuta_piirivalvur/${pi.id}')" /></td>
				</tr>
			</c:forEach>
		</table>

	  		<p class="button_right">
	  <label>
	    <input type="button" id="lisa" value="Lisa" onClick="redirectTo('lisa_piirivalvur')" />
	  </label>
	</p>

	
	</div>
	
</body>
</html>
