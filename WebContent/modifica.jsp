<%@page import="it.helloabitante.model.Abitante"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% Abitante abitante = (Abitante)request.getAttribute("abitanteDaInviareAPaginaModifica") ;%>
<form action="ExecuteUpdateAbitanteServlet" method="post">
		
		<input type="hidden" name="idInput" id="idInputId"value=<%=abitante.getIdAbitante()  %>>
		
		<label for="nomeInputId">NOME:</label><br>
		<input type="text" name="nomeInput" id="nomeInputId"value=<%=abitante.getNome() %>>
		<br>
		<label for="cognomeInputId">COGNOME:</label><br>
		<input type="text" name="cognomeInput" id="cognomeInputId" value=<%=abitante.getCognome() %>>
		<br><br>
		<label for="codiceFiscaleInputId">CODICE FISCALE:</label><br>
		<input type="text" name="codiceFiscaleInput" id="codiceFiscaleInputId" value=<%=abitante.getCodiceFiscale()  %>>
		<br><br>
		<label for="etaInputId">ETA:</label><br>
		<input type="text" name="etaInput" id="etaInputId" value=<%=abitante.getEta() %>>
		<br><br>
		<label for="mottoDiVitaInputId">MOTTO DI VITA:</label><br>
		<input type="text" name="mottoDiVitaInput" id="mottoDiVitaInputId" value=<%=abitante.getMottoDiVita() %>>
		<br><br>
		<input type="submit" value="MODIFICA">
		
	</form>
	<p style="color: red;"> <%String message = (String)request.getAttribute("messageError"); %>
	<%=message != null ? request.getAttribute("messageError") : ""  %>
</body>
</html>