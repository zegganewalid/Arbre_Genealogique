package controler;
import model.*;
import vue.*;
import java.awt.event.*;
import javax.swing.*;

public class ContrlInterface4Cousin implements ActionListener{
    Interface1 inter;
    public ContrlInterface4Cousin(Interface1 i){
        inter = i ;
    }
    public void actionPerformed(ActionEvent e) {
        System.out.println(inter.arbre);
        CousinsInterface ia = new CousinsInterface(inter);
    }
}
