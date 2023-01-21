package moneycalculator.view.swing;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import moneycalculator.model.Money;
import moneycalculator.view.Display;

public class DisplaySwing extends JPanel implements Display {
    private JTextArea display;
    
    public DisplaySwing(Money money) {
        createComponentsGUI();
        refreshMoney(money);
    }
    
    private void createComponentsGUI() {
        this.display = new JTextArea(10, 40);
        this.display.setEditable(false);
        setLayout(new BorderLayout());
        JScrollPane scrollDisplay = new JScrollPane(this.display);
        this.add(scrollDisplay, BorderLayout.CENTER);
    }
    
    @Override
    public void refreshMoney(Money money) {
        this.display.setText("MONEY:\n======\n" + 
                             money.getAmount() + 
                             " " + 
                             money.getCurrency().getSymbol());
    }
}
