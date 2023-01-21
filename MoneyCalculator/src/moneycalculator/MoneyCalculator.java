package moneycalculator;

import java.util.List;
import javax.swing.SwingUtilities;
import moneycalculator.control.MCController;
import moneycalculator.model.Currency;
import moneycalculator.model.Money;
import moneycalculator.persistence.files.CurrencyLoaderFromFile;
import moneycalculator.persistence.rest.ExchangeRateLoaderFromWebService;
import moneycalculator.view.swing.DialogSwing;
import moneycalculator.view.swing.DisplaySwing;
import moneycalculator.view.swing.MoneyCalculatorGUISwing;

public class MoneyCalculator {

    public static void main(String[] args) {
        System.out.println("MoneyCalculator...");
        CurrencyLoaderFromFile currencyLoaderFromFile = new CurrencyLoaderFromFile("currencies");
        List<Currency> currencies = currencyLoaderFromFile.currencyLoader();
        
        ExchangeRateLoaderFromWebService exchangeRateLoaderFromWebService = new ExchangeRateLoaderFromWebService();

        DisplaySwing displaySwing = new DisplaySwing(new Money(0.0, currencies.get(0)));
        DialogSwing dialogSwing = new DialogSwing(currencies);
        
        new MCController(dialogSwing, 
                         displaySwing, 
                         exchangeRateLoaderFromWebService);
        
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MoneyCalculatorGUISwing(displaySwing, "Money Calculator Display...");
                new MoneyCalculatorGUISwing(dialogSwing, "Money Calculator Display...");        
            }
        });
    }
}
