package org.quentinr;

import org.quentinr.gui.views.HomeViews;

public class App {
    
    public static void main(String[] args) {
        HomeViews test =new HomeViews("SquareRoot");
        test.getCalculateSquare().addActionListener(new ActionListener(){
            @Override
            public voide actionPerformed (ActionEvent actionEvent){
                    try {
                        calculer();
                    }catch (Exception e) {
                        e.printStackTrace();
                    }
            }
        });
    }

    public static void calculer() {
        int getValue1fromUser = Integer.parseInt(test.getValue1());
        int getValue2fromUser = Integer.parseInt(test.getValue2());

        Square square= new Square(getValue1fromUser, getValue2fromUser);

    }
    
}
