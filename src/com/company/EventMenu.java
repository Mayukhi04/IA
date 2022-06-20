package com.company;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventMenu extends JPanel implements ActionListener, DocumentListener {
    // canvas for other GUI widgets
    JFrame frame = new JFrame("Demo Frame");
    JButton button1;
    JButton button2;
    JButton button3;

    public EventMenu() {
        frame.setPreferredSize(new Dimension(300, 250));
        setLayout(null);
        frame.pack();
        frame.setVisible(true);
        frame.setLayout(null);

        JLabel heading = new JLabel("Event menu");
        JLabel underline = new JLabel("-----------------");
        heading.setBounds(0, 0, 200, 40);
        underline.setBounds(0, 5, 200, 40);
        frame.add(heading);
        frame.add(underline);

        button1 = new JButton("Write a new event");
        button1.setBounds(0, 40, 200, 40);
        button2 = new JButton("View all events");
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
        if (e.getActionCommand().equals("Write a new event")) {
            System.out.println("click!");
            writeEvent();
        } else if (e.getActionCommand().equals("View all events")) {
            System.out.println("click!");
        } else if (e.getActionCommand().equals("Main menu")) {
            System.out.println("click!");
            JFrame frame = new JFrame("Demo Frame");
            MainMenu menu = new MainMenu(300, 150);
            frame.add(menu);
            frame.pack();
            frame.setVisible(true);
        }
    }

    public void writeEvent() {
        removeAll();
        repaint();

        JLabel label1 = new JLabel("Title: ");
        label1.setBounds(0,40, 200, 40);
        add(label1);
        JTextField title = new JTextField();
        title.setBounds(10,40, 200, 40);
        title.getDocument().addDocumentListener(this);
        add(title);

        JLabel label2 = new JLabel("Date: ");
        label1.setBounds(0,90, 200, 40);
        add(label2);
        JTextField date = new JTextField();
        date.setBounds(10,90, 200, 40);
        date.getDocument().addDocumentListener(this);
        add(date);

        JLabel label3 = new JLabel("Notes: ");
        label1.setBounds(0,140, 200, 40);
        add(label3);
        JTextField notes = new JTextField();
        notes.setBounds(10,140, 200, 40);
        notes.getDocument().addDocumentListener(this);
        add(notes);

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
