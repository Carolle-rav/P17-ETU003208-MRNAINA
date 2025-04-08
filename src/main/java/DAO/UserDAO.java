package DAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.BaseModele;


public class UserDAO implements InterfaceDAO {
    public static boolean authenticate(Connection connexion ,String username, String password) throws Exception {
        Statement stmt = connexion.createStatement();
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery("SELECT * FROM servletuser WHERE nom = '" + username + "' AND mot_de_passe = '" + password + "'");
            if (rs.next()) {
                return true; // Authentification réussie
            } else {
                return false; // Authentification échouée
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
        }
        
    }
    @Override
    public void save_(BaseModele modele) throws Exception{

    }
    @Override
    public List<BaseModele> findAll() throws Exception {
        List<BaseModele> baseModeles= new ArrayList<>();
        return baseModeles
        ;

    }
    
}
