package com.company;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EntryMenu extends JPanel implements ActionListener, DocumentListener {
    // canvas for other GUI widgets
    JFrame frame = new JFrame("Entry Menu");
    JButton button1;
    JButton button2;
    JButton button3;

    public EntryMenu() {
        frame.setPreferredSize(new Dimension(300, 250));
        setLayout(null);
        frame.pack();
        frame.setVisible(true);
        frame.setLayout(null);

        JLabel heading = new JLabel("Entry menu");
        JLabel underline = new JLabel("-----------------");
        heading.setBounds(0, 0, 200, 40);
        underline.setBounds(0, 5, 200, 40);
        frame.add(heading);
        frame.add(underline);

        button1 = new JButton("Write a new entry");
        button1.setBounds(0, 40, 200, 40);
        button2 = new JButton("View previous entries");
        button2.setBounds(0, 90, 200, 40);
        button3 = new JButton("Main menu");
        button3.setBounds(0, 140, 200, 40);
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        frame.add(button1);
        frame.add(button2);
        frame.add(button3);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.setVisible(false);
        if (e.getActionCommand().equals("Write a new entry")) {
            System.out.println("New entry!");
        } else if (e.getActionCommand().equals("View previous entries")) {
            System.out.println("Previous entries!");
        } else if (e.getActionCommand().equals("Main menu")) {
            System.out.println("Main menu!");
        }
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        System.out.println("insert");
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        System.out.println("removed");
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        System.out.println("changed");
    }

}

