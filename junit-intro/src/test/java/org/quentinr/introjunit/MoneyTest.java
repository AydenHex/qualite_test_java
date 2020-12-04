package org.quentinr.introjunit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

class MoneyTest {

    private Money money;

    private void generateGlobalAmount(int amount, String currency) {
        try {
            this.money = new Money(amount, currency);
        }
        catch (Exception e)
        {
            fail(e.getMessage());
        }
    }

    private Object generateSpecificAmount(int amount, String currency) {
        Money money;
        try {
            money = new Money(amount, currency);
            return money;
            
        }
        catch (Exception e)
        {
            fail(e.getMessage());
            return e;
        }
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
        
        String expectedMessage = "Currency must be string with 3 chars";
        String actualMessage = thrown.getMessage();
        assertSame(actualMessage, expectedMessage);
    }

    @Test
    void testGetAmount(){
        this.generateGlobalAmount(150, "EUR");
        assertEquals(this.money.amount(), 150);
    }

    @Test
    void testGetCurrency(){
        this.generateGlobalAmount(150, "EUR");
        assertSame(this.money.currency(), "EUR");
    }

    @Test
    void addSameCurrencyPositiveAmountByMoney() {
        this.generateGlobalAmount(20, "EUR");
        Money moneyAdd = (Money) this.generateSpecificAmount(20, "EUR");
        try {
            this.money.add(moneyAdd);
        } catch (Exception e) {
            fail(e.getMessage());
        }
        
        assertEquals(this.money.amount(), 40);
    }
    @Test
    void addDifferentCurrencyPositiveMoney() {
        this.generateGlobalAmount(20, "EUR");
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
        this.generateGlobalAmount(20, "EUR");
        try {
            this.money.add(20, "EUR");
        } catch (Exception e) {
            fail(e.getMessage());
        }
        assertEquals(this.money.amount(), 40);
    }
    @Test
    void addDifferentCurrencyPositiveAmout() {
        this.generateGlobalAmount(20, "EUR");
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
        this.generateGlobalAmount(20, "EUR");
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