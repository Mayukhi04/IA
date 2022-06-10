package com.company;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EntryMenu extends JPanel implements ActionListener, DocumentListener {
    // canvas for other GUI widgets
    JButton button1;
    JButton button2;
    JButton button3;

    public EntryMenu() {
        JFrame frame = new JFrame("Demo Frame");
        frame.setPreferredSize(new Dimension(300, 150));
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
        if (e.getActionCommand().equals("B1")) {
            System.out.println("B1");
        } else if (e.getActionCommand().equals("B2")) {
            System.out.println("click! " + e.getActionCommand());
        } else if (e.getActionCommand().equals("Graph results")) {
            System.out.println("click");
            Basic test = new Basic(300, 300);
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

