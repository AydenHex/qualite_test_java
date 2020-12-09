package org.quentinr.introjunit.Exercice2;

import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Vector;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

public class VectorUnionTest {

    Vector<Object> stringVector = new Vector<Object>() {
        /**
         *
         */
        private static final long serialVersionUID = 1L;

        {
            add("Bonjour");
            add("Hello World");
        }
    };
    Vector<Object> intVector = new Vector<Object>() {
        /**
         *
         */
        private static final long serialVersionUID = 1L;

        {
            add(1);
            add(12);
            add(3);
        }
    };
    Vector<Object> intVector2 = new Vector<Object>() {
        /**
         *
         */
        private static final long serialVersionUID = 1L;

        {
            add("3");
            add(17);
        }
    };

    @Test
    public void testMergeOk() {
        Vector <Object> result;
        result = assertDoesNotThrow(() -> VectorUnion.unionSet(intVector, intVector2));
        assertEquals(result.size(), 5);
    }

    @Test
    public void testMergeZeroSizeParameters() {
        Exception thrown = assertThrows(
            Exception.class,
            () -> VectorUnion.unionSet(new Vector<Object>(), new Vector<Object>()),
            "Expected thrown exception, but it didn't"
        );

        String expectedMessage = "Can't merge empty vectors";
        String actualMessage = thrown.getMessage();
        assertSame(actualMessage, expectedMessage);
    }
}
