package org.quentinr.gui.views;

import javax.swing.*;

import java.awt.*;

public class HomeViews extends JFrame{

    //MainContent
    private JPanel mainPan,btnPan,valuesPan;
    
    private JLabel value1Label, value2Label;
    private JTextArea result;
    private JTextField value1, value2;
    private JButton CalculateSquare;
    private JScrollPane resultScroll;


    public HomeViews(String titre) {
        // Set the frame

        setTitle(titre);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setPreferredSize(new Dimension(1000, 500));
        this.setLayout(new BorderLayout());
        setVisible(true);

       
        //Set the Panels
        btnPan= new JPanel();
        mainPan= new JPanel();
        valuesPan=new JPanel();
        valuesPan.setLayout(new FlowLayout());
        btnPan.setBackground(Color.RED);
        mainPan.setBackground(Color.ORANGE);


        //Set Contents in Main Layout
        
        // Set JTextfield and Jlabel...
        value1Label =new JLabel("Value 1 :");
        value1=new JTextField(10);
        value2Label =new JLabel("Value 2 :");
        value2=new JTextField(10);
        result=new JTextArea("En attent des resultats...", 15, 80);
        result.setLineWrap(true);
        result.setWrapStyleWord(true);
        resultScroll = new JScrollPane(result);
        
        // Set buttons
        CalculateSquare =new JButton();
        CalculateSquare.setText("Calculate");

        // adding principals features
        btnPan.add(CalculateSquare);
        mainPan.add(resultScroll, BorderLayout.CENTER);
            // adding valuesPan features
        valuesPan.add(value1Label);
        valuesPan.add(value1);
        valuesPan.add(value2Label);
        valuesPan.add(value2);

        this.getContentPane().add(valuesPan, BorderLayout.NORTH);
        this.getContentPane().add(mainPan, BorderLayout.CENTER);
        this.getContentPane().add(btnPan, BorderLayout.SOUTH);
        pack();

    }


    public JButton getCalculateSquare() {
        return this.CalculateSquare;
    }

    public void setCalculateSquare(JButton CalculateSquare) {
        this.CalculateSquare = CalculateSquare;
    }


    public JTextField getValue1() {
        return this.value1;
    }

    public void setValue1(JTextField value1) {
        this.value1 = value1;
    }

    public JTextField getValue2() {
        return this.value2;
    }

    public void setValue2(JTextField value2) {
        this.value2 = value2;
    }

    public JTextArea getResultLabel() {
        return this.result;
    }


}

