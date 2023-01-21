package moneycalculator.persistence;

import moneycalculator.model.Currency;

import java.util.List;

public interface CurrencyLoader {
    public List<Currency> currencyLoader();
}
