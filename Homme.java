package model;
import java.util.*;

public class Homme extends Personne {

    public Vector<Personne> enfants = new Vector<Personne> ();
    public Vector<Mariage> listMar = new Vector<Mariage> ();

    public Homme(String nom, String prenom, Date dateNaissance, Date dateMort, Femme mere, Homme pere, ArbreGenealogique arbre) {
        super(nom, prenom, dateNaissance, dateMort, mere, pere, arbre);
    }

    public Homme( String nom, String prenom, Date dateNaissance, Date dateMort, ArbreGenealogique arbre) {
        super(nom, prenom, dateNaissance, dateMort, arbre);
    }

    public Homme( String nom, String prenom, Date dateNaissance, ArbreGenealogique arbre) {
        super(nom, prenom, dateNaissance, arbre);
    }

    public void ajouterEnfant(Personne enfant) {
        enfants.add(enfant);
        enfant.setPere(this);
    }
    public Vector<Personne> obtenirEnfants() {
        return enfants;
    }
    
    public void ajouterMariage(Mariage mariage) {
        listMar.add(mariage);
    }
}