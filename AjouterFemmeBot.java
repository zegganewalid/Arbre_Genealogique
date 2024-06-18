package controler;

import controler.ContrInterface1;
import vue.FemmeInterface;
import vue.Interface1;
import model.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.ZoneId;

import javax.swing.*;
import java.util.*;

public class AjouterFemmeBot implements ActionListener { 
    Interface1 inter;
    FemmeInterface femmeInterface;

    public AjouterFemmeBot(Interface1 i, FemmeInterface f) {
        inter = i;
        femmeInterface = f;
    }

    public void actionPerformed(ActionEvent e) {
        String nom = femmeInterface.txtNom.getText();
        String prenom = femmeInterface.txtPrenom.getText();
        Femme femme;
        Date dateMort = null;

        if (nom.equals("") || prenom.equals("")) {
            // Affichage du message d'erreur en rouge
            femmeInterface.aff.setText("<html><div style='color: red; font-family: \"Times New Roman\", Times, serif; font-size: 36pt; font-weight: bold;'>Erreur : Les champs ne peuvent pas être vides !</div></html>");
        } else {
            int jour = Integer.parseInt(femmeInterface.jourNaissance.getSelectedItem().toString());
            int mois = femmeInterface.moisNaissance.getSelectedIndex() + 1;
            int annee = Integer.parseInt(femmeInterface.anneeNaissance.getSelectedItem().toString());
            LocalDate dateNaissanceDate = LocalDate.of(annee, mois, jour);
            Date dateNaissance = Date.from(dateNaissanceDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
            

            if (femmeInterface.chkDateMort.isSelected()) {
                int jourM = Integer.parseInt(femmeInterface.jourMort.getSelectedItem().toString());
                int moisM = femmeInterface.moisMort.getSelectedIndex() + 1;
                int anneeM = Integer.parseInt(femmeInterface.anneeMort.getSelectedItem().toString());
                LocalDate dateMortDate = LocalDate.of(anneeM, moisM, jourM);
                dateMort  = Date.from(dateMortDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
                femme = new Femme(nom, prenom, dateNaissance, dateMort, inter.arbre);
            }else{femme = new Femme(nom, prenom, dateNaissance,inter.arbre);}

            // Vérifier si la femme existe déjà dans l'arbre
            for (Personne personne : inter.arbre.listPers) {
                if (personne.getNom().equals(nom) && personne.getPrenom().equals(prenom) && personne.getDateNaissance().equals(dateNaissance)) {
                    if (dateMort == null) {
                        if (personne.getDateMort() == null) {
                            femmeInterface.aff.setText("<html><div style='color: red; font-family: \"Times New Roman\", Times, serif; font-size: 36pt; font-weight: bold;'>Erreur : Cette femme existe déjà dans l'arbre !</div></html>");
                            return;
                        }
                    } else {
                        if (personne.getDateMort() != null && personne.getDateMort().equals(dateMort)) {
                            femmeInterface.aff.setText("<html><div style='color: red; font-family: \"Times New Roman\", Times, serif; font-size: 36pt; font-weight: bold;'>Erreur : Cette femme existe déjà dans l'arbre !</div></html>");
                            return;
                        }
                    }
                }
                
            }

            // Ajouter la femme à l'arbre et afficher le message de confirmation en vert
            inter.arbre.listPers.add(femme);
            femmeInterface.aff.setText("<html><div style='color: green; font-family: \"Times New Roman\", Times, serif; font-size: 36pt; font-weight: bold;'>Femme " + nom + " créée !</div></html>");
        }
    }
}