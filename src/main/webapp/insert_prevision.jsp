<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
    <html lang="fr">

    <head>
        <meta charset="UTF-8">
        <title>Login Servlet</title>
    </head>
    <body>
        <p>Insertion Prevision </p>
        <% String message = (String) request.getAttribute("message"); 
       if (message != null) { %>
        <p style="color: green;"><%= message %></p>
    <% } %>
        <form name="form1" method="post" action="insertPrevision">
            <p>
                Libelle : <input type="text" name="libelle">
     
            </p>
           
            <p>
                Montant : <input type="number" name="montant">
            </p>
       
            <p>
                <input type="submit" name="Submit" rows="5" value="Soumettre">
            </p>
          
        </form>
        <p><a href="formDepense">Inserer depenses</a></p>
        <p><a href="liste">Liste etat</a></p>

    </body>

    </html>