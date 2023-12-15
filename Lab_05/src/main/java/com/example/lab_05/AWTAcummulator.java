package com.example.lab_05;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AWTAcummulator extends Frame {
    private TextField tfInput;
    private TextField tfOutput;
    private int sum = 0; //Accumulated sum, init to 0

    //Constructor to setup the GUI components and event handlers
    public AWTAcummulator(){
        setLayout(new GridLayout(2, 2));
        add(new Label("Enter an Integer: "));

        tfInput = new TextField(10);
        add(tfInput);
        tfInput.addActionListener(new TFInputListener());

        add(new Label("The Accumulated Sum is: "));

        tfOutput = new TextField(10);
        tfOutput.setEditable(false);
        add(tfOutput);

        setTitle("AWT Acummulator");
        setSize(350, 120);
        setVisible(true);
    }

    public static void main(String[] args){
        new AWTAcummulator();
    }

    private class TFInputListener implements ActionListener {
        public void actionPerformed(ActionEvent evt){
            int numberIn = Integer.parseInt(tfInput.getText());
            sum += numberIn;
            tfInput.setText("");
            tfOutput.setText(sum + "");
        }
    }
}
