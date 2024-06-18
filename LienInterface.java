package vue;

import javax.swing.*;
import controler.*;
import model.*;
import java.awt.*;
import java.util.*;

public class LienInterface extends JFrame{
    Interface1 inter;
    JLabel aff;
    JComboBox<String> comboBox1;
    JComboBox<String> comboBox2;
    JButton aButton;
    JButton reButton;
    public LienInterface(Interface1 in) {
        inter = in;
        this.setTitle("Afficher Lien entre deux Personnes");
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15); 
        gbc.anchor = GridBagConstraints.WEST; 

        aff = new JLabel("<html><div style='color: black; font-family: \"Times New Roman\", sans-serif; font-size: 36pt; font-weight: bold;'>Bienvenue dans l'interface de Lien de Parente,<br>Vous pouvez afficher le Lien de Parente des deux personnes choisies</div></html>");
        aff.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        this.add(aff, gbc);

        comboBox1 = new JComboBox<>(inter.arbre.getPers(inter.arbre.listPers));
        comboBox1.setFont(new Font("Times New Roman", Font.PLAIN, 20)); 
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        this.add(comboBox1, gbc);
        
        comboBox2 = new JComboBox<>(inter.arbre.getPers(inter.arbre.listPers)); 
        comboBox2.setFont(new Font("Times New Roman", Font.PLAIN, 20)); 
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        this.add(comboBox2, gbc);

        aButton = new JButton("<html><div style='color: black; font-family: \"Times New Roman\", sans-serif; font-size: 24pt; font-weight: bold;'>Afficher</div></html>");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        this.add(aButton, gbc);
        AfficherBotLien br = new AfficherBotLien(inter, this);
        aButton.addActionListener(br);

        reButton = new JButton("<html><div style='color: black; font-family: \"Times New Roman\", sans-serif; font-size: 24pt; font-weight: bold;'>Retour</div></html>");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        this.add(reButton, gbc);
        RetourBotLien retourbot = new RetourBotLien(this);
        reButton.addActionListener(retourbot);

        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}