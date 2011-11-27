<%@page import="ee.itcollege.jejee.entities.Piiriloik"%>
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

<%Piiriloik p = new Piiriloik(); %>

<div id="ipiir_wrapper">
	<div id="ylemine_div">
		<fo:form action="http://localhost:8080/Piirivalve/ipiir" method="POST" commandName="piirivalvur_intsidendis_abi">
			<table>
				<tr>
					<td>
						<field:datetime id="alates" field="alates" dateTimePattern="yyyy-MM-dd" label="Alates" ></field:datetime>
					</td>
					<td>
						<field:datetime id="kuni" field="kuni" dateTimePattern="${piirivalvur_intsidendis_kuni_date_format}" label="Kuni"></field:datetime>
					</td>
					<td>
						<fo:select path="piiriloik" style="width:100px">
<%-- 						<fo:option value="---"></fo:option> --%>
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
	
	</div>
</div>

</body>
</html>