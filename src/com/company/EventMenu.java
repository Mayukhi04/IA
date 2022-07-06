package com.company;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class EventMenu extends JPanel implements ActionListener, DocumentListener {
    // canvas for other GUI widgets
    JFrame eventFrame = new JFrame("Event Menu");
    JFrame createEventFrame = new JFrame("Create New Event");
    JFrame viewEventsFrame = new JFrame("View Events");
    File eventFile = new File("events.txt");

    String eventStatus = "all";

    JTextField title = new JTextField();
    JTextField date = new JTextField();
    JTextField time = new JTextField();
    JTextField notes = new JTextField();

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
        eventFrame.getContentPane().add(heading);
        eventFrame.getContentPane().add(underline);

        JButton button1 = new JButton("Create a new event");
        button1.setBounds(0, 40, 200, 40);
        button1.addActionListener(this);
        eventFrame.getContentPane().add(button1);

        JButton button2 = new JButton("View all events");
        button2.setBounds(0, 90, 200, 40);
        button2.addActionListener(this);
        eventFrame.getContentPane().add(button2);

        JButton button3 = new JButton("Main menu");
        button3.setBounds(0, 140, 200, 40);
        button3.addActionListener(this);
        eventFrame.getContentPane().add(button3);

    }

    public void createEventMenu() {
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
        title.setBounds(40,45, 200, 30);
        title.getDocument().addDocumentListener(this);
        createEventFrame.add(title);

        JLabel label2 = new JLabel("Date: ");
        label2.setBounds(0,85, 50, 40);
        createEventFrame.add(label2);
        date.setBounds(40,90, 80, 30);
        date.getDocument().addDocumentListener(this);
        createEventFrame.add(date);

        JLabel label3 = new JLabel("Time: ");
        label3.setBounds(125,85, 50, 40);
        createEventFrame.add(label3);
        time.setBounds(160,90, 80, 30);
        time.getDocument().addDocumentListener(this);
        createEventFrame.add(time);

        JLabel label4 = new JLabel("Notes: ");
        label4.setBounds(0,130, 50, 40);
        createEventFrame.add(label4);
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

    public void createEvent() {
        String[]eventDetails = new String[4];

        eventDetails[0] = date.getText();
        eventDetails[1] = time.getText();
        eventDetails[2] = title.getText();
        eventDetails[3] = notes.getText();

        for (int i = 0; i < 4; i++) {
            if (eventDetails[i].equals("")) {
                eventFile.write("#");
            } else {
                eventFile.write(eventDetails[i]);
            }
        }

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
        viewEventsFrame.getContentPane().add(heading);
        viewEventsFrame.getContentPane().add(underline);

        JLabel date = new JLabel("Date");
        date.setBounds(0, 25, 200, 40);
        viewEventsFrame.getContentPane().add(date);

        JLabel time = new JLabel("Time");
        time.setBounds(60, 25, 200, 40);
        viewEventsFrame.getContentPane().add(time);

        JLabel name = new JLabel("Event name");
        name.setBounds(110, 25, 200, 40);
        viewEventsFrame.getContentPane().add(name);

        JLabel Notes = new JLabel("Notes");
        Notes.setBounds(270, 25, 200, 40);
        viewEventsFrame.getContentPane().add(Notes);

        JButton returnToMenu = new JButton("Return to menu");
        returnToMenu.setBounds(0, 260, 125, 40);
        returnToMenu.addActionListener(this);
        viewEventsFrame.getContentPane().add(returnToMenu);

        JButton all = new JButton("All");
        all.setBounds(225, 265, 70, 30);
        all.addActionListener(this);
        viewEventsFrame.getContentPane().add(all);

        JButton upcoming = new JButton("Upcoming");
        upcoming.setBounds(300, 265, 95, 30);
        upcoming.addActionListener(this);
        viewEventsFrame.getContentPane().add(upcoming);

        JButton past = new JButton("Past");
        past.setBounds(400, 265, 70, 30);
        past.addActionListener(this);
        viewEventsFrame.getContentPane().add(past);

    }

    public void displayEvents() throws ParseException {
        eventFile.readFile();

        Date d = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
        String currentDate = formatter.format(d);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
        LocalDateTime now = LocalDateTime.now();
        String currentTime = dtf.format(now);

        int yCounter = 45;
        int length = eventFile.Length();
        int eventCounter = 0;

        for (int i = 0; i < (length / 4); i++) {
            JLabel date = new JLabel(eventFile.readFileLine(eventCounter));
            JLabel time = new JLabel(eventFile.readFileLine(eventCounter + 1));

            if (eventStatus.equals("upcoming")) {
                if (new SimpleDateFormat("dd/MM/yy").parse(eventFile.readFileLine(eventCounter)).equals(d)){
                    if (new SimpleDateFormat("HH:mm").parse(eventFile.readFileLine(eventCounter + 1)).before(d)) {
                        if (eventCounter + 4 != length) {
                            eventCounter = eventCounter + 4;
                        }
                        continue;
                    }
                } else if (new SimpleDateFormat("dd/MM/yy").parse(eventFile.readFileLine(eventCounter)).before(d)) {
                    if (eventCounter + 4 != length) {
                        eventCounter = eventCounter + 4;
                    }
                    continue;
                }

                if (new SimpleDateFormat("dd/MM/yy").parse(eventFile.readFileLine(eventCounter)).equals(d)){
                    if (new SimpleDateFormat("HH:mm").parse(eventFile.readFileLine(eventCounter + 1)).before(d)) {
                        if (eventCounter + 4 != length) {
                            eventCounter = eventCounter + 4;
                        }
                        continue;
                    }
                }
            } else if (eventStatus.equals("past")) {
                if (!(new SimpleDateFormat("dd/MM/yy").parse(eventFile.readFileLine(eventCounter)).before(d))) {
                    if (eventCounter + 4 != length) {
                        eventCounter = eventCounter + 4;
                    }
                    continue;
//                } else if (new SimpleDateFormat("HH:mm").parse(currentTime).before(new Date())) {
//                    continue;
                }
            }

            date.setBounds(0, yCounter, 200, 40);
            viewEventsFrame.getContentPane().add(date);

            time.setBounds(60, yCounter, 200, 40);
            viewEventsFrame.getContentPane().add(time);

            JLabel name = new JLabel(eventFile.readFileLine(eventCounter + 2));
            name.setBounds(110, yCounter, 1000, 40);
            viewEventsFrame.getContentPane().add(name);

            JLabel notes = new JLabel(eventFile.readFileLine(eventCounter + 3));
            notes.setBounds(270, yCounter, 1000, 40);
            viewEventsFrame.getContentPane().add(notes);

            yCounter = yCounter + 20;

            if (eventCounter + 4 != length) {
                eventCounter = eventCounter + 4;
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        eventFrame.setVisible(false);
        if (e.getActionCommand().equals("Create a new event")) {
            createEventMenu();
        } else if (e.getActionCommand().equals("View all events")) {
            viewEvents();
            try {
                displayEvents();
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
        } else if (e.getActionCommand().equals("Main menu")) {
        } else if (e.getActionCommand().equals("Create event")) {
            createEvent();
            createEventFrame.setVisible(false);
            eventFrame.setVisible(true);
        } else if (e.getActionCommand().equals("Cancel")) {
            createEventFrame.setVisible(false);
            eventFrame.setVisible(true);
        } else if (e.getActionCommand().equals("Return to menu")) {
            viewEventsFrame.setVisible(false);
            eventFrame.setVisible(true);
        } else if (e.getActionCommand().equals("All")) {
            eventStatus = "all";
            viewEventsFrame.getContentPane().removeAll();
            viewEventsFrame.getContentPane().revalidate();
            viewEventsFrame.getContentPane().repaint();
            viewEvents();
            try {
                displayEvents();
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
        } else if (e.getActionCommand().equals("Upcoming")) {
            eventStatus = "upcoming";
            viewEventsFrame.getContentPane().removeAll();
            viewEventsFrame.getContentPane().revalidate();
            viewEventsFrame.getContentPane().repaint();
            viewEvents();
            try {
                displayEvents();
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
        } else if (e.getActionCommand().equals("Past")) {
            eventStatus = "past";
            viewEventsFrame.getContentPane().removeAll();
            viewEventsFrame.getContentPane().revalidate();
            viewEventsFrame.getContentPane().repaint();
            viewEvents();
            try {
                displayEvents();
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
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
