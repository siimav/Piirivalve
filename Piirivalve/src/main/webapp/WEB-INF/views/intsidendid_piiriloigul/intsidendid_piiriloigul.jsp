<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="ee.itcollege.jejee.entities.Piiriloik"%>
<%@page import="ee.itcollege.jejee.entities.Intsident"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib  uri="http://www.springframework.org/tags/form" prefix="fo" %>
<%@ taglib tagdir="/WEB-INF/tags/form/fields" prefix="field" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Intsidendid piirilõigul</title>
</head>
<body>

<div id="ipiir_wrapper">
	<div id="ylemine_div">
		<fo:form action="http://localhost:8080/Piirivalve/ipiir" method="GET" commandName="piirivalvur_intsidendis_abi" >
			<table>
				<tr>
					<td>
						<field:datetime id="alates" field="alates" dateTimePattern="yyyy-MM-dd" label="Alates" ></field:datetime>
					</td>
					<td>
						<field:datetime id="kuni" field="kuni" dateTimePattern="yyyy-MM-dd" label="Kuni"></field:datetime>
					</td>
					<td>
						<fo:select path="piiriloik_ID" style="width:100px" itemLabel="Piirilõik">
						<fo:option value="0">---</fo:option>
						<c:forEach var="piir" items="${piiriloiks}">
							<fo:option value="${piir.piiriloik_ID}">${piir.nimetus}</fo:option>
						</c:forEach>
						</fo:select>
					</td>
					<td width="100px">
						<input type="submit" name="mysubmit" value="Värskenda" />
					</td>
				</tr>
			</table>
		</fo:form>	
	</div>
	
	<div id="alumine_div">
	<c:forEach var="ints" items="${ints_piiriloigul_piirivalvur}">
		<div>
		<table>
			<tr>
				<th>${ints.piirivalvur.soduri_kood}: ${ints.piirivalvur.perekonnanimi}, ${ints.piirivalvur.eesnimed}</th>
    			<th></th>
			</tr>
			<tr>
				<td width="500px">
					${ints.intsident.nimetus}
				</td>
				<td>
					<input type="button" name="btn" value="Vaata">
				</td>
			</tr>
			<tr>
				<td>
					${ints.alates}
				</td>
				<td>
			
				</td>
			</tr>
			<tr>
				<td width="100px">
					${ints.kuni}
				</td>
				<td>
					
				</td>
			</tr>
		</table>
		</div>
		<br/>
	</c:forEach>
	
	</div>
</div>

</body>
</html>