<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List, model.Dept" %> 
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Liste des Départements</title>
</head>
<body>
    <h2>Liste des Départements</h2>

    <%-- Affichage d'un message si présent --%>
    <% String message = (String) request.getAttribute("message"); 
       if (message != null) { %>
        <p style="color: red;"><%= message %></p>
    <% } %>

    <table border="1">
        <tr>
            <th>ID</th>
            <th>Nom</th>
        </tr>
        <% 
            List<Dept> departements = (List<Dept>) request.getAttribute("departements");
            if (departements != null) {
                for (model.Dept dept : departements) {
        %>
        <tr>
            <td><%= dept.getId() %></td>
            <td><%= dept.getNom() %></td>
        </tr>
        <% 
                }
            } else { 
        %>
        <tr><td colspan="2">Aucun département trouvé.</td></tr>
        <% } %>
    </table>

    <hr>

    <p><a href="index.jsp">Retour à l'ajout d'un département</a></p>

</body>
</html>
