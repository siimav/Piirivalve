<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Seaduse vaade</title>
</head>
<body>

<table>
	<tr>
		<th>Seadus</th><th>Paragrahv</th><th>Pais</th><th>Tekst</th><th>Kehtiv alates</th><th>Kehtiv kuni</th>
	</tr>
	<tr>
		<td>
			${sp.seadus.nimetus}
		</td>
		<td>
			${sp.paragrahv}
		</td>
		<td>
			${sp.pais}
		</td>
		<td>
			${sp.tekst}
		</td>
		<td>
			${sp.kehtiv_alates}
		</td>
		<td>
			${sp.kehtiv_kuni}
		</td>
	</tr>
</table>
</br>
<input type="button" value="Tagasi" onclick="history.back()">

</body>
</html>