package controler;
import model.*;
import vue.*;
import java.awt.event.*;
import javax.swing.*;

public class ContrlInterface4frereSoeurs implements ActionListener {
    Interface1 inter;
    public ContrlInterface4frereSoeurs(Interface1 i){
        inter = i ;
    }
    public void actionPerformed(ActionEvent e) {
        System.out.println(inter.arbre);
        FrereSoeursInterface ia = new FrereSoeursInterface(inter);
    }
}