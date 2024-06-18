package controler;
import vue.Interface1;
import model.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ContrInterface1 implements ActionListener {
    JTextField nomArbre;
    JLabel aff;
    Interface1 inter;
    public ContrInterface1(JTextField s, JLabel a, Interface1 i ) {
        inter=i;
        nomArbre = s;
        aff = a;
       
    }
    public void actionPerformed(ActionEvent e) {
        String name = nomArbre.getText();
        if (name.equals("")) {
            aff.setText("<html><div style='color: red; font-family: \"Times New Roman\", Times, serif; font-size: 36pt; font-weight: bold;'>Erreur : espace vide. Veuillez saisir un nom d'arbre une fois de plus :</div></html>");
            inter.Next.setVisible(false);
        } else {
            ArbreGenealogique arbre = new ArbreGenealogique();
            if(arbre != null){inter.setArbre(arbre);}
            aff.setText("<html><div style='color: green; font-family: \"Times New Roman\", Times, serif; font-size: 36pt; font-weight: bold;'>Arbre " + name + " créé. Veuillez cliquer sur Next pour continuer :</div></html>");
            inter.CreeArbre.setVisible(false);
            inter.Next.setVisible(true);
        }
    }
}