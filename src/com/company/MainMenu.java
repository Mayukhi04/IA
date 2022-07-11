package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainMenu extends JPanel implements ActionListener{
    // canvas for other GUI widgets

    public MainMenu(int width, int height) throws ParseException {
        System.out.println("SEQUENCE: GUI Constructor");
        this.setPreferredSize(new Dimension(width, height));
        setLayout(null);
        //this.setVisible(true);

        Alert();

        JLabel heading = new JLabel("Main menu");
        JLabel underline = new JLabel("----------------");
        heading.setBounds(0,0, 200, 40);
        underline.setBounds(0, 5, 200, 40);
        add(heading);
        add(underline);

        JButton button1 = new JButton("Entries");
        button1.setBounds(0,55, 100, 40);
        button1.addActionListener(this);
        add(button1);

        JButton button2 = new JButton("Events");
        button2.setBounds(0,105, 100, 40);
        button2.addActionListener(this);
        add(button2);

        JButton button3 = new JButton("Exit");
        button3.setBounds(0,155, 100, 40);
        button3.addActionListener(this);
        add(button3);

    }

    public void Alert() throws ParseException {
        File eventFile = new File("events.txt");
        eventFile.readFile();

        int length = eventFile.Length();
        int eventCounter = 0;
        boolean upcomingEvent = false;

        for (int i = 0; i < (length / 4); i++) {
            if (eventFile.readFileLine(eventCounter).equals("#")) {
                if (eventCounter + 4 != length) {
                    eventCounter = eventCounter + 4;
                }
                continue;
            } else {
                if (new SimpleDateFormat("dd/MM/yy").parse(eventFile.readFileLine(eventCounter)).equals(new Date())){
                    if (new SimpleDateFormat("HH:mm").parse(eventFile.readFileLine(eventCounter + 1)).before(new Date())) {
                        if (eventCounter + 4 != length) {
                            eventCounter = eventCounter + 4;
                        }
                        continue;
                    }
                } else if (new SimpleDateFormat("dd/MM/yy").parse(eventFile.readFileLine(eventCounter)).before(new Date())) {
                    if (eventCounter + 4 != length) {
                        eventCounter = eventCounter + 4;
                    }
                    continue;
                } else {
                    JLabel reminder = new JLabel("Reminder: " + eventFile.readFileLine(eventCounter + 2) + ", " +  eventFile.readFileLine(eventCounter) + " - "  +  eventFile.readFileLine(eventCounter + 1));
                    reminder.setBounds(0, 30, 500, 20);
                    add(reminder);
                    upcomingEvent = true;
                }

                if (new SimpleDateFormat("dd/MM/yy").parse(eventFile.readFileLine(eventCounter)).equals(new Date())){
                    if (new SimpleDateFormat("HH:mm").parse(eventFile.readFileLine(eventCounter + 1)).before(new Date())) {
                        if (eventCounter + 4 != length) {
                            eventCounter = eventCounter + 4;
                        }
                        continue;
                    }
                }

                if (eventCounter + 4 != length) {
                    eventCounter = eventCounter + 4;
                }
            }

        }

        if (!upcomingEvent) {
            JLabel reminder = new JLabel("No upcoming events");
            reminder.setBounds(0, 30, 500, 20);
            add(reminder);
        }
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
