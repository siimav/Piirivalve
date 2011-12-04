<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="ee.itcollege.jejee.entities.Piiriloik"%>
<%@page import="ee.itcollege.jejee.entities.Intsident"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib  uri="http://www.springframework.org/tags/form" prefix="fo" %>
<%@ taglib tagdir="/WEB-INF/tags/form/fields" prefix="field" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Intsidendid piirilõigul detailvaade</title>
</head>
<body>

<div id="detail_main_div">

	<div id="detail_ylemine_div"><p>Intsident ${pints.intsident.kood} - ${pints.intsident.piiriloik.nimetus} - ${pints.intsident.nimetus}</p></div>
	<spring:url value="/detail/${pints.id}/p/${pvalvur.id}/muuda" var="url" />
	<fo:form method="POST" commandName="piirivalvur_intsidendis" action="${url}" >
	<div id="detail_vasak_div">
	<table>
		<tr>
			<td>
				Piirivalvur
			</td>
			<td>
				${pvalvur.perekonnanimi}, ${pvalvur.eesnimed}
			</td>
		</tr>
		<tr>
			<td>
				Sõdurikood
			</td>
			<td>
				${pvalvur.soduri_kood}
			</td>
		</tr>
		<tr>
			<td>
				Sugu
			</td>
			<td>
				<spring:url value="/detail/${pints.id}/p/${pvalvur.id}/muuda_piirivalvur" var="url" />
				<span style="float:left;">${pvalvur.sugu}</span><span style="float:right;"><input type="button" value="Muuda" onclick="window.location='${url}'"></span>
			</td>
		</tr>
		<tr>
			<td>
				Kirjeldus
			</td>
			<td>
				<fo:textarea rows="4" cols="20" path="kirjeldus"/>
			</td>
		</tr>
		<tr>
		<td></td>
		<td><FONT color="red"><fo:errors path="kirjeldus"/></FONT></td>
		</tr>
		<tr>
			<td>
				Kommentaar
			</td>
			<td>
				<fo:textarea rows="4" cols="20" path="kommentaar" />
			</td>
		</tr>
	</table>
	</div>

	<div id="detail_parem_div">
		<table>
			<tr>
				<th>Seadus</th>
				<th></th>
				<th></th>
			</tr>
			<c:forEach var="psi" items="${psi}">
			<tr>
				<td width="200px">
					${psi.seaduse_punkt.seadus.nimetus}	&sect;${psi.seaduse_punkt.paragrahv} lg${psi.seaduse_punkt.pais}
				</td>
				<td>
					<spring:url value="/detail/${pints.id}/p/${pvalvur.id}/vaata_seadus/${psi.seaduse_punkt.id}" var="url_vaataSeadus" />
					<input type="button" value="Info" onclick="window.location='${url_vaataSeadus}'">
				</td>
				<td>
					<spring:url value="/detail/${pints.id}/p/${pvalvur.id}/eemalda_seadus/${psi.id}" var="url_eemaldaSeadus" />
					<input type="button" value="Eemalda" onclick="window.location='${url_eemaldaSeadus}'">
				</td>
			</tr>
			</c:forEach>
		</table>
		<spring:url value="/detail/${pints.id}/p/${pvalvur.id}/lisa_seadus" var="url_lisaSeadus" />
		<input type="button" value="Lisa" style="float:right;margin-right:5px;margin-top:5px" onclick="window.location='${url_lisaSeadus}'">
	</div>
<div style="clear:both;"></div>
<div id="detail_btns"><input type="submit" value="Salvesta">&nbsp;&nbsp;&nbsp;<input type="reset" value="Loobu"></div>

</fo:form>

</div>

</body>
</html>