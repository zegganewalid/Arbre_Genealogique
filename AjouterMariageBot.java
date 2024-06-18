package controler;

import controler.*;
import vue.*;
import model.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.ZoneId;
import javax.swing.*;
import java.util.*;

public class AjouterMariageBot implements ActionListener {
    Interface1 inter;
    AjouterMariageInterface Interface;

    public AjouterMariageBot(Interface1 i, AjouterMariageInterface j) {
        inter = i;
        Interface = j;
    }

    public void actionPerformed(ActionEvent e) {
        String selectedPerson1 = (String) Interface.comboBox1.getSelectedItem();
        String selectedPerson2 = (String) Interface.comboBox2.getSelectedItem();

        if (selectedPerson1.equals(selectedPerson2)) {
            Interface.aff.setForeground(Color.RED); 
            Interface.aff.setFont(new Font("Arial", Font.PLAIN, 36)); 
            Interface.aff.setText("Erreur : Vous ne pouvez pas choisir la même personne pour les deux champs.");
        } else {
            Personne temp1 = inter.arbre.RecherchePersArbre(Interface.comboBox1.getSelectedItem().toString(),inter.arbre);
            Personne temp2 = inter.arbre.RecherchePersArbre(Interface.comboBox2.getSelectedItem().toString(),inter.arbre);
            if (temp1 != null && temp2 != null) {
                if (temp1 instanceof Homme && temp2 instanceof Homme) {
                    Interface.aff.setForeground(Color.RED); 
                    Interface.aff.setFont(new Font("Arial", Font.PLAIN, 36));
                    Interface.aff.setText("Erreur : Type des personnes");
                } else if (temp1 instanceof Femme && temp2 instanceof Femme) {
                    Interface.aff.setForeground(Color.RED);
                    Interface.aff.setFont(new Font("Arial", Font.PLAIN, 36)); 
                    Interface.aff.setText("Erreur : Type des personnes");
                } else {
                    Homme homme = (Homme) temp1;
                    Femme femme = (Femme) temp2;
                    LocalDate dateNaissanceTemp1 = dateToLocalDate(temp1.getDateNaissance());
                    LocalDate dateNaissanceTemp2 = dateToLocalDate(temp2.getDateNaissance());
                    LocalDate dateMortTemp1 = dateToLocalDate(temp1.getDateMort());
                    LocalDate dateMortTemp2 = dateToLocalDate(temp2.getDateMort());

                    int jour = Integer.parseInt(Interface.jourM.getSelectedItem().toString());
                    int mois = Interface.moisM.getSelectedIndex() + 1; // Les indices commencent à partir de zéro
                    int annee = Integer.parseInt(Interface.anneeM.getSelectedItem().toString());
                    LocalDate dateMariageTemp = LocalDate.of(annee, mois, jour);
                    Date dateMariage = Date.from(dateMariageTemp.atStartOfDay(ZoneId.systemDefault()).toInstant());

                    //check la date si il y a des cas qui sont pas logique
                    if (dateMariageTemp.isBefore(dateNaissanceTemp1)||dateMariageTemp.isBefore(dateNaissanceTemp2)) {
                        Interface.aff.setText("<html><div style='color: red; font-family: \"Arial\", sans-serif; font-size: 36pt;'>Erreur : l'époux/épouse ne peut pas être né apres la date de mariage.</div></html>");
                    } else if (dateMortTemp1 != null && dateMortTemp1.isBefore(dateMariageTemp)||dateMortTemp2 != null && dateMortTemp2.isBefore(dateMariageTemp)) {
                        Interface.aff.setText("<html><div style='color: red; font-family: \"Arial\", sans-serif; font-size: 36pt;'>Erreur : l'époux/épouse ne peut pas être mort avant la date de mariage.</div></html>");
                    } else if(inter.arbre.estFrereSoeur(temp1,temp2)){
                        Interface.aff.setText("<html><div style='color: red; font-family: \"Arial\", sans-serif; font-size: 36pt;'>Erreur : l'époux/épouse ne peut pas être frère/soeur.</div></html>");
                    }else if(inter.arbre.estParentEnfant(temp1,temp2)||inter.arbre.estParentEnfant(temp2,temp1)){
                        Interface.aff.setText("<html><div style='color: red; font-family: \"Arial\", sans-serif; font-size: 36pt;'>Erreur : l'époux/épouse ne peut pas être parent/enfant.</div></html>");
                    }else if (inter.arbre.estAnsetrs(temp1,temp2)||inter.arbre.estAnsetrs(temp2,temp1)){
                        Interface.aff.setText("<html><div style='color: red; font-family: \"Arial\", sans-serif; font-size: 36pt;'>Erreur : l'époux/épouse ne peut pas être ancêtre/descendant.</div></html>");
                    }else if(inter.arbre.estAnsetrsCommun(temp1,temp2)||inter.arbre.estAnsetrsCommun(temp2,temp1)){
                        Interface.aff.setText("<html><div style='color: red; font-family: \"Arial\", sans-serif; font-size: 36pt;'>Erreur : l'époux/épouse ne peut pas être ancêtre commun.</div></html>");
                    }
                    else {
                        Mariage mar = new Mariage(homme, femme, dateMariage);
                        homme.ajouterMariage(mar);
                        femme.ajouterMariage(mar);
                        Interface.aff.setForeground(Color.GREEN); 
                        Interface.aff.setFont(new Font("Arial", Font.PLAIN, 36)); 
                        Interface.aff.setText("Mariage ajouté");
                    }
                }
            } else {
                Interface.aff.setForeground(Color.RED); 
                Interface.aff.setFont(new Font("Arial", Font.PLAIN, 36)); 
                Interface.aff.setText("Erreur : Vous devez choisir deux personnes.");
            }
        }
    }
    public LocalDate dateToLocalDate(Date date) {
        if (date == null) {
            return null;
        }
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }
}