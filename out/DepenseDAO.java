package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.BaseModele;
import model.Servletdepense;
import util.MaConnection;

public class DepenseDAO implements InterfaceDAO {
    @Override
    public void save_(BaseModele depense)  throws Exception{
        Connection con = MaConnection.getSqlConnection();
        con.setAutoCommit(false);
        PreparedStatement prp = null;
        Servletdepense dep = (Servletdepense) depense;

        try {
            String req = "INSERT INTO servletdepense(id_prevision,montant) VALUES(?, ?)";
            prp = con.prepareStatement(req);
            prp.setInt(1, dep.getId_prevision());
            prp.setDouble(2, dep.getMontant());
          

            prp.executeUpdate();

            con.commit();
        } catch (Exception e) {
            con.rollback();
            throw e;
        } finally {
            con.setAutoCommit(true);
        }
    }
    
    @Override
    public List<BaseModele> findAll() throws Exception {
        List<BaseModele> baseModeles= new ArrayList<>();
        return baseModeles
        ;

    }
    public static double getTotalSommeById(int id) throws Exception{
        Connection con = MaConnection.getSqlConnection();
        PreparedStatement prp = null;
        ResultSet rs = null;
        double somme = 0;
        try {
            String req = "SELECT SUM(montant) FROM servletdepense WHERE id = ?";
            prp = con.prepareStatement(req);
            prp.setInt(1, id);

            rs=prp.executeQuery();
            
            if (rs.next()) {
                somme = rs.getDouble(1);
            }
            

        } catch (Exception e) {
            throw e;
        }
        return somme;
        
    }

}
