package vue;

import javax.swing.*;
import java.awt.*;
import controler.ContrIntrface2Gestion;
import controler.ContrIntrface2aff;
import model.ArbreGenealogique;

public class Interface2 extends JFrame {
    private Interface3 interface3;
    private Interface4 interface4;
    JLabel aff;
    JButton gestionArbreButton = new JButton("Gestion de l'Arbre");
    JButton affichageArbreButton = new JButton("Affichage de l'Arbre");
    Interface1 inter;

    public Interface2(Interface1 i) {
        inter = i;
        this.setTitle("Manipuler L'arbre");
        
        aff = new JLabel("<html><div style='text-align: center; font-family: \"Times New Roman\", Times, serif; font-size: 34pt;'>Bienvenue dans l'interface 2, Merci de choisir l'une des fonctions :<br>Gestion de l'Arbre ou Affichage de l'Arbre</div></html>");
        aff.setHorizontalAlignment(SwingConstants.CENTER);
        
        JPanel boutonPanel = new JPanel();
        boutonPanel.setLayout(new FlowLayout()); 

        boutonPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));

        boutonPanel.add(gestionArbreButton); 
        boutonPanel.add(affichageArbreButton);

        gestionArbreButton.setPreferredSize(new Dimension(350, 100));
        gestionArbreButton.setFont(new Font("Times New Roman", Font.PLAIN, 27));
        affichageArbreButton.setPreferredSize(new Dimension(350, 100));
        affichageArbreButton.setFont(new Font("Times New Roman", Font.PLAIN, 27));

        getContentPane().setLayout(new GridLayout(3, 1));
        getContentPane().add(aff);
        getContentPane().add(boutonPanel);

        gestionArbreButton.addActionListener(new ContrIntrface2Gestion(inter));
        affichageArbreButton.addActionListener(new ContrIntrface2aff(inter));

        this.setSize(1200, 600);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
