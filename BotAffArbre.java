package controler;
import model.*;
import vue.*;
import java.awt.event.*;
import javax.swing.*;

public class BotAffArbre implements ActionListener {
    Interface1 inter;
    public BotAffArbre(Interface1 i){
        inter = i ;
    }
    public void actionPerformed(ActionEvent e) {
        System.out.println(inter.arbre);
        InterfaceAffArbre ia = new InterfaceAffArbre(inter);
    }
}