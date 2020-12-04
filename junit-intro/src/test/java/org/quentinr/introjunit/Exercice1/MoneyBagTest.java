package org.quentinr.introjunit.Exercice1;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MoneyBagTest {

    MoneyBag globalBag;

    @BeforeEach
    void createMoneyBag() {
        Money money1, money2, money3, money4;
        this.globalBag = new MoneyBag();

        try {
            money1 = new Money(50, "EUR");
            money2 = new Money(50, "USD");
            money3 = new Money(50, "CHF");
            money4 = new Money(50, "GBP");

            this.globalBag.add(money1);
            this.globalBag.add(money2);
            this.globalBag.add(money3);
            this.globalBag.add(money4);

        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    MoneyBag createSpecificMoneyBag() {
        Money money1, money2, money3, money4;
        MoneyBag moneyBag = new MoneyBag();

        try {
            money1 = new Money(50, "EUR");
            money2 = new Money(50, "USD");
            money3 = new Money(50, "CHF");
            money4 = new Money(50, "GBP");

            moneyBag.add(money1);
            moneyBag.add(money2);
            moneyBag.add(money3);
            moneyBag.add(money4);

        } catch (Exception e) {
            fail(e.getMessage());
        }
        return moneyBag;
    }

    @Test
    void createMoneyBagT() {
        MoneyBag moneybag = new MoneyBag();
        assertEquals(0, moneybag.moneys.size());
    }

    @Test
    void addMoney() {
        Money money;
        try {
            money = new Money(50, "EUR");
            this.globalBag.add(money);

        } catch (Exception e) {
            fail(e.getMessage());
        }
        assertEquals(100, this.globalBag.moneys.get("EUR").amount());
    }

    @Test
    void addMoneyBag() {
        MoneyBag toAdd = createSpecificMoneyBag();
        try {
            this.globalBag.add(toAdd);
        } catch (Exception e) {
            fail(e.getMessage());
        }
        for (Map.Entry<String, Money> entry : this.globalBag.moneys.entrySet()) {
            assertEquals(100, entry.getValue().amount());
        }
        assertEquals(4, this.globalBag.moneys.size());
    }

    @Test
    void addNonexistingMoney() {
        MoneyBag moneyBag = new MoneyBag();
        try {
            moneyBag.add(new Money(150, "EUR"));
        } catch (Exception e) {
            fail(e.getMessage());
        }
        assertEquals(150, moneyBag.moneys.get("EUR").amount());
        assertEquals(1, moneyBag.moneys.size());
    }

    @Test
    void addNonexistingMoneyBag() {
        MoneyBag moneyBag = new MoneyBag();
        try {
            moneyBag.add(this.globalBag);
        } catch (Exception e) {
            fail(e.getMessage());
        }
        for (Map.Entry<String, Money> entry : moneyBag.moneys.entrySet()) {
            assertEquals(50, entry.getValue().amount());
        }
        assertEquals(4, moneyBag.moneys.size());
    }

    @Test
    void subExistingMoney() {
        Money money;
        try {
            money = new Money(25, "EUR");
            this.globalBag.subb(money);
        } catch (Exception e) {
            fail(e.getMessage());
        }
        for (Map.Entry<String, Money> entry : this.globalBag.moneys.entrySet()) {
            if (entry.getKey() == "EUR") {
                assertEquals(25, entry.getValue().amount());
            } else {
                assertEquals(50, entry.getValue().amount());
            }

        }
        assertEquals(4, this.globalBag.moneys.size());

    }

    @Test
    void subNonExistingMoney() {
        Money money;
        MoneyBag moneyBag = new MoneyBag();
        try {
            money = new Money(35, "EUR");

            Exception thrown = assertThrows(
                Exception.class,
                () -> moneyBag.subb(money),
                "Expected thrown exception, but it didn't"
            );

            String expectedMessage = "Can't substract money if MoneyBag don't have this currency";
            String actualMessage = thrown.getMessage();
            assertSame(actualMessage, expectedMessage);
        } catch (Exception e) {
            fail(e.getMessage());
        }

    }

    @Test
    void subMoneyBag() {
        Money money;
        try {
            money = new Money(25, "EUR");
            this.globalBag.subb(money);

            assertEquals(25, this.globalBag.moneys.get("EUR").amount());
            assertEquals(4, this.globalBag.moneys.size());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    void normalizeTest() {
        Double normalizeValue = this.globalBag.normalize();
        assertEquals(192, normalizeValue);
    }

    @Test
    void equalsNormalizeTest() {
        assertTrue(this.globalBag.normalizeEqual(this.globalBag));
    }

    @Test
    void notEqualsNormalizeTest() {
        MoneyBag moneyBagTest = new MoneyBag();
        assertFalse(moneyBagTest.normalizeEqual(this.globalBag));
    }

}
