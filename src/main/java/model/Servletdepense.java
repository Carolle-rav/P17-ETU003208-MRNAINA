package model;

public class Servletdepense extends BaseModele{
    private int id_prevision;
    private double montant;

    public Servletdepense(int id_prevision, double montant) {
        this.id_prevision = id_prevision;
        this.montant = montant;
    }
    public Servletdepense(int id,int id_prevision, double montant) {
        this.id=id;
        this.id_prevision = id_prevision;
        this.montant = montant;
    }
    public int getId_prevision() {
        return id_prevision;
    }

    public void setId_prevision(int id_prevision) {
        this.id_prevision = id_prevision;
    }
    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }
    
}
