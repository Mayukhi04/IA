package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JPanel implements ActionListener{
    // canvas for other GUI widgets

    public MainMenu(int width, int height) {
        System.out.println("SEQUENCE: GUI Constructor");
        this.setPreferredSize(new Dimension(width, height));
        setLayout(null);
        //this.setVisible(true);

        JLabel heading = new JLabel("Main menu");
        JLabel underline = new JLabel("----------------");
        heading.setBounds(0,0, 200, 40);
        underline.setBounds(0, 5, 200, 40);
        add(heading);
        add(underline);


        JButton button1 = new JButton("Entries");
        button1.setBounds(0,40, 100, 40);
        button1.addActionListener(this);
        add(button1);

        JButton button2 = new JButton("Events");
        button2.setBounds(0,90, 100, 40);
        button2.addActionListener(this);
        add(button2);

        JButton button3 = new JButton("Exit");
        button3.setBounds(0,140, 100, 40);
        button3.addActionListener(this);
        add(button3);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //this.setVisible(false);
        if (e.getActionCommand().equals("Entries")) {
            EntryMenu eMenu = new EntryMenu();
        } else if (e.getActionCommand().equals("Events")) {
            EventMenu eMenu = new EventMenu();
        } else if (e.getActionCommand().equals("Exit")) {
            System.exit(0);
        }

    }

}
