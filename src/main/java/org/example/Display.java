package org.example;

import javax.swing.*;
import java.awt.*;

public class Display {

    private JFrame frame = new JFrame();
    private JButton buttonOne = new JButton("Shit");
    private JPanel panel = new JPanel();
    private JLabel label = new JLabel("Frig");

    private int buttonWidth = 120;
    private int buttonHeight = 30;

    public void createDisplay(int height, int width, String title){
        frame.setLocationRelativeTo(null);
        frame.setTitle(title);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);

        frame.setLayout(new BorderLayout());

        panel.setBounds(0,0, width, height);
        //buttonOne.setBounds((width / 2) - (buttonWidth / 2), height/2, buttonWidth,buttonHeight);
        panel.add(buttonOne);
        panel.add(label);

        frame.add(panel);
        //Always las
        frame.setVisible(true);

    }
}
