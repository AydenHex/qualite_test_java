package org.quentinr.introjunit.Exercice1;

import java.util.ArrayList;

class Money {
    private int fAmount;
    private String fCurrency;
    public static ArrayList<String> CURRENCIES_MANAGED = new ArrayList<String>() {
        /**
         *
         */
        private static final long serialVersionUID = 1L;

        {
            add("EUR");
            add("USD");
            add("CHF");
            add("GBP");
        }
    };

    public Money(int amount, String currency) throws Exception {
        if (amount < 0) {
            throw new Exception("Amount must be positive");
        }
        if (!CURRENCIES_MANAGED.contains((currency))) {
            throw new Exception("Currency not managed");
        }
        this.fAmount = amount;
        this.fCurrency = currency;
    }

    public void setAmount(int namount) throws Exception {
        if (namount < 0) {
            throw new Exception("Amount must be positive");
        }
        this.fAmount = namount;
    }

    public int amount() {
        return this.fAmount;
    }

    public String currency() {
        return this.fCurrency;
    }

    public Money add(Money m) throws Exception {
        if (m.currency().equals(this.fCurrency)) {
            this.fAmount += m.amount();
        } else {
            throw new Exception("Money's currencies need to be same");
        }
        return this;
    }

    public Money add(int namount, String ncurrency) throws Exception {
        if (this.fCurrency.equals(ncurrency)) {
            if (this.fAmount + namount >= 0) {
                this.fAmount += namount;
            } else {
                throw new Exception("amount after operation must be positive");
            }
        } else {
            throw new Exception("Money's currencies need to be same");
        }

        return this;
    }
}