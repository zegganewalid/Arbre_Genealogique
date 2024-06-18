package controler;
import vue.Interface1;
import vue.Interface2;
import java.awt.event.*;
import javax.swing.*;

import model.ArbreGenealogique;

public class ContrInterface1Next implements ActionListener {
    Interface1 inter;
    public ContrInterface1Next(Interface1 i) {
        inter = i;
    }
    public void actionPerformed(ActionEvent e) {
        Interface2 in = new Interface2(inter);
    }
}
