<%@ page session="true" %>

<% 
    String nom = (String) session.getAttribute("nom"); 
%>

<h2>Bienvenue, <%= nom != null ? nom : "inconnu" %> !</h2>
