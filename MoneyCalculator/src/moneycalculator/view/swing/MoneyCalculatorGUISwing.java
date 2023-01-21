package moneycalculator.view.swing;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MoneyCalculatorGUISwing extends JFrame{

    public MoneyCalculatorGUISwing(JPanel jpanel, String title) {
        super(title);
        getContentPane().add(jpanel);
        addWindowListener(new WindowCloseManager());
        pack();
        setVisible(true);
    }

    private static class WindowCloseManager extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent windowEvent) {
            System.exit(0);
        }        
    }
    
}
