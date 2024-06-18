package controler;

import controler.*;
import vue.HommeInterface;
import vue.Interface1;
import model.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.ZoneId;

import javax.swing.*;
import java.util.*;

public class AjouterHommeBot implements ActionListener { 
    Interface1 inter;
    HommeInterface hommeInterface;

    public AjouterHommeBot(Interface1 i, HommeInterface h) {
        inter = i;
        hommeInterface = h;
    }

    public void actionPerformed(ActionEvent e) { 
        String nom = hommeInterface.txtNom.getText();
        String prenom = hommeInterface.txtPrenom.getText();
        Homme homme;
        Date dateMort = null;

        if (nom.equals("") || prenom.equals("")) {
            hommeInterface.aff.setText("<html><div style='color: red; font-family: \"Times New Roman\", Times, serif; font-size: 36pt; font-weight: bold;'>Erreur : Les champs ne peuvent pas être vides !</div></html>");
        } else {
            int jour = Integer.parseInt(hommeInterface.jourNaissance.getSelectedItem().toString());
            int mois = hommeInterface.moisNaissance.getSelectedIndex() + 1;
            int annee = Integer.parseInt(hommeInterface.anneeNaissance.getSelectedItem().toString());
            LocalDate dateNaissanceDate = LocalDate.of(annee, mois, jour);
            Date dateNaissance = Date.from(dateNaissanceDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
            
            if (hommeInterface.chkDateMort.isSelected()) {
                int jourM = Integer.parseInt(hommeInterface.jourMort.getSelectedItem().toString());
                int moisM = hommeInterface.moisMort.getSelectedIndex() + 1;
                int anneeM = Integer.parseInt(hommeInterface.anneeMort.getSelectedItem().toString());
                LocalDate dateMortDate = LocalDate.of(anneeM, moisM, jourM);
                dateMort  = Date.from(dateMortDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
                homme = new Homme(nom, prenom, dateNaissance, dateMort, inter.arbre);
            }else{homme = new Homme(nom, prenom, dateNaissance,inter.arbre);}

            for (Personne personne : inter.arbre.listPers) {
                if (personne.getNom().equals(nom) && personne.getPrenom().equals(prenom) && personne.getDateNaissance().equals(dateNaissance)) {
                    if (dateMort == null) {
                        if (personne.getDateMort() == null) {
                            hommeInterface.aff.setText("<html><div style='color: red; font-family: \"Times New Roman\", Times, serif; font-size: 36pt; font-weight: bold;'>Erreur : Ce homme existe déjà dans l'arbre !</div></html>");
                            return;
                        }
                    } else {
                        if (personne.getDateMort() != null && personne.getDateMort().equals(dateMort)) {
                            hommeInterface.aff.setText("<html><div style='color: red; font-family: \"Times New Roman\", Times, serif; font-size: 36pt; font-weight: bold;'>Erreur : Ce homme existe déjà dans l'arbre !</div></html>");
                            return;
                        }
                    }
                }
                
            }

            inter.arbre.listPers.add(homme);
            hommeInterface.aff.setText("<html><div style='color: green; font-family: \"Times New Roman\", Times, serif; font-size: 36pt; font-weight: bold;'>Homme " + nom + " créé !</div></html>");
        }
    }
}
