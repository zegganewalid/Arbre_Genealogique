package controler;

import controler.*;
import vue.*;
import model.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class ReteurnBotAjouterMariage implements ActionListener {
    AjouterMariageInterface Interface;

    public ReteurnBotAjouterMariage(AjouterMariageInterface h) {
        Interface = h;
    }

    public void actionPerformed(ActionEvent e) {
        Interface.setVisible(false);
    }
}