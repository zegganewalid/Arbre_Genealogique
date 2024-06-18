package controler;

import vue.*;
import java.awt.event.*;
import javax.swing.*;

public class AfficherBotAncerts implements ActionListener {
    Interface1 inter;
    AncetresInterface ii;
    public AfficherBotAncerts(Interface1 i, AncetresInterface k) {
        inter = i;
        ii = k;
    }
    public void actionPerformed(ActionEvent e) {
        AncetresInterface2 in = new AncetresInterface2(inter, ii);
    }
}