package model;
import java.util.*;

public class ArbreGenealogique {
    public Vector<Personne> listPers = new Vector<Personne> ();
    public ArbreGenealogique(){ }

    public void ajouterPersonne(Personne personne) {
        listPers.add(personne);
    }
    //Methodes Final
    /*------------------------------------------------------------------------------------------------------------ */
    public String AfficherArbre(ArbreGenealogique arbre){
        Vector<Personne> arbreResult = arbre.obtenirArbre();
        String result = "Arbre généalogique :\n";
        for (Personne personne : arbreResult) {
            result += TransformPersToString(personne);
            if(personne.getPere() != null){
                result += "Père: " + personne.getPere().getPrenom() + " " + personne.getPere().getNom() + "\n";
            }
                if(personne.getMere() != null){
                    result += "Mère: " + personne.getMere().getPrenom() + " " + personne.getMere().getNom() + "\n";
                }
                if(personne instanceof Homme){
                    Homme homme = (Homme) personne;
                    for (Mariage mariage : homme.listMar) {
                        result += "Marié à: " + mariage.getEpouse().getPrenom() + " " + mariage.getEpouse().getNom() + "\n";
                    }
                } else if (personne instanceof Femme) {
                    Femme femme = (Femme) personne;
                    for (Mariage mariage : femme.listM) {
                        result += "Mariée à: " + mariage.getEpoux().getPrenom() + " " + mariage.getEpoux().getNom() + "\n";
                    }
                }
                //ajouter les frers d une personne
                if(personne instanceof Homme){
                    Homme homme = (Homme) personne;
                    for (Personne frere : obtenirFreresSoeurs(homme)) {
                        result += "Frère: " + frere.getPrenom() + " " + frere.getNom() + "\n";
                    }
                } else if (personne instanceof Femme) {
                    Femme femme = (Femme) personne;
                    for (Personne soeur : obtenirFreresSoeurs(femme)) {
                        result += "Soeur: " + soeur.getPrenom() + " " + soeur.getNom() + "\n";
                    }
                }
                result += "\n";
            }
           return result;
    }
    public String AfficherAncetres(Personne personne){
        Vector<Personne> aResult = new  Vector<Personne>();
        aResult = obtenirAncetres(personne);
        String result = "Ancetres de "+personne.getPrenom()+" "+personne.getNom()+" sont :\n";
        for(Personne pers : aResult){
            result += TransformPersToString(pers);
        }
        return result;
    }
    public String AfficherFrersSoeurs(Personne personne){
        Vector<Personne> aResult = new  Vector<Personne>();
        aResult =obtenirFreresSoeurs(personne);
        String result = "Frères et soeurs de "+personne.getPrenom()+" "+personne.getNom()+" sont :\n";
        for(Personne pers : aResult){
            result += TransformPersToString(pers);
        }
        return result;
    }
    public String AfficherCousins(Personne personne){
        Vector<Personne> aResult = new  Vector<Personne>();
        aResult = obtenirCousins(personne);
        String result = "Cousins de "+personne.getPrenom()+" "+personne.getNom()+" sont :\n";
        for(Personne pers : aResult){
            result += TransformPersToString(pers);
        }
        return result;
    }
    public String AfficherLienParente(Personne personne1, Personne personne2){
        String aResult;
        aResult = obtenirLienParente(personne1, personne2);
        return aResult;
    }
    /*------------------------------------------------------------------------------------------------------------ */
    //Methodes utilitaires
    public Personne RecherchePersArbre(String pers, ArbreGenealogique arbre){//rechercher une personne dans l arbre
        String nm;
        for(Personne personne : arbre.listPers){
            nm=("Nom: " + personne.getNom() + ", Prénom: " + personne.getPrenom() +", Date de Naissance: " + personne.getDateNaissance() +", Genre: " + (personne instanceof Homme ? "Homme" : "Femme") +(personne.getDateMort() != null ? ", Date de Mort: " + personne.getDateMort() : ", La personne est vivante.") + "\n");
            if(nm.equals(pers)){
                return personne;
            }
        }
        return null;
    }
    public String[] getPers(Vector<Personne> listP) {//tresnformer un vecteur de personne a un tebleau de String
        int i = 0;
        String[] list = new String[listP.size()];
        for (Personne personne : listP) {
            list[i] = "Nom: " + personne.getNom() + ", Prénom: " + personne.getPrenom() + ", Date de Naissance: " + personne.getDateNaissance() + ", Genre: " + (personne instanceof Homme ? "Homme" : "Femme") + (personne.getDateMort() != null ? ", Date de Mort: " + personne.getDateMort() : ", La personne est vivante.") + "\n";
            i++;
        }
        return list;
    }
    
    
    public String TransformPersToString(Personne personne){//Personne to String jai cree cette methode pour eviter a chaque fois decrire l affichage de chaque perosnne seul
        return ("Nom: " + personne.getNom() + ", Prénom: " + personne.getPrenom() +", Date de Naissance: " + personne.getDateNaissance() +", Genre: " + (personne instanceof Homme ? "Homme" : "Femme") +(personne.getDateMort() != null ? ", Date de Mort: " + personne.getDateMort() : ", La personne est vivante.") + "\n");
    }

