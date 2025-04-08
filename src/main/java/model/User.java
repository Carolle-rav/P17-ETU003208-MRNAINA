package model;

public class User extends BaseModele {
    

    private String nom;
    private String mot_de_passe;

    public User(String nom, String mot_de_passe) {
        this.nom = nom;
        this.mot_de_passe = mot_de_passe;
    }

    public User(int id, String nom, String mot_de_passe) {
        this.id=id;
        this.nom = nom;
        this.mot_de_passe = mot_de_passe;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMotDePasse() {
        return mot_de_passe;
    }

    public void setMotDePasse(String mot_de_passe) {
        this.mot_de_passe = mot_de_passe;
    }
    
}
