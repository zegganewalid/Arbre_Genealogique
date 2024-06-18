package vue;
import javax.swing.*;
import java.awt.*;
import model.*;
import controler.*;
import java.util.*;

public class InterfaceAffArbre extends JFrame {
    JTextArea textArea = new JTextArea();
    Interface1 inter;

    public InterfaceAffArbre(Interface1 i) {
        inter = i;
        this.setTitle("Affichage de l'Arbre Généalogique");
        textArea.append(inter.arbre.AfficherArbre(inter.arbre));
        textArea.setForeground(Color.WHITE);

        JScrollPane scrollPane = new JScrollPane(textArea);
        getContentPane().add(scrollPane);

        scrollPane.setPreferredSize(new Dimension(1200, 800));
        textArea.setBackground(Color.BLUE);
        Font font = new Font("Arial", Font.PLAIN, 34);
        textArea.setFont(font);
        this.pack(); 
        this.show();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}