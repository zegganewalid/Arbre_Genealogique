package vue;
import javax.swing.*;
import controler.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import model.*;

public class HommeInterface extends JFrame {
    public JLabel aff;
    public JLabel affNom, affPrenom, affDateNaissance, affDateMort, affMere, affPere;
    public JTextField txtNom, txtPrenom, txtMere, txtPere;
    public JComboBox<String> jourNaissance, moisNaissance, anneeNaissance, jourMort, moisMort, anneeMort;
    public JCheckBox chkDateMort;
    public JButton btnAjouter, btnRetour;
    Interface1 inter;

    public HommeInterface(Interface1 i) {
        inter = i;
        this.setTitle("Formulaire de création d'un Homme");
        this.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15);
        gbc.anchor = GridBagConstraints.WEST; 

        aff = new JLabel("Saisissez les informations de l'Homme :");
        aff.setFont(new Font("Arial", Font.PLAIN, 36));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 6; 
        this.add(aff, gbc);

        // Nom
        affNom = new JLabel("Nom :");
        affNom.setFont(new Font("Arial", Font.PLAIN, 24)); 
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2; 
        this.add(affNom, gbc);

        txtNom = new JTextField(24); 
        txtNom.setFont(new Font("Arial", Font.PLAIN, 24)); 
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.gridwidth = 4; 
        this.add(txtNom, gbc);

        // Prénom
        affPrenom = new JLabel("Prénom :");
        affPrenom.setFont(new Font("Arial", Font.PLAIN, 24)); 
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2; 
        this.add(affPrenom, gbc);

        txtPrenom = new JTextField(24); 
        txtPrenom.setFont(new Font("Arial", Font.PLAIN, 24)); 
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.gridwidth = 4; 
        this.add(txtPrenom, gbc);

        // Date de naissance
        affDateNaissance = new JLabel("Date de naissance :");
        affDateNaissance.setFont(new Font("Arial", Font.PLAIN, 24)); 
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2; 
        this.add(affDateNaissance, gbc);

        jourNaissance = new JComboBox<>(getJours());
        jourNaissance.setFont(new Font("Arial", Font.PLAIN, 24)); 
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        this.add(jourNaissance, gbc);

        moisNaissance = new JComboBox<>(getMois());
        moisNaissance.setFont(new Font("Arial", Font.PLAIN, 24)); 
        gbc.gridx = 3;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        this.add(moisNaissance, gbc);

        anneeNaissance = new JComboBox<>(getAnnees());
        anneeNaissance.setFont(new Font("Arial", Font.PLAIN, 24)); 
        gbc.gridx = 5;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        this.add(anneeNaissance, gbc);

        // Date de mort
        jourMort = new JComboBox<>(getJours());
        jourMort.setFont(new Font("Arial", Font.PLAIN, 24)); 
        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        this.add(jourMort, gbc);

        moisMort = new JComboBox<>(getMois());
        moisMort.setFont(new Font("Arial", Font.PLAIN, 24)); 
        gbc.gridx = 3;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        this.add(moisMort, gbc);

        anneeMort = new JComboBox<>(getAnnees());
        anneeMort.setFont(new Font("Arial", Font.PLAIN, 24)); 
        gbc.gridx = 5;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        this.add(anneeMort, gbc);

        // Date de mort
        chkDateMort = new JCheckBox("Date de mort :");
        chkDateMort.setFont(new Font("Arial", Font.PLAIN, 24)); 
        chkDateMort.setSelected(true);
        DateMortItemListenerHomme dateMortListener = new DateMortItemListenerHomme(jourMort, moisMort, anneeMort, chkDateMort);
        chkDateMort.addItemListener(dateMortListener);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2; 
        this.add(chkDateMort, gbc);

        // Boutons
        btnAjouter = new JButton("Ajouter");
        btnAjouter.setFont(new Font("Arial", Font.PLAIN, 24)); 
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 3; 
        this.add(btnAjouter, gbc);

        AjouterHommeBot ajouterHommeBot = new AjouterHommeBot(inter,this);
        btnAjouter.addActionListener(ajouterHommeBot);

        btnRetour = new JButton("Retour");
        btnRetour.setFont(new Font("Arial", Font.PLAIN, 24));
        gbc.gridx = 3;
        gbc.gridy = 5;
        gbc.gridwidth = 3; 
        this.add(btnRetour, gbc);

        ReteurnBotHommeInterface returnBotHommeInterface = new ReteurnBotHommeInterface(this);
        btnRetour.addActionListener(returnBotHommeInterface);

        this.setSize(1200, 600); 
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
