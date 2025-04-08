<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List, model.Emp" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Liste des Employés</title>
</head>
<body>
    <h2>Liste des Employés</h2>

    <%-- Affichage d'un message si présent --%>
    <% String message = (String) request.getAttribute("message"); 
       if (message != null) { %>
        <p style="color: red;"><%= message %></p>
    <% } %>

    <table border="1">
        <tr>
            <th>ID</th>
            <th>Nom</th>
            <th>Prénom</th>
            <th>ID Département</th>
        </tr>
        <% 
            List<Emp> employes = (List<Emp>) request.getAttribute("employes");
            if (employes != null) {
                for (Emp emp : employes) {
        %>
        <tr>
            <td><%= emp.getId() %></td>
            <td><%= emp.getNom() %></td>
            <td><%= emp.getPrenom() %></td>
            <td><%= emp.getDeptId() %></td>
        </tr>
        <% 
                }
            } else { 
        %>
        <tr><td colspan="4">Aucun employé trouvé.</td></tr>
        <% } %>
    </table>

    <hr>

    <p><a href="index.jsp">Retour à l'ajout d'un employé</a></p>

</body>
</html>