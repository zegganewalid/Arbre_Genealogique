package vue;
import javax.swing.*;
import controler.ContrInterface1;
import controler.ContrInterface1Next;
import model.ArbreGenealogique;
import java.awt.*;

public class Interface1 extends JFrame {
    JLabel aff;
    JTextField nomArbre = new JTextField(20);
    public JButton CreeArbre = new JButton("Créer Arbre");
    public JButton Next = new JButton("Suivant");
    public ArbreGenealogique arbre;
    public Interface1() {
        this.setTitle("Création Arbre");
        aff = new JLabel("<html><div style='color: green;style='text-align: center; font-family: \"Times New Roman\", Times, serif; font-weight: bold;'>Bienvenue dans le projet arbre généalogique<br>Projet au sens de l'Université d'Evry Paris Saclay<br>Merci de saisir le nom de l'arbre pour continuer</div></html>");
        aff.setHorizontalAlignment(SwingConstants.CENTER);
        aff.setFont(new Font("Times New Roman", Font.PLAIN, 36));
     
        GridLayout sp1 = new GridLayout(3, 1);
        JPanel cont = new JPanel();
        cont.setLayout(new FlowLayout(FlowLayout.CENTER));
        cont.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        nomArbre.setFont(new Font("Arial", Font.PLAIN, 27)); 
        nomArbre.setColumns(36);
        
        JPanel boutton = new JPanel();
        FlowLayout sp2 = new FlowLayout();
        boutton.setLayout(sp2);
        
        getContentPane().setLayout(sp1);
        getContentPane().add(aff);
        getContentPane().add(cont);
        getContentPane().add(boutton);
        
        CreeArbre.setFont(new Font("Times New Roman", Font.PLAIN, 30)); 
        CreeArbre.setPreferredSize(new Dimension(250, 150)); 
        Next.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        Next.setPreferredSize(new Dimension(250, 150)); 
        
        cont.add(nomArbre);
        boutton.add(CreeArbre);
        boutton.add(Next);
        
        ContrInterface1 gd = new ContrInterface1(nomArbre, aff, this);
        CreeArbre.addActionListener(gd);
        
        ContrInterface1Next nextHandler = new ContrInterface1Next(this);
        Next.addActionListener(nextHandler);
        Next.setVisible(false);
        
        this.setSize(1200, 600); 
        this.setResizable(false); 
        this.setLocationRelativeTo(null); 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        this.setVisible(true); 
    }

    public void setArbre(ArbreGenealogique arbre) {
        this.arbre = arbre;
    }
}