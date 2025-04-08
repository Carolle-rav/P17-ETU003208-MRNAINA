package DAO;

import java.util.List;

import model.BaseModele;

public interface InterfaceDAO {

    public abstract void save_(BaseModele modele) throws Exception;
    public abstract List<BaseModele> findAll() throws Exception;
  
    
}
