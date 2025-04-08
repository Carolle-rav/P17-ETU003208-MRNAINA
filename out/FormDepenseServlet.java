package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;

import DAO.DepenseDAO;
import DAO.PrevisionDAO;
import DAO.UserDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.BaseModele;
import model.Servletdepense;
import model.Servletprevision;
import util.MaConnection;
public class FormDepenseServlet extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
       try {
        DepenseDAO depenseDAO = new DepenseDAO();
        int id_prevision = Integer.parseInt(request.getParameter("prevision_id"));
        double montant = Double.parseDouble(request.getParameter("montant"));
        double totaldepense = DepenseDAO.getTotalSommeById(id_prevision);
        double montantDepart = PrevisionDAO.getSommeById(id_prevision);
        double montantReste= montantDepart-totaldepense;
        if (montantReste > montant) {
            Servletdepense depense = new Servletdepense(id_prevision, montant);
            depenseDAO.save_(depense);
            request.setAttribute("message", "Depense inserée");
            doGet(request,response);
            
        }else{
            PrevisionDAO previsionDAO = new PrevisionDAO();
            List<BaseModele> previsions = previsionDAO.findAll();
            request.setAttribute("previsions", previsions);

            request.setAttribute("error", "Montant restant insuffisant");
            doGet(request,response);
        }

        
       } catch (Exception e) {
        throw new ServletException(e.getMessage());
       }


    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            PrevisionDAO previsionDAO = new PrevisionDAO();
            List<BaseModele> previsions = previsionDAO.findAll();
            request.setAttribute("previsions", previsions);
            RequestDispatcher dispatcher = request.getRequestDispatcher("insert_depense.jsp");
            dispatcher.forward(request, response);
            


            
        } catch (Exception e) {
            throw new ServletException(e.getMessage());
        }
    }
}
