package org.quentinr;

import org.quentinr.Square.Square;
import org.quentinr.gui.views.HomeViews;

import java.awt.event.*;
import java.util.Iterator;
import java.util.Map;

public class App {

    public static void main(String[] args) {
        HomeViews test = new HomeViews("SquareRoot");
        test.getCalculateSquare().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    int A = Integer.parseInt(test.getValue1().getText());
                    int B = Integer.parseInt(test.getValue2().getText());
                    Map<Integer, Double> result = calculer(A, B);
                    test.getResultLabel().setText(buildResult(result));
                } catch (Exception e) {
                    test.getResultLabel().setText("Exception : " + e.getMessage());
                }
            }
        });
    }

    public static Map<Integer, Double> calculer(int A, int B) {
        return Square.getSquares(A, B);
    }

    public static String buildResult(Map<Integer, Double> resutlMap) {
        StringBuilder builder = new StringBuilder();

        for (Map.Entry entry : resutlMap.entrySet()) {
            builder.append(entry.getKey() + " : " + entry.getValue() + " \n");
        }
        return builder.toString();
    }

}
