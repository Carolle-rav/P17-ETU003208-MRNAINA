package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;

import DAO.PrevisionDAO;
import DAO.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Servletprevision;
import util.MaConnection;

public class PrevisionServlet extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
        try {
            PrevisionDAO previsionDAO = new PrevisionDAO(); 
            String libelle = request.getParameter("libelle");
            double montant = Double.parseDouble(request.getParameter("montant"));
            Servletprevision prevision = new Servletprevision(libelle,montant);
            previsionDAO.save_(prevision);

            request.setAttribute("message", "Prevision inserée");
            request.getRequestDispatcher("insert_prevision.jsp").forward(request, response);
            
            
        } catch (Exception e) {
            throw new ServletException(e.getMessage());

        }
        


    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("insert_prevision.jsp");
    }
}
