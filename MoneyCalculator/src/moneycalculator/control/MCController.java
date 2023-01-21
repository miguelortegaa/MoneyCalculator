package moneycalculator.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import moneycalculator.model.Currency;
import moneycalculator.model.ExchangeRate;
import moneycalculator.model.Money;
import moneycalculator.persistence.rest.ExchangeRateLoaderFromWebService;
import moneycalculator.view.swing.DialogSwing;
import moneycalculator.view.swing.DisplaySwing;

public class MCController implements ActionListener {
    private final DialogSwing dialogSwing;
    private final DisplaySwing displaySwing;
    private final ExchangeRateLoaderFromWebService exchangeRateLoaderFromWebService;

    public MCController(DialogSwing dialogSwing,
                        DisplaySwing displaySwing,
                        ExchangeRateLoaderFromWebService exchangeRateLoaderFromWebService) {
        this.dialogSwing = dialogSwing;
        this.displaySwing = displaySwing;
        this.exchangeRateLoaderFromWebService = exchangeRateLoaderFromWebService;
        this.dialogSwing.registerController(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
       Money money = this.dialogSwing.getMoney();
       Currency currencyFrom = money.getCurrency();
       Currency currencyTo = this.dialogSwing.getCurrencyTo();
       ExchangeRate exchangeRate = this.exchangeRateLoaderFromWebService.exchangerateLoader(currencyFrom, currencyTo);
       
       this.displaySwing.refreshMoney(new Money(exchangeRate.getRate() * money.getAmount(), currencyTo));
    }
}
