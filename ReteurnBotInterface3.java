package controler;

import controler.*;
import vue.*;
import model.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;


public class ReteurnBotInterface3 implements ActionListener{
    Interface3 inter;
    public ReteurnBotInterface3(Interface3 inter){
        this.inter = inter;
    }
    public void actionPerformed(ActionEvent e){
        inter.setVisible(false);
    }
}
