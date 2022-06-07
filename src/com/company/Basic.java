package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.Color.green;

public class Basic extends JPanel implements ActionListener {

    private JFrame frame;
    private JButton makeGreen;
    private String colour = "red";

    public Basic(int width, int height) {
        // initialise the window
        frame = new JFrame("Demo");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(width, height);

        // create the canvas that will hold the actual graphics
        frame.getContentPane().add(this);

        makeGreen = new JButton("make green");
        makeGreen.setBounds(0,40, 100, 40);
        makeGreen.addActionListener(this);
        add(makeGreen);

        this.repaint();

        // display the frame AFTER adding the panel to prevent drawing glitches
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "make green") {
//            Graphics g = null;
//            this.makeGreen(Graphics g);
            System.out.println("click");
            colour = "green";
        }

    }

    @Override
    public void paintComponent(Graphics g) {
        int left = 50;    // hard-coded just for testing
        int top = 80;
        int width = 40;
        int height = 150;
        if (colour.equals("Green")) {
            g.setColor(Color.green);
        } else {
            g.setColor(Color.red);
        }

        g.fillRect(left, top, width, height);
    }

    public void makeGreen(Graphics g) {
        int left = 50;    // hard-coded just for testing
        int top = 80;
        int width = 40;
        int height = 150;
        g.setColor(green);
        g.fillRect(left, top, width, height);
    }

}
