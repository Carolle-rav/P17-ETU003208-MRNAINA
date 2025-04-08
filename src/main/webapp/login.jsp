<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
    <html lang="fr">

    <head>
        <meta charset="UTF-8">
        <title>Login Servlet</title>
    </head>
    <%
   
        String error = null;
        try {
            error = (String) request.getAttribute("error");
        }
        catch (Exception e) {
            throw new ServletException(e.getMessage());
        }

        
    %>
    <body>
        <p>Login </p>
        <form name="form1" method="post" action="verifieLogin">
            <p>
                Nom : <input type="text" name="nom" value="admin">
     
            </p>
           
            <p>
                Mot de passe : <input type="password" name="motdepasse" value="123">
            </p>
       
            <p>
                <input type="submit" name="Submit" rows="5" value="Soumettre">
            </p>
            <% if(error != null){
                %>
            <p><%= error %></p>
            <% } %>
          
        </form>
        <p></p>
        <ul>
        

    </body>

    </html>