package vue;

import javax.swing.*;
import controler.*;
import model.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.*;

public class CousinsInterface extends JFrame{
    Interface1 inter;
    JLabel aff;
    JComboBox<String> comboBox1;
    JButton aButton;
    JButton reButton;
    public CousinsInterface(Interface1 i){
        inter = i;
        this.setTitle("Afficher Les Cousins");
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15); 
        gbc.anchor = GridBagConstraints.WEST; 

        aff = new JLabel("<html><div style='color: black; font-family: \"Times New Roman\", sans-serif; font-size: 36pt; font-weight: bold;'>Bienvenue dans l'interface des Cousins ,<br>Vous pouvez afficher Les Cousins de la personne choisie</div></html>");
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

        aButton = new JButton("<html><div style='color: black; font-family: \"Times New Roman\", sans-serif; font-size: 24pt; font-weight: bold;'>Afficher</div></html>");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        this.add(aButton, gbc);
        AfficherBotCousins2 brbrbrbr = new AfficherBotCousins2(inter, this);
        aButton.addActionListener(brbrbrbr);

        reButton = new JButton("<html><div style='color: black; font-family: \"Times New Roman\", sans-serif; font-size: 24pt; font-weight: bold;'>Retour</div></html>");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        this.add(reButton, gbc);
        RetourBotCousins retourbot = new RetourBotCousins(this);
        reButton.addActionListener(retourbot);

        //this.setSize(1500, 1000);
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}