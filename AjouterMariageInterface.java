package vue;

import javax.swing.*;
import controler.*;
import java.awt.*;
import java.util.*;
import model.*;

public class AjouterMariageInterface extends JFrame {
    Interface1 inter;
    public JLabel aff, affJ, labelConjoint1, labelConjoint2;
    public JComboBox<String> comboBox1, comboBox2, jourM, moisM, anneeM;
    public JButton addButton, reButton;

    public AjouterMariageInterface(Interface1 inter) {
        this.inter = inter;
        setTitle("Interface Ajouter Mariage");
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15); 
        gbc.anchor = GridBagConstraints.WEST;

        aff = new JLabel("<html><div style='color: black; font-family: \"Times New Roman\", sans-serif; font-size: 36pt; font-weight: bold;'>Choisir les informations de l'époux/épouse et de la date de mariage :</div></html>");
        aff.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        this.add(aff, gbc);

        JPanel datePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        affJ = new JLabel("<html><div style='color: black; font-family: \"Times New Roman\", sans-serif; font-size: 24pt;'>Date de Mariage :</div></html>");
        datePanel.add(affJ);
        jourM = new JComboBox<>(getJours());
        jourM.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        moisM = new JComboBox<>(getMois());
        moisM.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        anneeM = new JComboBox<>(getAnnees());
        anneeM.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        datePanel.add(jourM);
        datePanel.add(moisM);
        datePanel.add(anneeM);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        this.add(datePanel, gbc);

        labelConjoint1 = new JLabel("<html><div style='color: black; font-family: \"Times New Roman\", sans-serif; font-size: 24pt;'>Nom de l'époux :</div></html>");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        this.add(labelConjoint1, gbc);

        comboBox1 = new JComboBox<>(getPers(inter.arbre.listPers));
        comboBox1.setFont(new Font("Times New Roman", Font.PLAIN, 20)); 
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        this.add(comboBox1, gbc);

        labelConjoint2 = new JLabel("<html><div style='color: black; font-family: \"Times New Roman\", sans-serif; font-size: 24pt;'>Nom de l'épouse :</div></html>");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        this.add(labelConjoint2, gbc);

        comboBox2 = new JComboBox<>(getPers(inter.arbre.listPers));
        comboBox2.setFont(new Font("Times New Roman", Font.PLAIN, 20)); 
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        this.add(comboBox2, gbc);

        addButton = new JButton("<html><div style='color: black; font-family: \"Times New Roman\", sans-serif; font-size: 24pt; font-weight: bold;'>Ajouter Mariage</div></html>");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        this.add(addButton, gbc);
        AjouterMariageBot ajouterMariage = new AjouterMariageBot(inter, this);
        addButton.addActionListener(ajouterMariage);

        reButton = new JButton("<html><div style='color: black; font-family: \"Times New Roman\", sans-serif; font-size: 24pt; font-weight: bold;'>Retour</div></html>");
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        this.add(reButton, gbc);
        ReteurnBotAjouterMariage returnBot = new ReteurnBotAjouterMariage(this);
        reButton.addActionListener(returnBot);

        this.setSize(1600, 850);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public String[] getPers(Vector<Personne> listP) {
        int i = 0;
        String[] list = new String[listP.size()];
        for (Personne personne : listP) {
            list[i] = "Nom: " + personne.getNom() + ", Prénom: " + personne.getPrenom() + ", Date de Naissance: " + personne.getDateNaissance() + ", Genre: " + (personne instanceof Homme ? "Homme" : "Femme") + (personne.getDateMort() != null ? ", Date de Mort: " + personne.getDateMort() : ", La personne est vivante.") + "\n";
            i++;
        }
        return list;
    }

    private String[] getJours() {
        String[] jours = new String[31];
        for (int i = 1; i <= 31; i++) {
            jours[i - 1] = String.valueOf(i);
        }
        return jours;
    }

    private String[] getMois() {
        return new String[]{"Janvier", "Février", "Mars", "Avril", "Mai", "Juin", "Juillet", "Août", "Septembre", "Octobre", "Novembre", "Décembre"};
    }

    private String[] getAnnees() {
        String[] annees = new String[100];
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = 0; i < 100; i++) {
            annees[i] = String.valueOf(currentYear - i);
        }
        return annees;
    }
}
