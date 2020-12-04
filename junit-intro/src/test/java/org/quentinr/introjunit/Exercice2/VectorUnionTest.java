package org.quentinr.introjunit.Exercice2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Vector;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

public class VectorUnionTest {
    

    @Test
    public void testMergeVectors(){
        Vector<Object> test = new Vector<Object>() {
            private static final long serialVersionUID = 1L;

            {
                add(1);
                add("1");
            }
        };
        Vector<Object> test2 = new Vector<Object>() {
            private static final long serialVersionUID = 1L;

            {
                add(1.00);
            }
        };

        Vector<Object> test3 = VectorUnion.unionSet(test, test2);
        assertEquals(1, test3.size());
    }

    void testMergeTwoTypedVectors() {}


}
