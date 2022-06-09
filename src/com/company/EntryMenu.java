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

    public EntryMenu() {
        JFrame frame = new JFrame("Demo Frame");
        frame.setPreferredSize(new Dimension(300, 150));
        setLayout(null);
        frame.pack();
        frame.setVisible(true);

        JLabel heading = new JLabel("Entry menu");
        JLabel underline = new JLabel("-------------------");
        heading.setBounds(0, 0, 200, 40);
        underline.setBounds(0, 5, 200, 40);
        add(heading);
        add(underline);

        button1 = new JButton("Entries");
        button1.setBounds(0, 40, 100, 40);
        button2 = new JButton("Events");
        button2.setBounds(0, 90, 100, 40);
        button1.addActionListener(this);
        button2.addActionListener(this);
        add(button1);
        add(button2);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "B1") {
            System.out.println("B1");
        } else if (e.getActionCommand() == "B2") {
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

