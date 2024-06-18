package controler;

import vue.*;
import java.awt.event.*;
import javax.swing.*;

public class ContrInterface3AjouterMariage implements ActionListener {
    Interface1 inter;
    public ContrInterface3AjouterMariage(Interface1 i) {
        inter = i;
    }
    public void actionPerformed(ActionEvent e) {
        AjouterMariageInterface in = new AjouterMariageInterface(inter);
    }
}
