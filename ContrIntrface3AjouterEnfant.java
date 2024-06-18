package controler;

import vue.*;
import java.awt.event.*;
import javax.swing.*;

public class ContrIntrface3AjouterEnfant implements ActionListener {
    Interface1 inter;
    public ContrIntrface3AjouterEnfant(Interface1 i) {
        inter = i;
    }
    public void actionPerformed(ActionEvent e) {
        AjouterEnfantInterface in = new AjouterEnfantInterface(inter);
    }
}
