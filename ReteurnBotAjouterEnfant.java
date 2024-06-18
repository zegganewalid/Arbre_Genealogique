package controler;

import controler.*;
import vue.*;
import model.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class ReteurnBotAjouterEnfant implements ActionListener {
    AjouterEnfantInterface Interface;

    public ReteurnBotAjouterEnfant(AjouterEnfantInterface h) {
        Interface = h;
    }

    public void actionPerformed(ActionEvent e) {
        Interface.setVisible(false);
    }
}