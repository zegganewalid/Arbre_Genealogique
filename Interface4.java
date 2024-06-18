package vue;

import javax.swing.*;
import controler.*;
import model.*;
import java.awt.*;

public class Interface4 extends JFrame {
    private InterfaceAffArbre interfaceNext;
    Interface1 inter;
    JLabel aff;
    JButton arbreB = new JButton("Arbre");
    JButton ancetresB = new JButton("Ancêtres");
    JButton frereSoeursB = new JButton("Frères Et Sœurs");
    JButton cousinsB = new JButton("Les Cousins");
    JButton lienPB = new JButton("Liens de Parenté");
    JButton retourB = new JButton("Retour");

    public Interface4(Interface1 i) {
        inter = i;
        this.setTitle("Afficher des Éléments");
        
        aff = new JLabel("<html><div style='text-align: center; font-family: \"Times New Roman\", Times, serif; font-size: 34pt;'>Bienvenue dans l'interface 4,<br>Vous affichez votre arbre avec fonctionnalités</div></html>");
        aff.setHorizontalAlignment(SwingConstants.CENTER);
        

        JPanel boutonPanel = new JPanel();
        boutonPanel.setLayout(new FlowLayout());
        
        boutonPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        
        boutonPanel.add(arbreB); 
        boutonPanel.add(ancetresB);
        boutonPanel.add(frereSoeursB);
        boutonPanel.add(cousinsB);
        boutonPanel.add(lienPB);
        boutonPanel.add(retourB);

        arbreB.setPreferredSize(new Dimension(250, 100));
        arbreB.setFont(new Font("Times New Roman", Font.PLAIN, 27));
        ancetresB.setPreferredSize(new Dimension(250, 100));
        ancetresB.setFont(new Font("Times New Roman", Font.PLAIN, 27));
        frereSoeursB.setPreferredSize(new Dimension(250, 100));
        frereSoeursB.setFont(new Font("Times New Roman", Font.PLAIN, 27));
        cousinsB.setPreferredSize(new Dimension(250, 100));
        cousinsB.setFont(new Font("Times New Roman", Font.PLAIN, 27));
        lienPB.setPreferredSize(new Dimension(250, 100));
        lienPB.setFont(new Font("Times New Roman", Font.PLAIN, 27));
        retourB.setPreferredSize(new Dimension(250, 100));
        retourB.setFont(new Font("Times New Roman", Font.PLAIN, 27));

        getContentPane().setLayout(new GridLayout(3, 1));
        getContentPane().add(aff);
        getContentPane().add(boutonPanel);

        arbreB.addActionListener(new BotAffArbre(inter));
        ancetresB.addActionListener(new ContrInterface4Ancetres(inter));

        ReteurnBotInterface4 kk = new ReteurnBotInterface4(this);
        retourB.addActionListener(kk);

        ContrlInterface4frereSoeurs dd = new ContrlInterface4frereSoeurs(inter);
        frereSoeursB.addActionListener(dd);

        ContrlInterface4Cousin jj = new ContrlInterface4Cousin(inter);
        cousinsB.addActionListener(jj);

        ContrlInterface4Lien ll = new ContrlInterface4Lien(inter);
        lienPB.addActionListener(ll);

        this.setSize(1400, 800);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
