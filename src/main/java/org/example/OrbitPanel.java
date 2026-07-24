package org.example;

import javax.swing.*;
import java.awt.*;

public class OrbitPanel extends JPanel {
    private double angle1 = 0;
    private double angle2 = 0;
    private double angle3 = 0;
    private double angle4 = 0;

    public OrbitPanel() {
        setBackground(Color.BLACK);   // nice dark background for space vibe
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // Smooth edges
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        // --- Center point
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;

        // Ellipses
        int ellipsesRadius1_1 = 220;
        int ellipsesRadius1_2 = 180;
        int ellipsesRadius2_1 = 140;
        int ellipsesRadius2_2 = 110;
        int ellipsesRadius3_1 = 280;
        int ellipsesRadius3_2 = 250;

        int radius3 = 25;
        int radius4 = 25;
        int radius5 = 40;

        int starSize = 37;
        int starHalf = starSize / 2;

        g2.setColor(Color.GREEN);
        g2.fillRect(centerX - starHalf, centerY - starHalf, starSize, starSize);

        int planetSize = 10;
        int moonSize = 5;

        //---  Draw Orbit paths
        g2.setColor(new Color(0,80,0));

        //planets
        g2.drawOval(centerX - ellipsesRadius1_1, centerY - ellipsesRadius1_2, ellipsesRadius1_1 * 2, ellipsesRadius1_2 *2);
        g2.drawOval(centerX - ellipsesRadius2_1, centerY - ellipsesRadius2_2, ellipsesRadius2_1 * 2, ellipsesRadius2_2 *2);
        g2.drawOval(centerX - ellipsesRadius3_1, centerY - ellipsesRadius3_2, ellipsesRadius3_1 * 2, ellipsesRadius3_2 *2);

        // ---- planet 1 (orbits closer and faster) ----

        int x2 = centerX + (int) (Math.cos(angle2) * ellipsesRadius2_1) - planetSize / 2;
        int y2 = centerY + (int) (Math.sin(angle2) * ellipsesRadius2_2) - planetSize / 2;

        g2.setColor(Color.GREEN);
        g2.fillRect(x2, y2, planetSize, planetSize);

        // ---- Planet 2 (orbits farther out) ----

        int x1 = centerX + (int) (Math.cos(angle1) * ellipsesRadius1_1) - planetSize / 2;
        int y1 = centerY + (int) (Math.sin(angle1) * ellipsesRadius1_2) - planetSize / 2;

        g2.setColor(Color.GREEN);
        g2.fillRect(x1, y1, planetSize, planetSize);

        // MOON (Orbiting planet 2)

        int x3 = x2 + (int) (Math.cos(angle3) * radius3); //- cubeSize / 2;
        int y3 = y2  + (int) (Math.sin(angle3) * radius3); //- cubeSize / 2;

        g2.setColor(Color.GREEN);
        g2.fillRect(x3, y3, moonSize, moonSize);

        // --- MOON Cube 3 (smaller and orbiting cube 2)

        int x5 = x1 + (int) (Math.cos(angle3) * radius4); //- cubeSize / 2;
        int y5 = y1  + (int) (Math.sin(angle3) * radius4); //- cubeSize / 2;

        g2.setColor(Color.GREEN);
        g2.fillRect(x5, y5, moonSize, moonSize);

        // --- MOON Cube 4 (smaller and orbiting cube 1) - closer planet

        int x4 = x1 + (int) (Math.cos(angle2) * radius5); //- cubeSize / 2;
        int y4 = y1  + (int) (Math.sin(angle2) * radius5); //- cubeSize / 2;

        g2.setColor(Color.GREEN);
        g2.fillRect(x4, y4, moonSize, moonSize);

        // ---- Planet 3 (orbits farther out) ----

        int x6 = centerX + (int) (Math.cos(angle4) * ellipsesRadius3_1) - planetSize / 2;
        int y6 = centerY + (int) (Math.sin(angle4) * ellipsesRadius3_2) - planetSize / 2;

        g2.setColor(Color.GREEN);
        g2.fillRect(x6, y6, moonSize, moonSize);

        // Update the angles for next frame
        angle4 += 0.005;  //slowest orbit 0.005
        angle1 += 0.009;   // slower orbit 0.008
        angle2 += 0.01;   // faster orbit 0.01
        angle3 += 0.02;  //fast moon orbit 0.02


        g2.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));

        g2.setColor(Color.GREEN);
        g2.fillRect(centerX - starHalf, centerY - starHalf, starSize, starSize);

        // Label for the star
        g2.drawString("Dwarf", centerX - 15, centerY - starHalf - 8);

        //Label for planets
        g2.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 8));
        g2.drawString("Deneheim", x2 - 15, y2 -8);
        g2.drawString("Jorgsmiur", x1 - 15, y1 -8);
        g2.drawString("Frostbite", x6 - 15, y6 -8);



        // NEED TO REORGANIZE EVERYTHING WITH BETTER NAMES AND STUFF, VARIABLES SEPARATE OF G2 GRAPHICS DRAWING
//        //moons
//        g2.setColor(new Color(0,80,0));
//        g2.drawOval(x1 - radius3, y1 - radius3 , radius3 * 2, radius3 * 2);
//


    }

}
