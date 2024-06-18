package vue;

import javax.swing.*;
import controler.*;
import model.ArbreGenealogique;
import java.awt.*;

public class Interface3 extends JFrame {
    JLabel aff;
    JButton femmeB = new JButton("Ajouter Femme");
    JButton hommeB = new JButton("Ajouter Homme");
    JButton enfantB = new JButton("Ajouter Enfant");
    JButton mariageB = new JButton("Ajouter Mariage");
    JButton retourB = new JButton("Retour");
    Interface1 inter;

    public Interface3(Interface1 i) {
        inter = i;
        this.setTitle("Ajouter des Éléments à l'Arbre");
        
        aff = new JLabel("<html><div style='text-align: center; font-family: \"Times New Roman\", Times, serif; font-size: 34pt;'>Bienvenue dans l'interface 3,<br>Vous ajoutez des éléments dans votre arbre</div></html>");
        aff.setHorizontalAlignment(SwingConstants.CENTER);
        
        JPanel boutonPanel = new JPanel();
        boutonPanel.setLayout(new FlowLayout());
        
        boutonPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        
        boutonPanel.add(femmeB); 
        boutonPanel.add(hommeB);
        boutonPanel.add(enfantB);
        boutonPanel.add(mariageB);
        boutonPanel.add(retourB);

        femmeB.setPreferredSize(new Dimension(250, 100));
        femmeB.setFont(new Font("Times New Roman", Font.PLAIN, 27));
        hommeB.setPreferredSize(new Dimension(250, 100));
        hommeB.setFont(new Font("Times New Roman", Font.PLAIN, 27));
        enfantB.setPreferredSize(new Dimension(250, 100));
        enfantB.setFont(new Font("Times New Roman", Font.PLAIN, 27));
        mariageB.setPreferredSize(new Dimension(250, 100));
        mariageB.setFont(new Font("Times New Roman", Font.PLAIN, 27));
        retourB.setPreferredSize(new Dimension(250, 100)); 
        retourB.setFont(new Font("Times New Roman", Font.PLAIN, 27)); 

        getContentPane().setLayout(new GridLayout(3, 1));
        getContentPane().add(aff);
        getContentPane().add(boutonPanel);

        hommeB.addActionListener(new ContrIntrface3Homme(inter));
        femmeB.addActionListener(new ContrIntrface3Femme(inter));
        enfantB.addActionListener(new ContrIntrface3AjouterEnfant(inter));
        mariageB.addActionListener(new ContrInterface3AjouterMariage(inter));
        ReteurnBotInterface3 intR = new ReteurnBotInterface3(this);
        retourB.addActionListener(intR);

        this.setSize(1200, 750);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
