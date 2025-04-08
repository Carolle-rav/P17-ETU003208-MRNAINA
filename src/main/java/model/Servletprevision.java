package model;

public class Servletprevision extends BaseModele{

    private String libelle;
    private double montant;

    public Servletprevision(String libelle, double montant) {
        this.libelle = libelle;
        this.montant = montant;
    }
    public Servletprevision(int id,String libelle, double montant) {
        this.id=id;
        this.libelle = libelle;
        this.montant = montant;
    }
    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }
    


}
