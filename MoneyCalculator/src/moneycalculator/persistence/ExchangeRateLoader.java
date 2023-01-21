package moneycalculator.persistence;

import moneycalculator.model.Currency;
import moneycalculator.model.ExchangeRate;

public interface ExchangeRateLoader {
    public ExchangeRate exchangerateLoader(Currency from, Currency to);
}