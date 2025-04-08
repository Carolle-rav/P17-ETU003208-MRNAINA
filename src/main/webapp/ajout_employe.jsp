<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List, model.Dept" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Ajouter un Employé</title>
</head>
<body>
    <h2>Ajouter un Employé</h2>

    <%-- Affichage d'un message si présent --%>
    <% String message = (String) request.getAttribute("message"); 
       if (message != null) { %>
        <p style="color: red;"><%= message %></p>
    <% } %>

    <form action="ajout_employe" method="post">
        <label for="nom">Nom :</label>
        <input type="text" id="nom" name="nom" required><br><br>

        <label for="prenom">Prénom :</label>
        <input type="text" id="prenom" name="prenom" required><br><br>

        <label for="dept">Département :</label>
        <select id="dept" name="dept_id" required>
            <% 
                List<Dept> departements = (List<Dept>) request.getAttribute("departements");
                if (departements != null) {
                    for (Dept dept : departements) {
            %>
            <option value="<%= dept.getId() %>"><%= dept.getNom() %></option>
            <% 
                    }
                } 
            %>
        </select><br><br>

        <input type="submit" value="Ajouter">
    </form>

    <hr>

    <p><a href="index.jsp">Retour à l'accueil</a></p>

</body>
</html>