    public Vector<Personne> removeDuplicates(Vector<Personne> vector) {//methode qui supp les double dans un vecteur de type personne
        Vector<Personne> uniqueVector = new Vector<>();
    
        for (Personne personne : vector) {
            if (!uniqueVector.contains(personne)) {
             uniqueVector.add(personne);
            }
        }
        return uniqueVector;
    }
    /*------------------------------------------------------------------------------------------------------------ */
    // Methodes pour obtenir des informations
    //obtenir Arbre
    public Vector<Personne> obtenirArbre() {
        Vector<Personne> arbre = new Vector<>();
        for (Personne personne : listPers) {
            arbre.add(personne);
        }
        return arbre;
    }
    //obtenir ancetres
    public Vector<Personne> obtenirAncetres(Personne personne) {
        Vector<Personne> ancetres = new Vector<>();
        obtenirAncetresRecursif(personne, ancetres);
        return ancetres;
    }

    private void obtenirAncetresRecursif(Personne personne, Vector<Personne> ancetres) {
        if (personne.pere != null) {
            ancetres.add(personne.pere);
            obtenirAncetresRecursif(personne.pere, ancetres);
        }
        if (personne.mere != null) {
         ancetres.add(personne.mere);
            obtenirAncetresRecursif(personne.mere, ancetres);
     }
    }
    //obtenir Frers Et Soeurs
    public Vector<Personne> obtenirFreresSoeurs(Personne personne) {
        Vector<Personne> freresSoeurs = new Vector<>();
        obtenirFreresSoeurs(personne, freresSoeurs);
        return freresSoeurs;
    }
    
    private void obtenirFreresSoeurs(Personne personne, Vector<Personne> freresSoeurs) {
        if (personne.pere != null || personne.mere != null) {
            if (personne.pere != null) {
                for (Personne frere : personne.pere.enfants) {
                    if (!frere.equals(personne)) {
                        freresSoeurs.add(frere);
                    }
                }
                freresSoeurs=removeDuplicates(freresSoeurs);
            }
            if (personne.mere != null) {
                for (Personne soeur : personne.mere.enfants) {
                    if (!soeur.equals(personne)) {
                        freresSoeurs.add(soeur);
                    }
                }
                freresSoeurs=removeDuplicates(freresSoeurs);//2 lien cote pere et cote meme comme ca on evite de trouvez deux fois la meme personnes
            }
        } else {
            System.out.println("Impossible de trouver les frères et sœurs sans les informations des parents.");
        }
    }

