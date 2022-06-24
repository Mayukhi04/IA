package com.company;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventMenu extends JPanel implements ActionListener, DocumentListener {
    // canvas for other GUI widgets
    JFrame eventFrame = new JFrame("Event Menu");
    JFrame createEventFrame = new JFrame("Create New Event");
    JFrame viewEventsFrame = new JFrame("View Events");
    File eventFile = new File("events.txt");

    public EventMenu() {
        eventFrame.setPreferredSize(new Dimension(300, 250));
        setLayout(null);
        eventFrame.pack();
        eventFrame.setVisible(true);
        eventFrame.setLayout(null);

        JLabel heading = new JLabel("Event menu");
        JLabel underline = new JLabel("-----------------");
        heading.setBounds(0, 0, 200, 40);
        underline.setBounds(0, 5, 200, 40);
        eventFrame.add(heading);
        eventFrame.add(underline);

        JButton button1 = new JButton("Create a new event");
        button1.setBounds(0, 40, 200, 40);
        button1.addActionListener(this);
        eventFrame.add(button1);

        JButton button2 = new JButton("View all events");
        button2.setBounds(0, 90, 200, 40);
        button2.addActionListener(this);
        eventFrame.add(button2);

        JButton button3 = new JButton("Main menu");
        button3.setBounds(0, 140, 200, 40);
        button3.addActionListener(this);
        eventFrame.add(button3);

    }

    public void createEvent() {
        createEventFrame.setPreferredSize(new Dimension(400, 300));
        setLayout(null);
        createEventFrame.pack();
        createEventFrame.setVisible(true);
        createEventFrame.setLayout(null);

        JLabel heading = new JLabel("Create new event");
        JLabel underline = new JLabel("-------------------------");
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

        JButton create = new JButton ("Create event");
        create.setBounds(250, 90, 125, 30);
        create.addActionListener(this);
        createEventFrame.add(create);

        JButton cancel = new JButton ("Cancel");
        cancel.setBounds(250,135, 125, 30);
        cancel.addActionListener(this);
        createEventFrame.add(cancel);

    }

    public void viewEvents() {
        viewEventsFrame.setPreferredSize(new Dimension(500, 350));
        setLayout(null);
        viewEventsFrame.pack();
        viewEventsFrame.setVisible(true);
        viewEventsFrame.setLayout(null);

        JLabel heading = new JLabel("View events");
        JLabel underline = new JLabel("------------------");
        heading.setBounds(0, 0, 200, 40);
        underline.setBounds(0, 5, 200, 40);
        viewEventsFrame.add(heading);
        viewEventsFrame.add(underline);

        JLabel date = new JLabel("Date");
        date.setBounds(0, 25, 200, 40);
        viewEventsFrame.add(date);

        JLabel time = new JLabel("Time");
        time.setBounds(60, 25, 200, 40);
        viewEventsFrame.add(time);

        JLabel name = new JLabel("Event name");
        name.setBounds(110, 25, 200, 40);
        viewEventsFrame.add(name);

        JLabel Notes = new JLabel("Notes");
        Notes.setBounds(270, 25, 200, 40);
        viewEventsFrame.add(Notes);

        JButton returnToMenu = new JButton("Return to menu");
        returnToMenu.setBounds(0, 260, 125, 40);
        returnToMenu.addActionListener(this);
        viewEventsFrame.add(returnToMenu);

        JButton upcoming = new JButton("Upcoming");
        upcoming.setBounds(300, 265, 95, 30);
        upcoming.addActionListener(this);
        viewEventsFrame.add(upcoming);

        JButton past = new JButton("Past");
        past.setBounds(400, 265, 70, 30);
        past.addActionListener(this);
        viewEventsFrame.add(past);

        displayEvents();
    }

    public void displayEventsWorks() {
        int yCounter = 45;
        File f = new File("events.txt");
        int length = f.Length();

        for (int i = 0; i <length; i++) {
            JLabel label = new JLabel(f.readFileLine(0));
            label.setBounds(0, yCounter, 200, 40);
            viewEventsFrame.add(label);
            yCounter = yCounter + 20;
        }

        yCounter = 45;

        for (int i = 0; i <length; i++) {
            JLabel label = new JLabel(f.readFileLine(1));
            label.setBounds(60, yCounter, 200, 40);
            viewEventsFrame.add(label);
            yCounter = yCounter + 20;
        }

        yCounter = 45;

        for (int i = 0; i <length; i++) {
            JLabel label = new JLabel(f.readFileLine(2));
            label.setBounds(110, yCounter, 1000, 40);
            viewEventsFrame.add(label);
            yCounter = yCounter + 20;
        }

        yCounter = 45;

        for (int i = 0; i <length; i++) {
            JLabel label = new JLabel(f.readFileLine(3));
            label.setBounds(270, yCounter, 1000, 40);
            viewEventsFrame.add(label);
            yCounter = yCounter + 20;
        }

    }

    public void displayEvents() {
        int yCounter = 45;
        File f = new File("events.txt");
        int length = f.Length();
        int eventCounter = 0;

        for (int i = 0; i < length; i++) {
            JLabel date = new JLabel(f.readFileLine(0 + eventCounter));
            date.setBounds(0, yCounter, 200, 40);
            viewEventsFrame.add(date);

            JLabel time = new JLabel(f.readFileLine(1 + eventCounter));
            time.setBounds(60, yCounter, 200, 40);
            viewEventsFrame.add(time);

            JLabel name = new JLabel(f.readFileLine(2 + eventCounter));
            name.setBounds(110, yCounter, 1000, 40);
            viewEventsFrame.add(name);

            JLabel notes = new JLabel(f.readFileLine(3 + eventCounter));
            notes.setBounds(270, yCounter, 1000, 40);
            viewEventsFrame.add(notes);

            yCounter = yCounter + 20;

            if (!f.readFileLine(0 + eventCounter).equals("")) {
                eventCounter = eventCounter + 4;
            }
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        eventFrame.setVisible(false);
        if (e.getActionCommand().equals("Create a new event")) {
            System.out.println("New event!");
            createEvent();
        } else if (e.getActionCommand().equals("View all events")) {
            System.out.println("View events!");
            viewEvents();
        } else if (e.getActionCommand().equals("Main menu")) {
            System.out.println("Main menu!");
        } else if (e.getActionCommand().equals("Create event")) {
            System.out.println("Create event!");
            createEventFrame.setVisible(false);
            eventFrame.setVisible(true);
        } else if (e.getActionCommand().equals("Cancel")) {
            System.out.println("Cancel!");
            createEventFrame.setVisible(false);
            eventFrame.setVisible(true);
        } else if (e.getActionCommand().equals("Return to menu")) {
            System.out.println("Return to menu!");
            viewEventsFrame.setVisible(false);
            eventFrame.setVisible(true);
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
