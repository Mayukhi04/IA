package com.company;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventMenu extends JPanel implements ActionListener, DocumentListener {
    // canvas for other GUI widgets
    JFrame mainFrame = new JFrame("Demo Frame");
    JButton button1;
    JButton button2;
    JButton button3;

    public EventMenu() {
        mainFrame.setPreferredSize(new Dimension(300, 250));
        setLayout(null);
        mainFrame.pack();
        mainFrame.setVisible(true);
        mainFrame.setLayout(null);

        JLabel heading = new JLabel("Event menu");
        JLabel underline = new JLabel("-----------------");
        heading.setBounds(0, 0, 200, 40);
        underline.setBounds(0, 5, 200, 40);
        mainFrame.add(heading);
        mainFrame.add(underline);

        button1 = new JButton("Create a new event");
        button1.setBounds(0, 40, 200, 40);
        button2 = new JButton("View all events");
        button2.setBounds(0, 90, 200, 40);
        button3 = new JButton("Main menu");
        button3.setBounds(0, 140, 200, 40);
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        mainFrame.add(button1);
        mainFrame.add(button2);
        mainFrame.add(button3);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        mainFrame.setVisible(false);
        if (e.getActionCommand().equals("Create a new event")) {
            System.out.println("New event!");
            createEvent();
        } else if (e.getActionCommand().equals("View all events")) {
            System.out.println("View events!");
        } else if (e.getActionCommand().equals("Main menu")) {
            System.out.println("Main menu!");
        }
    }

    public void createEvent() {
        JFrame createEventFrame = new JFrame("Demo Frame");
        createEventFrame.setPreferredSize(new Dimension(400, 300));
        setLayout(null);
        createEventFrame.pack();
        createEventFrame.setVisible(true);
        createEventFrame.setLayout(null);

        JLabel heading = new JLabel("Create new event");
        JLabel underline = new JLabel("------------------------");
        heading.setBounds(0, 0, 200, 40);
        underline.setBounds(0, 5, 200, 40);
        createEventFrame.add(heading);
        createEventFrame.add(underline);

        JLabel label1 = new JLabel("Title: ");
        label1.setBounds(0,40, 50, 40);
        createEventFrame.add(label1);
        JTextField title = new JTextField();
        title.setBounds(40,45, 200, 30);
        title.getDocument().addDocumentListener(this);
        createEventFrame.add(title);

        JLabel label2 = new JLabel("Date: ");
        label2.setBounds(0,85, 50, 40);
        createEventFrame.add(label2);
        JTextField date = new JTextField();
        date.setBounds(40,90, 80, 30);
        date.getDocument().addDocumentListener(this);
        createEventFrame.add(date);

        JLabel label3 = new JLabel("Time: ");
        label3.setBounds(125,85, 50, 40);
        createEventFrame.add(label3);
        JTextField time = new JTextField();
        time.setBounds(160,90, 80, 30);
        time.getDocument().addDocumentListener(this);
        createEventFrame.add(time);

        JLabel label4 = new JLabel("Notes: ");
        label4.setBounds(0,130, 50, 40);
        createEventFrame.add(label4);
        JTextField notes = new JTextField();
        notes.setBounds(40,135, 200, 80);
        notes.getDocument().addDocumentListener(this);
        createEventFrame.add(notes);

        JLabel label5 = new JLabel("Create event: ");
        label5.setBounds(0,130, 50, 40);
        createEventFrame.add(label5);
        JTextField create = new JTextField();
        create.setBounds(40,135, 200, 80);
        create.getDocument().addDocumentListener(this);
        createEventFrame.add(create);

        JLabel label6 = new JLabel("Cancel: ");
        label6.setBounds(0,130, 50, 40);
        createEventFrame.add(label6);
        JTextField cancel = new JTextField();
        cancel.setBounds(40,135, 200, 80);
        cancel.getDocument().addDocumentListener(this);
        createEventFrame.add(cancel);

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
