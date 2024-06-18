package controler;
import java.awt.event.*;
import javax.swing.*;

public class DateMortItemListenerFemme implements ItemListener {
    private JComboBox<String> jourMort;
    private JComboBox<String> moisMort;
    private JComboBox<String> anneeMort;
    private JCheckBox chkDateMort;

    public DateMortItemListenerFemme(JComboBox<String> jourMort, JComboBox<String> moisMort, JComboBox<String> anneeMort, JCheckBox chkDateMort) {
        this.jourMort = jourMort;
        this.moisMort = moisMort;
        this.anneeMort = anneeMort;
        this.chkDateMort = chkDateMort;
    }

    public void itemStateChanged(ItemEvent e) {
        boolean enabled = chkDateMort.isSelected();
        jourMort.setEnabled(enabled);
        moisMort.setEnabled(enabled);
        anneeMort.setEnabled(enabled);
    }
}
