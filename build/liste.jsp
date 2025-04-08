<%@ page import="java.util.List, model.Servletprevision,model.BaseModele" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Liste des Previsions</title>
</head>
<body>
    <h1>Liste des Previsions</h1>
    <table border="1">
        <thead>
            <tr>
                <th>Prevision</th>
                <th>Reste Montant</th>
            </tr>
        </thead>
        <tbody>
            <%
                List<Servletprevision> previsions = (List<Servletprevision>) request.getAttribute("previsionsAvecMontantRestant");
                if (previsions != null) {
                    for (Servletprevision prevision : previsions) {
            %>
                <tr>
                    <td><%= prevision.getLibelle() %></td>
                    <td><%= prevision.getMontant() %></td>
                </tr>
            <%
                    }
                }
            %>
        </tbody>
    </table>
</body>
</html>