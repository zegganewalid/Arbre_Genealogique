package controler;

import vue.*;
import java.awt.event.*;
import javax.swing.*;

import model.ArbreGenealogique;

public class ContrIntrface2aff implements ActionListener {
    Interface1 inter;
    public ContrIntrface2aff(Interface1 i) {
        inter = i;
    }
    public void actionPerformed(ActionEvent e) {
        Interface4 in = new Interface4(inter);
    }
}
