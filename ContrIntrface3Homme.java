package controler;

import vue.Interface3;
import vue.HommeInterface;
import vue.Interface1;

import java.awt.event.*;
import javax.swing.*;

import model.ArbreGenealogique;

public class ContrIntrface3Homme implements ActionListener {
    Interface1 inter;
    public ContrIntrface3Homme( Interface1 i) {
        inter = i;
    }
    public void actionPerformed(ActionEvent e) {
        HommeInterface in = new HommeInterface(inter);
    }
}
