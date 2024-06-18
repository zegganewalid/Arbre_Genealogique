package controler;
import model.*;
import vue.*;
import java.awt.event.*;
import javax.swing.*;


public class ContrlInterface4Lien implements ActionListener{
    Interface1 inter;
    public ContrlInterface4Lien(Interface1 i){
        inter = i ;
    }
    public void actionPerformed(ActionEvent e) {
        System.out.println(inter.arbre);
        LienInterface ia = new LienInterface(inter);
    }
}
