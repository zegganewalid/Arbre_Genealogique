package controler;

import java.awt.event.*;
import javax.swing.*;

public class DateMortItemListenerHomme implements ItemListener {
    private JComboBox<String> jourMort;
    private JComboBox<String> moisMort;
    private JComboBox<String> anneeMort;
    private JCheckBox chkDateMort;
    public DateMortItemListenerHomme(JComboBox<String> jourMort, JComboBox<String> moisMort, JComboBox<String> anneeMort, JCheckBox chkDateMort) {
        this.jourMort = jourMort;
        this.moisMort = moisMort;
        this.anneeMort = anneeMort;
        this.chkDateMort = chkDateMort;
    }
    public void itemStateChanged(ItemEvent e) {
        // Afficher les JComboBox lorsque la case à cocher est cochée
        boolean enabled = chkDateMort.isSelected();
        jourMort.setEnabled(enabled);
        moisMort.setEnabled(enabled);
        anneeMort.setEnabled(enabled);
    }
}
