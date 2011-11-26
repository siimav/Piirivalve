<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>midagi</title>
</head>
<body>
 
    <p>Intsident ${intsident.kood} - ${intsident.piiriloik.nimetus} - ${intsident.nimetus}</p>
    
	<div class="div_left">

		<table width="100%" border="1">
			<tr>
				<th colspan="3" align="left" scope="col">Isikud</th>
			</tr>
			<c:forEach var="isik" items="${isikud}">			
				<tr>
					<td width="100%"><p>${isik.getName()}</p></td>
					<td><label> <input type="submit" name="inf3" id="inf4" value="Info" />
					</label></td>
					<td><input type="submit" name="eemalda3" id="eemalda4" value="Eemalda" /></td>
				</tr>
			</c:forEach>
		</table>
	
	<p class="button_right">
	  <label>
	    <input type="submit" name="lisa" id="lisa" value="Lisa" />
	  </label>
	</p>
	
	<br/><br/><br/>
	
		<table width="100%" border="1">
			<tr>
				<th colspan="3" align="left" scope="col">Vahtkonnad</th>
			</tr>
			<c:forEach var="vahtkond" items="${vahtkonnad}">			
				<tr>
					<td width="100%"><p>${vahtkond.nimetus}</p></td>
					<td><label> <input type="submit" name="inf3" id="inf4" value="Info" />
					</label></td>
					<td><input type="submit" name="eemalda3" id="eemalda4" value="Eemalda" /></td>
				</tr>
			</c:forEach>
		</table>
	
	<p class="button_right">
	  <label>
	    <input type="submit" name="lisa" id="lisa" value="Lisa" />
	  </label>
	</p>
	
	</div>
	
	
	<div class="div_right">

		<table width="100%" border="1">
			<tr>
				<th colspan="3" align="left" scope="col">Objektid</th>
			</tr>
			<c:forEach var="objekt" items="${objektid}">			
				<tr>
					<td width="100%"><p>${objekt.nimetus}</p></td>
					<td><label> <input type="submit" name="inf3" id="inf4" value="Info" />
					</label></td>
					<td><input type="submit" name="eemalda3" id="eemalda4" value="Eemalda" /></td>
				</tr>
			</c:forEach>
		</table>
		
		<p class="button_right">
	  <label>
	    <input type="submit" name="lisa" id="lisa" value="Lisa" />
	  </label>
	</p>
	
	<br/><br/><br/>
	
		<table width="100%" border="1">
			<tr>
				<th colspan="3" align="left" scope="col">Piirivalvurid</th>
			</tr>
			<c:forEach var="piirivalvur" items="${piirivalvurid}">			
				<tr>
					<td width="100%"><p>${piirivalvur.getName()}</p></td>
					<td><label> <input type="submit" name="inf3" id="inf4" value="Info" />
					</label></td>
					<td><input type="submit" name="eemalda3" id="eemalda4" value="Eemalda" /></td>
				</tr>
			</c:forEach>
		</table>

	  		<p class="button_right">
	  <label>
	    <input type="submit" name="lisa" id="lisa" value="Lisa" />
	  </label>
	</p>

	
	</div>
	
</body>
</html>
