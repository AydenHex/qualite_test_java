package org.quentinr.Square;

import java.util.ArrayList;
import java.util.List;

/** Utilities class alows to get squares for numbers between A and B;
 * @author Quentin ROYER, Louis RIGAUD
 * @author https://github.com/aydenhex/tpjunit
 * @version 1.0
*/
public class Square {
    
    /** 
     * Allows to get an Array which contains each Sqrt values for integer between A and B;
     * @param A: Represent an Integer smaller than B
     * @param B: Represent an Integer greater than A
     * @return List<Double>: Represent an list of A < Sqrt(i) < B
     * @throws Exception: If A or B are negative integers, throw Exception;
     * @throws Exception: If  A is greater than B, throw Exception;
     */
    public static List<Double> getSquares(int A, int B) throws Exception {
        // Init results variable;
        List<Double> squares = new ArrayList<Double>();

        // Throws exceptions if...
        if (A <= 0 || B <= 0) {
            throw new Exception("Parameters should be positive integer greater than 0");
        }

        if (A >= B) {
            throw new Exception("B parameter should be geater than A");
        }

        // Browse integers between A and B and populate ArrayList with Sqrt(i) value;
        for (int i=A; i <= B; i++) {
            squares.add(Math.sqrt(i));
        }
        return squares;
    }
}
