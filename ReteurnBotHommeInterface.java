package controler;

import controler.*;
import vue.*;
import model.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class ReteurnBotHommeInterface implements ActionListener {
    HommeInterface Interface;

    public ReteurnBotHommeInterface(HommeInterface h) {
        Interface = h;
    }

    public void actionPerformed(ActionEvent e) {
        Interface.setVisible(false);
    }
}