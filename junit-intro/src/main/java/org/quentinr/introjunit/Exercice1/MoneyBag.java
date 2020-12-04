package org.quentinr.introjunit.Exercice1;


import java.util.HashMap;
import java.util.Map;

public class MoneyBag {
    // Represent Currency, Money sets
    HashMap<String, Money> moneys;

    public MoneyBag() {
        this.moneys = new HashMap<String, Money>();
    }

    public HashMap<String, Money> moneys() {
        return this.moneys;
    }

    public MoneyBag add(Money money) throws Exception {
        if (this.moneys.containsKey(money.currency())) {
            this.moneys.get(money.currency()).add(money);
        } else {
            this.moneys.put(money.currency(), new Money(money.amount(), money.currency()));
        }
        return this;
    }

    public MoneyBag add(MoneyBag moneyBag) throws Exception {
        for (Map.Entry<String, Money> entry : moneyBag.moneys.entrySet()) {
            this.add(entry.getValue());
        }
        return this;
    }

    public MoneyBag subb(Money money) throws Exception {
        if (this.moneys.containsKey(money.currency())){
            this.moneys.get(money.currency()).add(-money.amount(), money.currency());
        } else {
            throw new Exception("Can't substract money if MoneyBag don't have this currency");
        }

        return this;
    }

    public MoneyBag subb(MoneyBag moneyBag) throws Exception {
        for (Map.Entry<String, Money> entry : moneyBag.moneys.entrySet()) {
            this.subb(entry.getValue());
        }
        return this;
    }

    public Double normalize() {
        Double total = 0.00;
        for (Map.Entry<String, Money> entry : this.moneys.entrySet()) {
            switch (entry.getKey()) {
                case "EUR":
                    total += entry.getValue().amount();
                    break;
                case "USD":
                    total += (entry.getValue().amount() * 0.82);
                    break;
                case "CHF":
                    total += (entry.getValue().amount() * 0.92);
                    break;
                case "GBP":
                    total += (entry.getValue().amount() * 1.10);
                    break;
            
                default:
                    break;
            }
        }
        return total;
    }

    public Boolean normalizeEqual(MoneyBag moneyBag) {
        return (this.normalize().equals(moneyBag.normalize()));
    }

}
