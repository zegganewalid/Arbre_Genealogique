package controler;

import vue.*;
import java.awt.event.*;
import javax.swing.*;

public class AfficherBotCousins2 implements ActionListener{
    Interface1 inter;
    CousinsInterface ii;
    public AfficherBotCousins2(Interface1 i, CousinsInterface k) {
        inter = i;
        ii = k;
    }
    public void actionPerformed(ActionEvent e) {
        CousinsInterface2 in = new CousinsInterface2(inter, ii);
    }
}