package org.quentinr.introjunit;

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
            this.moneys.put(money.currency(), money);
        }
        return this;
    }

    public MoneyBag add(MoneyBag moneyBag) throws Exception {
        for (Map.Entry<String, Money> entry : moneyBag.moneys.entrySet()) {
            this.add(entry.getValue());
        }
        return this;
    }

    public MoneyBag subb(Money money) {
        return this;
    }

    public static void main(String[] args) {
        MoneyBag moneybag = new MoneyBag();
        MoneyBag moneybag2 = new MoneyBag();
        Money money, money2;
        try {
            money = new Money(150, "EUR");
            money2 = new Money(250, "USD");
            moneybag.add(money);
            moneybag.add(money);
            moneybag2.add(money2);
            System.out.println(moneybag.moneys().get("EUR").amount());
        } catch (Exception e) {
            System.out.println();
        }
        try {
            moneybag.add(moneybag2);
            System.out.println(moneybag.moneys().get("USD").amount());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
