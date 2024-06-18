package controler;

import controler.*;
import vue.*;
import model.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class ReteurnBotFemmeInterface implements ActionListener {
    FemmeInterface Interface;

    public ReteurnBotFemmeInterface(FemmeInterface h) {
        Interface = h;
    }

    public void actionPerformed(ActionEvent e) {
        Interface.setVisible(false);
    }
}