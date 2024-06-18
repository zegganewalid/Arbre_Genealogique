package controler;

import controler.*;
import vue.*;
import model.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;


public class RetourBotAncetres implements ActionListener{
    AncetresInterface inter;
    public RetourBotAncetres(AncetresInterface i){
        inter = i;
    }
    public void actionPerformed(ActionEvent e){
        inter.setVisible(false);
    }
}
