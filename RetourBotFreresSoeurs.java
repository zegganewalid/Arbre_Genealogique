package controler;

import controler.*;
import vue.*;
import model.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class RetourBotFreresSoeurs implements ActionListener{
    FrereSoeursInterface inter;
    public RetourBotFreresSoeurs(FrereSoeursInterface i){
        inter = i;
    }
    public void actionPerformed(ActionEvent e){
        inter.setVisible(false);
    }
}