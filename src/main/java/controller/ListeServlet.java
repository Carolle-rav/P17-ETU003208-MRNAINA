package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import model.BaseModele;
import model.Servletdepense;
import model.Servletprevision;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import DAO.DepenseDAO;
import DAO.PrevisionDAO;

public class ListeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            PrevisionDAO previsionDAO = new PrevisionDAO();
            DepenseDAO depenseDAO = new DepenseDAO();
    
            List<BaseModele> previsions = previsionDAO.findAll();
    
        
            List<Servletprevision> previsionsAvecMontantRestant = new ArrayList<>();
            for (BaseModele prevision : previsions) {
                Servletprevision previsionObj = (Servletprevision) prevision; 
                int idPrevision = prevision.getId(); 
                String libelle = previsionObj.getLibelle(); 
                double montantDepart = PrevisionDAO.getSommeById(idPrevision);
                double totalDepense = DepenseDAO.getTotalSommeById(idPrevision);
                double montantRestant = montantDepart - totalDepense;
    
                
                previsionsAvecMontantRestant.add(new Servletprevision(libelle, montantRestant));
            }
    
           
            request.setAttribute("previsionsAvecMontantRestant", previsionsAvecMontantRestant);
    
            RequestDispatcher dispatcher = request.getRequestDispatcher("liste.jsp");
            dispatcher.forward(request, response);
    
        } catch (Exception e) {
            throw new ServletException(e.getMessage());
        }
    }
    
}