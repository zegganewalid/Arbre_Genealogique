package controler;
import vue.*;
import model.*;
import java.awt.event.*;
import java.time.*;
import java.util.Date;
import javax.swing.*;

public class AjouterEnfantBot implements ActionListener {
    Interface1 inter;
    AjouterEnfantInterface Interface;

    public AjouterEnfantBot(Interface1 i, AjouterEnfantInterface h) {
        inter = i;
        Interface = h;
    }
    public void actionPerformed(ActionEvent e) {
        String selectedPerson1 = (String) Interface.comboBox1.getSelectedItem();
        String selectedPerson2 = (String) Interface.comboBox2.getSelectedItem();
        if (selectedPerson1.equals(selectedPerson2)) {
            Interface.aff.setText("<html><div style='color: red; font-family: \"Times New Roman\", sans-serif; font-size: 36pt;'>Erreur : Vous ne pouvez pas choisir la même personne pour les deux champs.</div></html>");
            return;
        }
        Personne temp1 = inter.arbre.RecherchePersArbre(selectedPerson1, inter.arbre);
        Personne temp2 = inter.arbre.RecherchePersArbre(selectedPerson2, inter.arbre);
        if (temp1 == null || temp2 == null) {
            Interface.aff.setText("<html><div style='color: red; font-family: \"Times New Roman\", sans-serif; font-size: 36pt;'>Erreur : Une des personnes sélectionnées n'a pas été trouvée.</div></html>");
            return;
        }
        LocalDate dateNaissanceTemp1 = dateToLocalDate(temp1.getDateNaissance());
        LocalDate dateNaissanceTemp2 = dateToLocalDate(temp2.getDateNaissance());
        if (dateNaissanceTemp1 == null || dateNaissanceTemp2 == null) {
            Interface.aff.setText("<html><div style='color: red; font-family: \"Times New Roman\", sans-serif; font-size: 36pt;'>Erreur : La date de naissance de l'une des personnes est invalide.</div></html>");
            return;
        }
        LocalDate dateMortParent = dateToLocalDate(temp1.getDateMort());
        if (dateNaissanceTemp2.isBefore(dateNaissanceTemp1)) {
            Interface.aff.setText("<html><div style='color: red; font-family: \"Times New Roman\", sans-serif; font-size: 36pt;'>Erreur : L'enfant ne peut pas être né avant son parent.</div></html>");
            return;
        }
        if (dateMortParent != null) {
            if (temp1 instanceof Femme) {
                if (dateNaissanceTemp2.isAfter(dateMortParent)) {
                    Interface.aff.setText("<html><div style='color: red; font-family: \"Times New Roman\", sans-serif; font-size: 36pt;'>Erreur : L'enfant ne peut pas être né après la mort de sa mère.</div></html>");
                    return;
                }
            } else {
                LocalDate dateApresNeufMoisMortPere = dateMortParent.plusMonths(9);
                if (dateNaissanceTemp2.isAfter(dateApresNeufMoisMortPere)) {
                    Interface.aff.setText("<html><div style='color: red; font-family: \"Times New Roman\", sans-serif; font-size: 36pt;'>Erreur : L'enfant ne peut pas être né plus de 9 mois après la date de mort de son père.</div></html>");
                    return;
                }
            }
        }
        if (temp1 instanceof Homme) {
            if (temp2.getPere() != null) {
                Interface.aff.setText("<html><div style='color: red; font-family: \"Times New Roman\", sans-serif; font-size: 36pt;'>Erreur : " + temp2.getPrenom() + " a déjà un père.</div></html>");
            } else if (temp2.getPere() == temp1) {
                Interface.aff.setText("<html><div style='color: red; font-family: \"Times New Roman\", sans-serif; font-size: 36pt;'>Erreur : " + temp2.getPrenom() + " est déjà père de " + temp1.getPrenom() + "</div></html>");
            } else {
                ((Homme) temp1).ajouterEnfant(temp2);
                Interface.aff.setText("<html><div style='color: green; font-family: \"Times New Roman\", sans-serif; font-size: 36pt;'>L'enfant est bien enregistré.</div></html>");
            }
        } else if (temp1 instanceof Femme) {
            if (temp2.getMere() != null) {
                Interface.aff.setText("<html><div style='color: red; font-family: \"Times New Roman\", sans-serif; font-size: 36pt;'>Erreur : " + temp2.getPrenom() + " a déjà une mère.</div></html>");
            } else if (temp2.getMere() == temp1) {
                Interface.aff.setText("<html><div style='color: red; font-family: \"Times New Roman\", sans-serif; font-size: 36pt;'>Erreur : " + temp2.getPrenom() + " est déjà mère de " + temp1.getPrenom() + "</div></html>");
            } else {
                ((Femme) temp1).ajouterEnfant(temp2);
                Interface.aff.setText("<html><div style='color: green; font-family: \"Times New Roman\", sans-serif; font-size: 36pt;'>L'enfant est bien enregistré.</div></html>");
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