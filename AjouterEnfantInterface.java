package vue;

import javax.swing.*;
import controler.*;
import java.awt.*;
import java.util.*;
import model.*;

public class AjouterEnfantInterface extends JFrame {
    Interface1 inter;
    public JLabel aff;
    public JLabel labelChamps1, labelChamps2;
    public JComboBox<String> comboBox1;
    public JComboBox<String> comboBox2;
    public JButton addButton;
    public JButton reButton;

    public AjouterEnfantInterface(Interface1 inter) {
        this.inter = inter;
        setTitle("Interface Ajouter Enfants");
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15); 
        gbc.anchor = GridBagConstraints.WEST; 

        aff = new JLabel("<html><div style='color: black; font-family: \"Times New Roman\", sans-serif; font-size: 36pt; font-weight: bold;'>Choisir les informations du père/mère et de l'enfant :</div></html>");
        aff.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        this.add(aff, gbc);

        labelChamps1 = new JLabel("<html><div style='color: black; font-family: \"Times New Roman\", sans-serif; font-size: 24pt;'>Père/Mère :</div></html>");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        this.add(labelChamps1, gbc);

        comboBox1 = new JComboBox<>(inter.arbre.getPers(inter.arbre.listPers));
        comboBox1.setFont(new Font("Times New Roman", Font.PLAIN, 20)); 
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        this.add(comboBox1, gbc);

        labelChamps2 = new JLabel("<html><div style='color: black; font-family: \"Times New Roman\", sans-serif; font-size: 24pt;'>Enfant :</div></html>");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        this.add(labelChamps2, gbc);

        comboBox2 = new JComboBox<>(inter.arbre.getPers(inter.arbre.listPers));
        comboBox2.setFont(new Font("Times New Roman", Font.PLAIN, 20)); 
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        this.add(comboBox2, gbc);

        addButton = new JButton("<html><div style='color: black; font-family: \"Times New Roman\", sans-serif; font-size: 24pt; font-weight: bold;'>Ajouter Enfant</div></html>");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        this.add(addButton, gbc);
        AjouterEnfantBot ajouterEnfant = new AjouterEnfantBot(inter, this);
        addButton.addActionListener(ajouterEnfant);

        reButton = new JButton("<html><div style='color: black; font-family: \"Times New Roman\", sans-serif; font-size: 24pt; font-weight: bold;'>Retour</div></html>");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        this.add(reButton, gbc);
        ReteurnBotAjouterEnfant returnbot = new ReteurnBotAjouterEnfant(this);
        reButton.addActionListener(returnbot);

        this.setSize(1500, 650);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}