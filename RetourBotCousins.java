package controler;

import controler.*;
import vue.*;
import model.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class RetourBotCousins implements ActionListener{
    CousinsInterface inter;
    public RetourBotCousins(CousinsInterface i){
        inter = i;
    }
    public void actionPerformed(ActionEvent e){
        inter.setVisible(false);
    }
}