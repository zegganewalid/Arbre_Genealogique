package controler;

import vue.*;
import java.awt.event.*;
import javax.swing.*;

import model.ArbreGenealogique;

public class ContrIntrface3Femme implements ActionListener {
    Interface1 inter;
    public ContrIntrface3Femme(Interface1 i) {
        inter = i ;
    }

    public void actionPerformed(ActionEvent e) {
        FemmeInterface in = new FemmeInterface(inter);
    }
}
