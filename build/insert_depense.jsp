<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List, model.Servletprevision,model.BaseModele" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Ajouter depenses</title>
</head>
<body>
    <h2>Insertion Depenses</h2>

   
    <% String message = (String) request.getAttribute("message"); 
       if (message != null) { %>
        <p style="color: green;"><%= message %></p>
    <% } %>
    <% String error = (String) request.getAttribute("error"); 
       if (error != null) { %>
        <p style="color: rgb(218, 15, 8);"><%= error %></p>
    <% } %>

    <form action="insertDepense" method="post">
       

        <label for="prevision">Prevision :</label>
        <select id="prevision" name="prevision_id" required>
            <% 
                List<BaseModele> previsions = (List<BaseModele>) request.getAttribute("previsions");
                if (previsions != null) {
                    for (BaseModele bm : previsions) {
                        Servletprevision prev = (Servletprevision) bm;
            %>
            <option value="<%= prev.getId() %>"><%= prev.getLibelle() %>,<%= prev.getId() %>"</option>
            <% 
                    }
                } 
            %>
        </select><br><br>
        <label for="montant">Montant :</label>
        <input type="number" id="montant" name="montant" required><br><br>



        <input type="submit" value="Ajouter">
    </form>

    <hr>

    <p><a href="insert_prevision.jsp">Retour </a></p>

</body>
</html>