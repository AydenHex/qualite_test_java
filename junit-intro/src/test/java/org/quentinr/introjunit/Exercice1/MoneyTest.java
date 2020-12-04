package org.quentinr.introjunit.Exercice1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MoneyTest {

    private Money money;

    @BeforeEach
    private void generateGlobalMoney() {
        try {
            this.money = new Money(20, "EUR");
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    private Object generateSpecificMoney(int amount, String currency) {
        Money money;
        try {
            money = new Money(amount, currency);
            return money;

        } catch (Exception e) {
            fail(e.getMessage());
            return e;
        }
    }
    @Test
    void testSetAmountPositive() {
        try {
            this.money.setAmount(300);
        } catch (Exception e) {
            fail(e);
        }
        assertEquals(this.money.amount(), 300);
    }

    @Test
    void testSetAmountNegative() {
        Exception thrown = assertThrows(
            Exception.class,
            () -> this.money.setAmount(-100),
            "Expected thrown exception, but it didn't"
        );
        
        String expectedMessage = "Amount must be positive";
        String actualMessage = thrown.getMessage();
        assertSame(actualMessage, expectedMessage);
    }
    @Test
    void testCreatePositiveAmountMoney() {
        try {
            money = new Money(150, "EUR");
        }
        catch (Exception e) {
            fail(e.getMessage());
        }
        assertEquals(money.amount(), 150);
        assertSame(money.currency(), "EUR");
        
    }

    @Test
    void testCreateNegativeAmountMoney() {
        Exception thrown = assertThrows(
            Exception.class,
            () -> new Money(-150, "EUR"),
            "Expected thrown exception, but it didn't"
        );
        
        String expectedMessage = "Amount must be positive";
        String actualMessage = thrown.getMessage();
        assertSame(actualMessage, expectedMessage);
    }

    @Test
    void testCreateWrongCurrency() {
        Exception thrown = assertThrows(
            Exception.class,
            () -> new Money(150, "EURDEZDZE"),
            "Expected thrown exception, but it didn't"
        );
        
        String expectedMessage = "Currency not managed";
        String actualMessage = thrown.getMessage();
        assertSame(actualMessage, expectedMessage);
    }

    @Test
    void testGetAmount(){
        assertEquals(this.money.amount(), 20);
    }

    @Test
    void testGetCurrency(){
        assertSame(this.money.currency(), "EUR");
    }

    @Test
    void addSameCurrencyPositiveAmountByMoney() {
        Money moneyAdd = (Money) this.generateSpecificMoney(20, "EUR");
        try {
            this.money.add(moneyAdd);
        } catch (Exception e) {
            fail(e.getMessage());
        }
        
        assertEquals(this.money.amount(), 40);
    }
    @Test
    void addDifferentCurrencyPositiveMoney() {
        Exception thrown = assertThrows(
            Exception.class,
            () -> this.money.add(50, "USD"),
            "Expected thrown exception, but it didn't"
        );
        String expectedMessage = "Money's currencies need to be same";
        String actualMessage = thrown.getMessage();
        assertSame(actualMessage, expectedMessage);
    }

    @Test
    void addSameCurrencyPositiveAmout() {
        try {
            this.money.add(20, "EUR");
        } catch (Exception e) {
            fail(e.getMessage());
        }
        assertEquals(this.money.amount(), 40);
    }
    @Test
    void addDifferentCurrencyPositiveAmout() {
        Exception thrown = assertThrows(
            Exception.class,
            () -> this.money.add(50, "USD"),
            "Expected thrown exception, but it didn't"
        );
        String expectedMessage = "Money's currencies need to be same";
        String actualMessage = thrown.getMessage();
        assertSame(actualMessage, expectedMessage);
    }

    @Test
    void addDifferentCurrencyNegativeAmountNegativeResult() {
        Exception thrown = assertThrows(
            Exception.class,
            () -> this.money.add(-50, "EUR"),
            "Expected thrown exception, but it didn't"
        );
        String expectedMessage = "amount after operation must be positive";
        String actualMessage = thrown.getMessage();
        assertSame(actualMessage, expectedMessage);
    }

}