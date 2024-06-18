package vue;

import javax.swing.*;
import controler.*;
import model.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.*;

public class CousinsInterface2 extends JFrame{
    Interface1 inter;
    CousinsInterface ii;
    JTextArea textArea = new JTextArea();
    public CousinsInterface2(Interface1 i, CousinsInterface kk){
        inter = i;
        ii = kk;
        this.setTitle("Afficher Les Cousins");
        textArea.append(inter.arbre.AfficherCousins(inter.arbre.RecherchePersArbre(ii.comboBox1.getSelectedItem().toString(), inter.arbre)));
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