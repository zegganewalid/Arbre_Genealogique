package vue;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import controler.*;
import model.*;

public class AncetresInterface2 extends JFrame{
    Interface1 inter;
    AncetresInterface ii;
    JTextArea textArea = new JTextArea();
    public AncetresInterface2(Interface1 i, AncetresInterface kk){
        inter = i;
        ii = kk;
        this.setTitle("Afficher Les Ancetres");
        textArea.append(inter.arbre.AfficherAncetres(inter.arbre.RecherchePersArbre(ii.comboBox1.getSelectedItem().toString(), inter.arbre)));
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
