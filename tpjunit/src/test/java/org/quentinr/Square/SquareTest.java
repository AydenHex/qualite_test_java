package org.quentinr.Square;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class SquareTest {

    private static Map<Integer, Double> sampleResult = new HashMap<Integer, Double>();
    private List<Double> result;

    @BeforeAll
    public static void populateSampleResult() {
        sampleResult.put(0, 2.0);
        sampleResult.put(7, 3.3166247903554);
    }

    @AfterAll
    public static void destroySampleResult() {
        sampleResult = null;
    }

    @AfterEach
    public void resetResult() {
        this.result = null;
    }
    
    @Test
    public void squareCorrectParameters() {
        this.result = assertDoesNotThrow(() -> Square.getSquares(4, 62), "Throw an exception while using getSquare methods");

        // Test if the array sized correctly
        assertEquals(59, this.result.size());
        // Test some sqrt values in result
        assertEquals(sampleResult.get(0), this.result.get(0));
        assertEquals(sampleResult.get(7), this.result.get(7));
    }

    @Test
    public void squareAGreaterThanB() {
        Exception e = assertThrows(
            Exception.class,
            () -> Square.getSquares(62, 4),
            "Should throw exception A greater than B"
        );

        String testMessage = e.getMessage();
        String expectedMessage = "B parameter should be geater than A";
        assertEquals(expectedMessage, testMessage);
    }

    @Test
    public void squareNullParameters() {
        Exception e = assertThrows(
            Exception.class,
            () -> Square.getSquares(0, 0),
            "Parameters should be positive integer greater than 0"
        );

        String testMessage = e.getMessage();
        String expectedMessage = "Parameters should be positive integer greater than 0";
        assertEquals(expectedMessage, testMessage);
    }

    @Test
    public void squareNegativeParameters() {
        Exception e = assertThrows(
            Exception.class,
            () -> Square.getSquares(-10, -5),
            "Parameters should be positive integer greater than 0"
        );

        String testMessage = e.getMessage();
        String expectedMessage = "Parameters should be positive integer greater than 0";
        assertEquals(expectedMessage, testMessage);
    }

    @Test
    public void performanceTestShort() {
        assertTimeout(ofMillis(5), () -> Square.getSquares(1, 20));
    }

    @Test
    public void performanceTestLong() {
        assertTimeout(ofMillis(750), () -> Square.getSquares(1, 10000000));
    }
}
