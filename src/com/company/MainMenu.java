package com.company;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JPanel implements ActionListener, DocumentListener{
    // canvas for other GUI widgets
    JButton button1;
    JButton button2;

    public MainMenu(int width, int height) {
        System.out.println("SEQUENCE: GUI Constructor");
        this.setPreferredSize(new Dimension(width, height));
        setLayout(null);

        JLabel heading = new JLabel("Main menu");
        JLabel underline = new JLabel("----------------");
        heading.setBounds(0,0, 200, 40);
        underline.setBounds(0, 5, 200, 40);
        add(heading);
        add(underline);

        button1 = new JButton("Entries");
        button1.setBounds(0,40, 100, 40);
        button2 = new JButton("Events");
        button2.setBounds(0,90, 100, 40);
        button1.addActionListener(this);
        button2.addActionListener(this);
        add(button1);
        add(button2);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "B1") {
            System.out.println("1st button");
        } else if (e.getActionCommand() == "B2"){
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
