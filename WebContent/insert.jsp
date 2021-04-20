<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 
<form action="ExecuteInsertAbitanteServlet" method="post">
		<label for="nomeInputId">NOME:</label><br>
		<input type="text" name="nomeInput" id="nomeInputId">
		<br>
		<label for="cognomeInputId">COGNOME:</label><br>
		<input type="text" name="cognomeInput" id="cognomeInputId">
		<br><br>
		<label for="codiceFiscaleInputId">CODICE FISCALE:</label><br>
		<input type="text" name="codiceFiscaleInput" id="codiceFiscaleInputId">
		<br><br>
		<label for="etaInputId">ETA:</label><br>
		<input type="text" name="etaInput" id="etaInputId">
		<br><br>
		<label for="mottoDiVitaInputId">MOTTO DI VITA:</label><br>
		<input type="text" name="mottoDiVitaInput" id="mottoDiVitaInputId">
		<br><br>
		<input type="submit" value="INSERISCI">
	
	</form>
</body>
</html>