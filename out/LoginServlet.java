package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;

import DAO.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import util.MaConnection;
public class LoginServlet extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {

    
        String username = request.getParameter("nom");
        String password = request.getParameter("motdepasse");
        HttpSession session = request.getSession();

        try {
            Connection con = MaConnection.getSqlConnection();
            Boolean estConnecte= UserDAO.authenticate(con, username, password);
            if (estConnecte) {
                session.setAttribute("nom", username);
            }




            if (session.getAttribute("nom") != null) {
                response.sendRedirect("insert_prevision.jsp");
            } else {

                request.setAttribute("error", "Erreur de connexion, veuillez réessayer.");
                request.getRequestDispatcher("login.jsp").forward(request, response);
                
            }
        } catch (Exception e) {
            throw new ServletException(e.getMessage());
        }

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("login.jsp");
    }
    
}
