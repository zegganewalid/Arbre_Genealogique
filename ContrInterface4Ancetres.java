package controler;
import model.*;
import vue.*;
import java.awt.event.*;
import javax.swing.*;

public class ContrInterface4Ancetres implements ActionListener {
    Interface1 inter;
    public ContrInterface4Ancetres(Interface1 i){
        inter = i ;
    }
    public void actionPerformed(ActionEvent e) {
        System.out.println(inter.arbre);
        AncetresInterface ia = new AncetresInterface(inter);
    }
}