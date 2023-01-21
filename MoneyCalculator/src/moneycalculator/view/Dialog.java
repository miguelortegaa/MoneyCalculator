package moneycalculator.view;

import moneycalculator.model.Currency;
import moneycalculator.model.Money;

public interface Dialog {
    public Money getMoney();
    public Currency getCurrencyTo();
}
