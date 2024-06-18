package model;
import java.util.*;
public class Personne {

    private String nom;
    private String prenom;
    private Date dateNaissance;
    private Date dateMort;
    private ArbreGenealogique arbre = new ArbreGenealogique();
    public Femme mere;
    public Homme pere;
	
	public Personne(String nom, String prenom, Date dateNaissance, Date dateMort, Femme mere, Homme pere, ArbreGenealogique arbre) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.dateMort = dateMort;
		this.mere = mere;
		this.pere = pere;
        this.arbre = arbre;
        if (mere != null) {
            mere.ajouterEnfant(this);
        }
        if (pere != null) {
            pere.ajouterEnfant(this);
        }

        arbre.ajouterPersonne(this);
    }
	
    public Personne(String nom, String prenom, Date dateNaissance, Date dateMort, ArbreGenealogique arbre) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.dateMort = dateMort;
        this.arbre = arbre;
    }
    
    public Personne(String nom, String prenom, Date dateNaissance, ArbreGenealogique arbre) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.arbre = arbre;
    }
    public void setNom (String nom) {
        this.nom = nom;
    }
    public String getNom() {
        return this.nom;
    }
    public void setPrenom (String prenom) {
        this.prenom = prenom;
    }
    public String getPrenom() {
        return this.prenom;
    }
    public void setDateNaissance (Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
    public Date getDateNaissance() {
        return this.dateNaissance;
    }
    public void setDateMort (Date dateMort) {
        this.dateMort = dateMort;
    }
    public Date getDateMort() {
        return this.dateMort;
    }
    public void setArbre (ArbreGenealogique arbre) {
        this.arbre = arbre;
    }
    public ArbreGenealogique getArbre() {
        return this.arbre;
    }
    public Femme getMere() {
        return this.mere;
    }
    public Homme getPere() {
        return this.pere;
    }
    public void setMere(Femme mere){
        this.mere = mere;
    }
    public void setPere(Homme pere) {
        this.pere = pere;
    }
}