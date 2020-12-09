package org.quentinr.Square;

import java.util.HashMap;
import java.util.Map;

/** Utilities class alows to get squares for numbers between A and B;
 * @author Quentin ROYER, Louis RIGAUD
 * @author https://github.com/aydenhex/tpjunit
 * @version 1.0
*/
public class Square {
    

    /**
     * Unused constructor - Utilities class - Only for tests
     */
    private Square() {}
    /** 
     * Allows to get an Array which contains each Sqrt values for integer between A and B
     * @param A: Represent an Integer smaller than B
     * @param B: Represent an Integer greater than A
     * @return An arraylist of double that represent an list of A &lt; Sqrt(i) &gt; B
     * @throws IllegalArgumentException If A or B are negative integers, throw Exception
     * @throws IllegalArgumentException If  A is greater than B, throw Exception
     */
    public static Map<Integer, Double> getSquares(int A, int B) throws IllegalArgumentException {
        // Init results variable;
        Map<Integer, Double> squares = new HashMap<Integer, Double>();

        // Throws exceptions if...
        if (A <= 0 || B <= 0) {
            throw new IllegalArgumentException("Parameters should be positive integer greater than 0");
        }

        if (A >= B) {
            throw new IllegalArgumentException("B parameter should be geater than A");
        }

        // Browse integers between A and B and populate ArrayList with Sqrt(i) value;
        for (int i=A; i <= B; i++) {
            squares.put(i, Math.sqrt(i));
        }
        return squares;
    }

    public static void main(String[] args) {
        System.out.println(Square.getSquares(4, 62));
    }
}
