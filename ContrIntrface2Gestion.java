package controler;

import vue.*;
import java.awt.event.*;
import javax.swing.*;

import model.ArbreGenealogique;

public class ContrIntrface2Gestion implements ActionListener {
    Interface1 inter;
    public ContrIntrface2Gestion(Interface1 i) {
        inter = i ;
    }

    public void actionPerformed(ActionEvent e) {
        Interface3 inter3 = new Interface3(inter);
    }
}
