package org.quentinr.introjunit;

class Money {
    private int fAmount;
    private String fCurrency;

    public Money(int amount, String currency) throws Exception {
        if (amount < 0) {
            throw new Exception("Amount must be positive");
        }
        if (currency.length() != 3) {
            throw new Exception("Currency must be string with 3 chars");
        }
        this.fAmount = amount;
        this.fCurrency = currency;
    }

    public int amount() {
        return this.fAmount;
    }

    public String currency() {
        return this.fCurrency;
    }

    public Money add(Money m) throws Exception {
        if (m.currency().equals(this.fCurrency) ) {
            this.fAmount += m.amount();
        } else {
            throw new Exception("Money's currencies need to be same");
        }
        return this;
    }

    public Money add(int namount, String ncurrency) throws Exception {
        if (this.fCurrency.equals(ncurrency)) {
            if (this.fAmount + namount > 0){
                this.fAmount += namount;
            }
            else {
                throw new Exception("amount after operation must be positive");
            }
        } else {
            throw new Exception("Money's currencies need to be same");
        }

        return this;
    }
}