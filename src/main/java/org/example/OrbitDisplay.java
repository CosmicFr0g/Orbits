package org.example;

import javax.swing.*;

public class OrbitDisplay {
    private final JFrame frame = new JFrame();
    private OrbitPanel panel;          // custom panel that does the drawing

    public void createDisplay(int height, int width, String title) {
        frame.setTitle(title);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        panel = new OrbitPanel();
        frame.add(panel);

        frame.setVisible(true);

        // Start the animation loop (60 FPS-ish)
        Timer timer = new Timer(16, e -> panel.repaint());
        timer.start();
    }
}
