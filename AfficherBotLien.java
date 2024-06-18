package controler;

import vue.*;
import java.awt.event.*;
import javax.swing.*;

public class AfficherBotLien implements ActionListener{
    Interface1 inter;
    LienInterface ii;
    public AfficherBotLien(Interface1 i, LienInterface k) {
        inter = i;
        ii = k;
    }
    public void actionPerformed(ActionEvent e) {
        LienInterface2 in = new LienInterface2(inter, ii);
    }
}