    //obtenir Cousins
    public Vector<Personne> obtenirCousins(Personne personne) {
        Vector<Personne> coussins = new Vector<>();
        if (personne.getPere() != null) {
            Personne pere = personne.getPere();
            if (pere instanceof Homme) {
                Vector<Personne> freresSoeurs = obtenirFreresSoeurs((Homme) pere);
                for (Personne frereSoeur : freresSoeurs) {
                    if(frereSoeur instanceof Homme){
                        Vector<Personne> enfants = ((Homme) frereSoeur).obtenirEnfants();
                        for (Personne enfant : enfants) {
                            coussins.add(enfant);
                        }
                    }
                    else{
                        Vector<Personne> enfants = ((Femme) frereSoeur).obtenirEnfants();
                        for (Personne enfant : enfants) {
                            coussins.add(enfant);
                        } 
                    }
                }
            }
        }
        if (personne.getMere() != null) {
            Personne mere = personne.getMere();
            if (mere instanceof Femme) {
                Vector<Personne> freresSoeurs = obtenirFreresSoeurs((Femme) mere);
                for (Personne frereSoeur : freresSoeurs) {
                    if(frereSoeur instanceof Homme){
                        Vector<Personne> enfants = ((Homme) frereSoeur).obtenirEnfants();
                        for (Personne enfant : enfants) {
                            coussins.add(enfant);
                        }
                    }
                    else{
                        Vector<Personne> enfants = ((Femme) frereSoeur).obtenirEnfants();
                        for (Personne enfant : enfants) {
                            coussins.add(enfant);
                        } 
                    }
                }
            }
        }
        coussins = removeDuplicates(coussins);
        return coussins;
    }
    //obtenir lien de parente
    public String obtenirLienParente(Personne personne1, Personne personne2) {
        String lienParente;
        
        if (personne1.equals(personne2)) {
            lienParente="Ce sont la même personne.";
            return lienParente;
        }
        
        if (estParentEnfant(personne1, personne2)) {
            lienParente=personne1.getPrenom() + " " + personne1.getNom() + " est parent de " + personne2.getPrenom() + " " + personne2.getNom();
            return lienParente;
        }
        
        if(estEnfantParent( personne1, personne2)){
            lienParente=personne1.getPrenom() + " " + personne1.getNom() + " est enfant de " + personne2.getPrenom() + " " + personne2.getNom();
            return lienParente;
        }
        if (estFrere(personne1, personne2)) {
            lienParente=personne1.getPrenom() + " " + personne1.getNom() + " et " + personne2.getPrenom() + " " + personne2.getNom() + " sont frères.";
            return lienParente;
        }

        if (estSoeur(personne1, personne2)) {
            lienParente=personne1.getPrenom() + " " + personne1.getNom() + " et " + personne2.getPrenom() + " " + personne2.getNom() + " sont soeurs.";
            return lienParente;
        }
        
        if (estGrandParentPetitEnfant(personne1, personne2)) {
            lienParente=personne1.getPrenom() + " " + personne1.getNom() + " est grand-parent de " + personne2.getPrenom() + " " + personne2.getNom();
            return lienParente;
        }

        if(estPetitEnfantGrandParent(personne1, personne2)){
            lienParente=personne1.getPrenom() + " " + personne1.getNom() + " est petit-enfant de " + personne2.getPrenom() + " " + personne2.getNom();
            return lienParente;
        }
        if(estAnsetrs(personne1, personne2)){
            lienParente=personne1.getPrenom() + " " + personne1.getNom() + " est ancêtre de " + personne2.getPrenom() + " " + personne2.getNom();
            return lienParente;
        }
        
        if (estOncleTante(personne1, personne2)) {
            lienParente=personne1.getPrenom() + " " + personne1.getNom() + " est oncle/tante de " + personne2.getPrenom() + " " + personne2.getNom();
            return lienParente;
        }
        
        if(estNeveuNiece(personne1, personne2)){
            lienParente=personne1.getPrenom() + " " + personne1.getNom() + " est neveu/nièce de " + personne2.getPrenom() + " " + personne2.getNom();
            return lienParente;
        }
        
        if (estCousinCousine(personne1, personne2)) {
            lienParente=personne1.getPrenom() + " " + personne1.getNom() + " et " + personne2.getPrenom() + " " + personne2.getNom() + " sont cousins/cousines.";
            return lienParente;
        }
        
        if(estEnfantEloignee(personne1, personne2)){
            lienParente=personne1.getPrenom() + " " + personne1.getNom() + " est enfant éloigné de " + personne2.getPrenom() + " " + personne2.getNom();
            return lienParente;
        }

        if(estAnsetrs(personne1, personne2)){
            lienParente=personne1.getPrenom() + " " + personne1.getNom() + " est ancêtre de " + personne2.getPrenom() + " " + personne2.getNom();
            return lienParente;
        }

        if (estAnsetrsCommun(personne1, personne2)) {
            lienParente="Ancêtre commun trouvé entre " + personne1.getPrenom() + " " + personne1.getNom() + " et " + personne2.getPrenom() + " " + personne2.getNom();
            return lienParente;
        }

        if(estMarie(personne1, personne2)){
            lienParente=personne1.getPrenom() + " " + personne1.getNom() + " est marié(e) à " + personne2.getPrenom() + " " + personne2.getNom();
            return lienParente;
        }

        if(estBeauFrereSoeur(personne1, personne2)){
            lienParente=personne1.getPrenom() + " " + personne1.getNom() + " est beau-frère/belle-soeur de " + personne2.getPrenom() + " " + personne2.getNom();
            return lienParente;
        }

        if(estBrauPereMere(personne1, personne2)){
            lienParente=personne1.getPrenom() + " " + personne1.getNom() + " est beau-père/belle-mère de " + personne2.getPrenom() + " " + personne2.getNom();
            return lienParente;
        }

        if(estEpouseEpouxEnfant(personne1, personne2)){
            lienParente=personne1.getPrenom() + " " + personne1.getNom() + " est époux/épouse de l'enfant de " + personne2.getPrenom() + " " + personne2.getNom();
            return lienParente;
        }

        if(estDeLaFamilleEnfant(personne1,personne2)){
            lienParente = personne2.getPrenom() + " " + personne2.getNom() +"  est de la famille de Conjoint de l'enfant de  "+personne1.getNom()+" "+personne1.getPrenom();
            return lienParente;
        }
 
        if(estDeLaFamilleConjoint(personne1, personne2)){
            lienParente = personne2.getPrenom() + " " + personne2.getNom() + " est de la famille de Conjoint de " + personne1.getPrenom() + " " + personne1.getNom();
            return lienParente;
        }
 
        if(estDeLaFamilleConjoint(personne2, personne1)){
            lienParente=personne1.getPrenom() + " " + personne1.getNom() + " est de la famille de Conjoint de " + personne2.getPrenom() + " " + personne2.getNom();
            return lienParente;
        }

        lienParente="Aucun lien de parenté trouvé entre " + personne1.getPrenom() + " " + personne1.getNom() + " et " + personne2.getPrenom() + " " + personne2.getNom();
        return lienParente;
    }
/*------------------------------------------------------------------------------------------ */
    //methode qui verifie les liens de parente
    public boolean estParentEnfant(Personne parent, Personne enfant) {
        if (parent instanceof Homme) {
            Homme homme = (Homme) parent;
            for (Personne enfantHomme : homme.obtenirEnfants()) {
                if (enfantHomme.equals(enfant)) {
                    return true;
                }
            }
        } else if (parent instanceof Femme) {
            Femme femme = (Femme) parent;
            for (Personne enfantFemme : femme.obtenirEnfants()) {
                if (enfantFemme.equals(enfant)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean estFrereSoeur(Personne personne1, Personne personne2) {
        if (personne1.getPere() != null && personne2.getPere() != null) {
            if (personne1.getPere().equals(personne2.getPere())) {
                return true;
            }
        }
        if (personne1.getMere() != null && personne2.getMere() != null) {
            if (personne1.getMere().equals(personne2.getMere())) {
                return true;
            }
        }
        return false;
    }

    private boolean estFrere(Personne personne1, Personne personne2) {
        if (personne1.getPere() != null) {
            if (personne1.getPere().equals(personne2.getPere())) {
                return true;
            }
        }
        if (personne1.getMere() != null) {
            if (personne1.getMere().equals(personne2.getMere())) {
                return true;
            }
        }
        return false;

    }

    private boolean estSoeur(Personne personne1, Personne personne2) {
        if (personne1.getPere() != null) {
            if (personne1.getPere().equals(personne2.getPere())) {
                return true;
            }
        }
        if (personne1.getMere() != null) {
            if (personne1.getMere().equals(personne2.getMere())) {
                return true;
            }
        }
        return false;
        
    }

    private boolean estGrandParentPetitEnfant(Personne grandParent, Personne petitEnfant) {
        if (grandParent instanceof Homme) {
            Homme homme = (Homme) grandParent;
            for (Personne enfant : homme.obtenirEnfants()) {
                if (estParentEnfant(enfant, petitEnfant)) {
                    return true;
                }
            }
        } else if (grandParent instanceof Femme) {
            Femme femme = (Femme) grandParent;
            for (Personne enfant : femme.obtenirEnfants()) {
                if (estParentEnfant(enfant, petitEnfant)) {
                    return true;
                }
            }
        }
        return false;
    }
      
    private boolean estOncleTante(Personne oncleTante, Personne neveuNièce) {
        if(neveuNièce.getPere() != null){
            if (estFrereSoeur(oncleTante, neveuNièce.getPere())) {
                return true;
            }
        }
        if(neveuNièce.getMere() != null){
            if (estFrereSoeur(oncleTante, neveuNièce.getMere())) {
                return true;
            }
        }
        return false;
    }

    private boolean estNeveuNiece(Personne neveuNiece, Personne oncleTante){
        if (neveuNiece.getMere() != null) {
            if (estFrereSoeur(oncleTante, neveuNiece.getMere())) {
                return true;
            }
        }
        if(neveuNiece.getPere() != null){
            if (estFrereSoeur(oncleTante, neveuNiece.getPere())) {
                return true;
            }
        }
        return false;
    }

    private boolean estOncleTanteNeveuNièce(Personne oncleTante, Personne neveuNièce) {
        if (estOncleTante(oncleTante, neveuNièce) || estNeveuNiece(oncleTante, neveuNièce)) {
            return true;
        }
        return false;
    }

    private boolean estCousinCousine(Personne personne1, Personne personne2) {
        if (personne1.getPere() != null && personne2.getPere() != null) {
            if (estOncleTanteNeveuNièce(personne1.getPere(), personne2) || estOncleTanteNeveuNièce(personne2.getPere(), personne1)) {
                return true;
            }
        }
        if (personne1.getMere() != null && personne2.getMere() != null) {
            if (estOncleTanteNeveuNièce(personne1.getMere(), personne2) || estOncleTanteNeveuNièce(personne2.getMere(), personne1)) {
                return true;
            }
        }
        return false;
    }

    public boolean estAnsetrsCommun(Personne personne1, Personne personne2) {
        Vector<Personne> ancetresPersonne1 = obtenirAncetres(personne1);
        Vector<Personne> ancetresPersonne2 = obtenirAncetres(personne2);
        for (Personne ancetre1 : ancetresPersonne1) {
            if(ancetresPersonne2.contains(ancetre1)){
                return true;
            }
        }
        return false;
    }

    public boolean estAnsetrs(Personne personne1, Personne personne2) {
        Vector<Personne> ancetresPersonne2 = obtenirAncetres(personne2);
        if(ancetresPersonne2.contains(personne1)){
            return true;
        }
        return false;
    }

    private boolean estEnfantEloignee (Personne personne1, Personne personne2) {
        Vector<Personne> ancetresPersonne1 = obtenirAncetres(personne1);
        if(ancetresPersonne1.contains(personne2)){
            return true;
        }
        return false;
    }

    private boolean estEnfantParent(Personne enfant, Personne parent) {
        if (enfant.getPere() != null) {
            if (enfant.getPere().equals(parent)) {
                return true;
            }
        }
        if (enfant.getMere() != null) {
            if (enfant.getMere().equals(parent)) {
                return true;
            }
        }
        return false;
    }

    private boolean estPetitEnfantGrandParent(Personne petitEnfant, Personne grandParent) {
        if (petitEnfant.getPere() != null) {
            if (estParentEnfant(grandParent,petitEnfant.getPere())) {
                return true;
            }
        }
        if (petitEnfant.getMere() != null) {
            if (estParentEnfant( grandParent,petitEnfant.getMere())) {
                return true;
            }
        }
        return false;
    }

    private boolean estMarie(Personne personne1, Personne personne2) {
        if (personne1 instanceof Homme) {
            Homme homme = (Homme) personne1;
            for (Mariage mariage : homme.listMar) {
                if (mariage.getEpouse().equals(personne2)) {
                    return true;
                }
            }
        } else if (personne1 instanceof Femme) {
            Femme femme = (Femme) personne1;
            for (Mariage mariage : femme.listM) {
                if (mariage.getEpoux().equals(personne2)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean estBeauFrereSoeur(Personne personne1, Personne personne2){
        if (personne1 instanceof Homme) {
            Homme homme = (Homme) personne1;
            for (Mariage mariage : homme.listMar) {
                if (estFrereSoeur(mariage.getEpouse(),personne2)) {
                    return true;
                }
            }
        } else if (personne1 instanceof Femme) {
            Femme femme = (Femme) personne1;
            for (Mariage mariage : femme.listM) {
                if (estFrereSoeur(mariage.getEpoux(),personne2)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean estBrauPereMere(Personne personne2, Personne personne1){
        if (personne1 instanceof Homme) {
            Homme homme = (Homme) personne1;
            for (Mariage mariage : homme.listMar) {
                if (estParentEnfant(personne2,mariage.getEpouse())) {
                    return true;
                }
            }
        } else if (personne1 instanceof Femme) {
            Femme femme = (Femme) personne1;
            for (Mariage mariage : femme.listM) {
                if (estParentEnfant(personne2,mariage.getEpoux())) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean estEpouseEpouxEnfant(Personne personne1, Personne personne2){
        if (personne1 instanceof Homme) {
            Homme homme = (Homme) personne1;
            for (Mariage mariage : homme.listMar) {
                if (estParentEnfant(personne2,mariage.getEpouse())) {
                    return true;
                }
            }
        } else if (personne1 instanceof Femme) {
            Femme femme = (Femme) personne1;
            for (Mariage mariage : femme.listM) {
                if (estParentEnfant(personne2,mariage.getEpoux())) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean estDeLaFamilleConjoint(Personne personne1,Personne personne2){
        if (personne1 instanceof Homme) {
            Homme homme = (Homme) personne1;
            for (Mariage mariage : homme.listMar) {
                if (estLienParente(personne2,mariage.getEpouse())) {
                    return true;
                }
            }
        } else if (personne1 instanceof Femme) {
            Femme femme = (Femme) personne1;
            for (Mariage mariage : femme.listM) {
                if (estLienParente(personne2,mariage.getEpoux())) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean estLienParente(Personne personne1, Personne personne2){
        if (personne1.equals(personne2)) {
            return true;
        }
        if (estParentEnfant(personne1, personne2)) {
            return true;
        }
        if(estEnfantParent( personne1, personne2)){
            return true;
        }
        if (estFrere(personne1, personne2)) {
            return true;
        }
        if (estSoeur(personne1, personne2)) {
            return true;
        }
        if (estGrandParentPetitEnfant(personne1, personne2)) {
            return true;
        }
        if(estPetitEnfantGrandParent(personne1, personne2)){
            return true;
        }
        if(estAnsetrs(personne1, personne2)){
            return true;
        }
        if (estOncleTante(personne1, personne2)) {
            return true;
        }
        if(estNeveuNiece(personne1, personne2)){
            return true;
        }
        if (estCousinCousine(personne1, personne2)) {
            return true;
        }
        if(estEnfantEloignee(personne1, personne2)){
            return true;
        }
        if(estAnsetrs(personne1, personne2)){
            return true;
        }
        if (estAnsetrsCommun(personne1, personne2)) {
            return true;
        }
        if(estMarie(personne1, personne2)){
            return true;
        }
        if(estBeauFrereSoeur(personne1, personne2)){
            return true;
        }
        if(estBrauPereMere(personne1, personne2)){
            return true;
        }
        if(estEpouseEpouxEnfant(personne1, personne2)){
            return true;
        }
        if(estDeLaFamilleConjoint(personne1, personne2)){
            return true;
        }
        return false;
    }
    public boolean estDeLaFamilleEnfant(Personne personne1, Personne personne2) {
        if (personne1 instanceof Homme) {
            Homme homme = (Homme) personne1;
            for (Personne enf : homme.obtenirEnfants()) {
                if (enf instanceof Homme) {
                    Homme enfant = (Homme) enf;
                    for (Mariage mariage : enfant.listMar) {
                        if (estLienParente(personne2,mariage.getEpouse())) {
                            return true;
                        }
                    }
                }else{
                    Femme enfant = (Femme) enf;
                    for (Mariage mariage : enfant.listM) {
                        if (estLienParente(personne2,mariage.getEpoux())) {
                            return true;
                        }
                    }
                }
            }
        } else if (personne1 instanceof Femme) {
            Femme femme = (Femme) personne1;
            for (Personne enf : femme.obtenirEnfants()) {
                if (enf instanceof Femme) {
                    Femme enfant = (Femme) enf;
                    for (Mariage mariage : enfant.listM) {
                        if (estLienParente(personne2,mariage.getEpoux())) {
                            return true;
                        }
                    }
                }else{
                    Homme enfant = (Homme) enf;
                    for (Mariage mariage : enfant.listMar) {
                        if (estLienParente(personne2,mariage.getEpouse())) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    } 
}