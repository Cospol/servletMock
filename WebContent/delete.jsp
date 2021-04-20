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
<% Abitante abitante = (Abitante)request.getAttribute("abitanteDaInviareAPaginaDettaglio") ;%>
<table>
  <tr>
     <th>Nome</th>
     <th>Cognome</th>
     <th>Eta</th>
     <th>Codice fiscale</th>
     <th>Motto</th>
  </tr>
  <tr>
    <td ><%=abitante.getNome() %></td>
    <td><%=abitante.getCognome() %></td>
    <td><%=abitante.getEta() %></td>
    <td><%=abitante.getCodiceFiscale() %></td>
    <td><%=abitante.getMottoDiVita() %></td>
  </tr>
</table>
<br>
 <a href="ExecuteDeleteAbitanteServlet?idDaInviareComeParametro=<%=abitante.getIdAbitante() %>">elimina</a>
 <a href="Execute">home</a>
 
</body>
</html>