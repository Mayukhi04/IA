package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class MainMenu extends JPanel implements ActionListener{
    JFrame frame = new JFrame("Main Menu");

    //Main menu GUI
    public MainMenu() throws ParseException {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(375, 265));
        frame.pack();
        frame.setLayout(null);
        frame.getContentPane().removeAll();

        EntryReminder();
        EventReminder();

        JLabel heading = new JLabel("Main menu");
        JLabel underline = new JLabel("----------------");
        heading.setBounds(0,0, 200, 40);
        underline.setBounds(0, 5, 200, 40);
        frame.getContentPane().add(heading);
        frame.getContentPane().add(underline);

        JButton button1 = new JButton("Entries");
        button1.setBounds(0,75, 100, 40);
        button1.addActionListener(this);
        frame.getContentPane().add(button1);

        JButton button2 = new JButton("Events");
        button2.setBounds(0,125, 100, 40);
        button2.addActionListener(this);
        frame.getContentPane().add(button2);

        JButton button3 = new JButton("Exit");
        button3.setBounds(0,175, 100, 40);
        button3.addActionListener(this);
        frame.getContentPane().add(button3);

        frame.setVisible(true);

    }

    //prompts user to write an entry if one has not been written that day
    public void EntryReminder() {
        File entryFile = new File("entries.txt");
        entryFile.readFile();
        int length = entryFile.Length();

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
        String currentDate = formatter.format(date);

        boolean dailyEntry = false;

        JLabel reminder = new JLabel();
        reminder.setBounds(0, 30, 500, 20);
        frame.getContentPane().add(reminder);

        for (int i = 0; i < length; i = i + 4) {
            if (entryFile.readFileLine(i).equals(currentDate)) {
                dailyEntry = true;
            }
        }

        if (!dailyEntry) {
            reminder.setText("Looks like you haven't written an entry today. Write one now!");
        } else {
            reminder.setText("You have already written an entry today. Well done!");
        }
    }

    //reminds the user of any upcoming events
    public void EventReminder() throws ParseException {
        File eventFile = new File("events.txt");
        eventFile.readFile();

        Date currentDate = new Date();

        Calendar cal = Calendar.getInstance();
        cal.setTime(currentDate);
        cal.add(Calendar.DATE, 7);

        Date upcomingDate = cal.getTime();

        int length = eventFile.Length();
        int eventCounter = 0;
        boolean upcomingEvent = false;

        for (int i = 0; i < (length / 4); i++) {
            if (!eventFile.readFileLine(eventCounter).equals("#")) {
                if (new SimpleDateFormat("dd/MM/yy").parse(eventFile.readFileLine(eventCounter)).equals(currentDate)) {
                    if (new SimpleDateFormat("HH:mm").parse(eventFile.readFileLine(eventCounter + 1)).before(currentDate)) {
                        if (eventCounter + 4 != length) {
                            eventCounter = eventCounter + 4;
                        }
                        continue;
                    }
                } else if (new SimpleDateFormat("dd/MM/yy").parse(eventFile.readFileLine(eventCounter)).before(currentDate)) {
                    if (eventCounter + 4 != length) {
                        eventCounter = eventCounter + 4;
                    }
                    continue;
                } else if (new SimpleDateFormat("dd/MM/yy").parse(eventFile.readFileLine(eventCounter)).before(upcomingDate)) {
                    String eventName;
                    if (eventFile.readFileLine(eventCounter + 2).equals("#")) {
                        eventName = "Untitled event";
                    } else {
                        eventName = eventFile.readFileLine(eventCounter + 2);
                    }

                    String eventDate = eventFile.readFileLine(eventCounter);

                    String eventTime = "";
                    if (!eventFile.readFileLine(eventCounter + 1).equals("#")) {
                        eventTime  = " - " + eventFile.readFileLine(eventCounter + 1);
                    }

                    JLabel reminder = new JLabel("Reminder: " + eventName + ", " + eventDate + eventTime);
                    reminder.setBounds(0, 50, 500, 20);
                    frame.getContentPane().add(reminder);
                    upcomingEvent = true;
                }

                if (new SimpleDateFormat("dd/MM/yy").parse(eventFile.readFileLine(eventCounter)).equals(currentDate)) {
                    if (new SimpleDateFormat("HH:mm").parse(eventFile.readFileLine(eventCounter + 1)).before(currentDate)) {
                        if (eventCounter + 4 != length) {
                            eventCounter = eventCounter + 4;
                        }
                        continue;
                    }
                }

            }

            if (eventCounter + 4 != length) {
                eventCounter = eventCounter + 4;
            }

        }

        if (!upcomingEvent) {
            JLabel reminder = new JLabel("No upcoming events");
            reminder.setBounds(0, 50, 500, 20);
            frame.getContentPane().add(reminder);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Entries")) {
            EntryMenu eMenu = new EntryMenu();
        } else if (e.getActionCommand().equals("Events")) {
            EventMenu eMenu = new EventMenu();
        } else if (e.getActionCommand().equals("Exit")) {
            System.exit(0);
        }

        frame.dispose();
    }

}
