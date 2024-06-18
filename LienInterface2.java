package vue;

import javax.swing.*;
import controler.*;
import model.*;
import java.awt.*;
import java.util.*;

public class LienInterface2 extends JFrame{
    Interface1 inter;
    LienInterface ii;
    JTextArea textArea = new JTextArea();
    public LienInterface2(Interface1 i, LienInterface  kk){
        inter = i;
        ii = kk;
        this.setTitle("Afficher Lien entre deux Personnes");
        textArea.append(inter.arbre.AfficherLienParente(inter.arbre.RecherchePersArbre(ii.comboBox1.getSelectedItem().toString(), inter.arbre),inter.arbre.RecherchePersArbre(ii.comboBox2.getSelectedItem().toString(), inter.arbre)));
        textArea.setForeground(Color.WHITE);

        JScrollPane scrollPane = new JScrollPane(textArea);
        getContentPane().add(scrollPane);
        Font font = new Font("Arial", Font.PLAIN, 34); 
        textArea.setFont(font);
        textArea.setBackground(Color.BLUE);
        
        this.setSize(1500, 1000);
        this.show();
        this.setLocationRelativeTo(null);
        this.setVisible(true); 
    }
}