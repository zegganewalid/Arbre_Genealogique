package controler;

import controler.*;
import vue.*;
import model.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;


public class ReteurnBotInterface4 implements ActionListener{
    Interface4 inter;
    public ReteurnBotInterface4(Interface4 inter){
        this.inter = inter;
    }
    public void actionPerformed(ActionEvent e){
        inter.setVisible(false);
    }
}
