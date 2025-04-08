package DAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.BaseModele;
import model.Servletprevision;
import util.MaConnection;


public class PrevisionDAO implements InterfaceDAO {
    @Override
    public void save_(BaseModele prevision)  throws Exception{
        Connection con = MaConnection.getSqlConnection();
        con.setAutoCommit(false);
        PreparedStatement prp = null;
        Servletprevision prev = (Servletprevision) prevision;

        try {
            String req = "INSERT INTO servletprevision(libelle,montant) VALUES(?, ?)";
            prp = con.prepareStatement(req);
            prp.setString(1, prev.getLibelle());
            prp.setDouble(2, prev.getMontant());
          

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
        Connection con = MaConnection.getSqlConnection();
        Statement statement = con.createStatement();
        ResultSet rs = null;
        List<BaseModele> previsions= new ArrayList<>();
        try {
            String req = "SELECT * FROM servletprevision";
            rs = statement.executeQuery(req);
            while (rs.next()) {
                previsions.add(new Servletprevision(rs.getInt(1), rs.getString(2),rs.getDouble(3)) );
            }
            return previsions;
        } catch (Exception e) {
            throw e;
        }
        

    }
    public static double getSommeById(int id) throws Exception{
        Connection con = MaConnection.getSqlConnection();
        PreparedStatement prp = null;
        ResultSet rs = null;
        double somme = 0;
        try {
            String req = "SELECT montant FROM servletprevision WHERE id = ?";
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
