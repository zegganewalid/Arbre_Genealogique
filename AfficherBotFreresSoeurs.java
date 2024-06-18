package controler;

import vue.*;
import java.awt.event.*;
import javax.swing.*;

public class AfficherBotFreresSoeurs implements ActionListener{
    Interface1 inter;
    FrereSoeursInterface ii;
    public AfficherBotFreresSoeurs(Interface1 i, FrereSoeursInterface k) {
        inter = i;
        ii = k;
    }
    public void actionPerformed(ActionEvent e) {
        FrereSoeursInterface2 in = new FrereSoeursInterface2(inter, ii);
    }
}