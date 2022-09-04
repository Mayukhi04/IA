package com.company;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EventMenu extends JPanel implements ActionListener, DocumentListener {
    JFrame eventFrame = new JFrame("Event Menu");
    JFrame createEventFrame = new JFrame("Create New Event");
    JFrame editEventFrame = new JFrame("Edit/Delete Events");
    JFrame viewEventsFrame = new JFrame("View Events");
    File eventFile = new File("events.txt");

    //used when user selects to view upcoming, past or all events
    String eventStatus = "all";

    JTextField title = new JTextField();
    JTextField date = new JTextField();
    JTextField time = new JTextField();
    JTextField notes = new JTextField();
    JTextField eventName = new JTextField();

    //Event menu GUI
    public EventMenu() {
        eventFrame.setPreferredSize(new Dimension(300, 280));
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

        JButton button3 = new JButton("Edit or delete an event");
        button3.setBounds(0, 140, 200, 40);
        button3.addActionListener(this);
        eventFrame.add(button3);

        JButton button4 = new JButton("Main menu");
        button4.setBounds(0, 190, 200, 40);
        button4.addActionListener(this);
        eventFrame.getContentPane().add(button4);

    }

    //Create event menu GUI
    public void createEventMenu() {
        createEventFrame.setPreferredSize(new Dimension(400, 300));
        createEventFrame.pack();
        createEventFrame.setVisible(true);
        createEventFrame.setLayout(null);
        createEventFrame.getContentPane().removeAll();

        JLabel heading = new JLabel("Create new event");
        JLabel underline = new JLabel("-------------------------");
        heading.setBounds(0, 0, 200, 40);
        underline.setBounds(0, 5, 200, 40);
        createEventFrame.getContentPane().add(heading);
        createEventFrame.getContentPane().add(underline);

        JLabel label1 = new JLabel("Title: ");
        label1.setBounds(0,40, 50, 40);
        createEventFrame.getContentPane().add(label1);
        title.setBounds(40,45, 200, 30);
        title.getDocument().addDocumentListener(this);
        createEventFrame.getContentPane().add(title);

        JLabel label2 = new JLabel("Date: ");
        label2.setBounds(0,85, 50, 40);
        createEventFrame.getContentPane().add(label2);
        date.setBounds(40,90, 80, 30);
        date.getDocument().addDocumentListener(this);
        createEventFrame.getContentPane().add(date);

        JLabel label3 = new JLabel("Time: ");
        label3.setBounds(125,85, 50, 40);
        createEventFrame.getContentPane().add(label3);
        time.setBounds(160,90, 80, 30);
        time.getDocument().addDocumentListener(this);
        createEventFrame.getContentPane().add(time);

        JLabel label4 = new JLabel("Notes: ");
        label4.setBounds(0,130, 50, 40);
        createEventFrame.getContentPane().add(label4);
        notes.setBounds(40,135, 200, 80);
        notes.getDocument().addDocumentListener(this);
        createEventFrame.getContentPane().add(notes);

        JButton create = new JButton ("Create event");
        create.setBounds(250, 90, 125, 30);
        create.addActionListener(this);
        createEventFrame.getContentPane().add(create);

        JButton cancel = new JButton ("Cancel");
        cancel.setBounds(250,135, 125, 30);
        cancel.addActionListener(this);
        createEventFrame.getContentPane().add(cancel);

    }

    //creates event entered by user
    public void createEvent() {
        String[] eventDetails = new String[4];
        eventDetails[0] = date.getText();
        eventDetails[1] = time.getText();
        eventDetails[2] = title.getText();
        eventDetails[3] = notes.getText();

        Event e = new Event();
        e.create(eventDetails);
    }

    //edit or delete event menu GUI
    public void editOrDeleteEventMenu() {
        editEventFrame.setPreferredSize(new Dimension(300, 250));
        editEventFrame.setLayout(null);
        editEventFrame.pack();
        editEventFrame.setVisible(true);
        editEventFrame.getContentPane().removeAll();

        JLabel heading = new JLabel("Edit or delete an event");
        JLabel underline = new JLabel("--------------------------------");
        heading.setBounds(0, 0, 200, 40);
        underline.setBounds(0, 5, 200, 40);
        editEventFrame.getContentPane().add(heading);
        editEventFrame.getContentPane().add(underline);

        JLabel name = new JLabel("Event name:");
        name.setBounds(0,40, 75, 40);
        editEventFrame.getContentPane().add(name);

        eventName.setBounds(80,45, 150, 30);
        eventName.getDocument().addDocumentListener(this);
        editEventFrame.getContentPane().add(eventName);

        JButton e = new JButton("Edit");
        e.setBounds(0, 100, 125, 40);
        e.addActionListener(this);
        editEventFrame.getContentPane().add(e);

        JButton d = new JButton("Delete");
        d.setBounds(135, 100, 125, 40);
        d.addActionListener(this);
        editEventFrame.getContentPane().add(d);

        JButton m = new JButton("Cancel");
        m.setBounds(0, 150, 125, 40);
        m.addActionListener(this);
        editEventFrame.getContentPane().add(m);

    }

    //edit event menu GUI
    public void editEventMenu() {
        editEventFrame.setPreferredSize(new Dimension(400, 300));
        editEventFrame.pack();
        editEventFrame.setVisible(true);
        editEventFrame.setLayout(null);

        JLabel heading = new JLabel("Edit event");
        JLabel underline = new JLabel("---------------");
        heading.setBounds(0, 0, 200, 40);
        underline.setBounds(0, 5, 200, 40);
        editEventFrame.getContentPane().add(heading);
        editEventFrame.getContentPane().add(underline);

        JLabel label1 = new JLabel("Title: ");
        label1.setBounds(0,40, 50, 40);
        editEventFrame.getContentPane().add(label1);
        title.setBounds(40,45, 200, 30);
        title.getDocument().addDocumentListener(this);
        editEventFrame.getContentPane().add(title);

        JLabel label2 = new JLabel("Date: ");
        label2.setBounds(0,85, 50, 40);
        editEventFrame.getContentPane().add(label2);
        date.setBounds(40,90, 80, 30);
        date.getDocument().addDocumentListener(this);
        editEventFrame.getContentPane().add(date);

        JLabel label3 = new JLabel("Time: ");
        label3.setBounds(125,85, 50, 40);
        editEventFrame.getContentPane().add(label3);
        time.setBounds(160,90, 80, 30);
        time.getDocument().addDocumentListener(this);
        editEventFrame.getContentPane().add(time);

        JLabel label4 = new JLabel("Notes: ");
        label4.setBounds(0,130, 50, 40);
        editEventFrame.getContentPane().add(label4);
        notes.setBounds(40,135, 200, 80);
        notes.getDocument().addDocumentListener(this);
        editEventFrame.getContentPane().add(notes);

        JButton create = new JButton ("Update event");
        create.setBounds(250, 90, 125, 30);
        create.addActionListener(this);
        editEventFrame.getContentPane().add(create);

        JButton cancel = new JButton ("Cancel");
        cancel.setBounds(250,135, 125, 30);
        cancel.addActionListener(this);
        editEventFrame.getContentPane().add(cancel);

    }

    //updates event chosen by user
    public void updateEvent() throws FileNotFoundException {
        String[] eventDetails = new String[4];
        eventDetails[0] = date.getText();
        eventDetails[1] = time.getText();
        eventDetails[2] = title.getText();
        eventDetails[3] = notes.getText();

        Event e = new Event();
        e.updateEvent(eventName.getText(), eventDetails);
    }

    //deletes event chosen by user
    public void deleteEvent() {
        Event myEvent = new Event();

        try {
            myEvent.deleteEvent(eventName.getText());
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }

    //view events menu GUI
    public void viewEventsMenu() {
        viewEventsFrame.setPreferredSize(new Dimension(500, 350));
        viewEventsFrame.pack();
        viewEventsFrame.setVisible(true);
        viewEventsFrame.setLayout(null);
        viewEventsFrame.getContentPane().removeAll();

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

    //displays events depending on if the user has chosen to view all, upcoming or past events
    public void displayEvents() throws ParseException {
        eventFile.readFile();

        int yCounter = 45;
        int length = eventFile.Length();
        int eventCounter = 0;

        for (int i = 0; i < (length / 4); i++) {
            JLabel date = new JLabel(eventFile.readFileLine(eventCounter));
            JLabel time = new JLabel(eventFile.readFileLine(eventCounter + 1));

            //displays upcoming events
            if (eventStatus.equals("upcoming")) {
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
                    }

                    if (new SimpleDateFormat("dd/MM/yy").parse(eventFile.readFileLine(eventCounter)).equals(new Date())){
                        if (new SimpleDateFormat("HH:mm").parse(eventFile.readFileLine(eventCounter + 1)).before(new Date())) {
                            if (eventCounter + 4 != length) {
                                eventCounter = eventCounter + 4;
                            }
                            continue;
                        }
                    }
                }

                //displays past events
            } else if (eventStatus.equals("past")) {
                if (eventFile.readFileLine(eventCounter).equals("#")) {
                    if (eventCounter + 4 != length) {
                        eventCounter = eventCounter + 4;
                    }
                    continue;
                } else {
                    if (!(new SimpleDateFormat("dd/MM/yy").parse(eventFile.readFileLine(eventCounter)).before(new Date()))) {
                        if (eventCounter + 4 != length) {
                            eventCounter = eventCounter + 4;
                        }
                        continue;
                    }
                }

            }

            if (!eventFile.readFileLine(eventCounter).equals("#")) {
                date.setBounds(0, yCounter, 200, 40);
                viewEventsFrame.getContentPane().add(date);
            }

            if (!eventFile.readFileLine(eventCounter + 1).equals("#")) {
                time.setBounds(60, yCounter, 200, 40);
                viewEventsFrame.getContentPane().add(time);
            }

            JLabel name = new JLabel(eventFile.readFileLine(eventCounter + 2));
            if (!eventFile.readFileLine(eventCounter + 2).equals("#")) {
                name.setBounds(110, yCounter, 1000, 40);
                viewEventsFrame.getContentPane().add(name);
            }

            JLabel notes = new JLabel(eventFile.readFileLine(eventCounter + 3));
            if (!eventFile.readFileLine(eventCounter + 3).equals("#")) {
                notes.setBounds(270, yCounter, 1000, 40);
                viewEventsFrame.getContentPane().add(notes);
            }

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
            viewEventsMenu();
            try {
                displayEvents();
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
        } else if (e.getActionCommand().equals("Edit or delete an event")) {
            eventFrame.setVisible(false);
            editEventFrame.setVisible(true);
            editOrDeleteEventMenu();
        } else if (e.getActionCommand().equals("Main menu")) {
            eventFrame.dispose();
            try {
                MainMenu menu = new MainMenu();
            } catch (ParseException ex) {
                throw new RuntimeException(ex);
            }
        } else if (e.getActionCommand().equals("Create event")) {
            createEvent();
            createEventFrame.setVisible(false);
            eventFrame.setVisible(true);
        } else if (e.getActionCommand().equals("Cancel")) {
            createEventFrame.setVisible(false);
            eventFrame.setVisible(true);
            editEventFrame.setVisible(false);
        } else if (e.getActionCommand().equals("Edit")) {
            editEventFrame.getContentPane().removeAll();
            editEventFrame.getContentPane().revalidate();
            editEventFrame.getContentPane().repaint();
            editEventMenu();
        } else if (e.getActionCommand().equals("Update event")) {
            try {
                updateEvent();
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
            editEventFrame.setVisible(false);
            eventFrame.setVisible(true);
        } else if (e.getActionCommand().equals("Delete")) {
            deleteEvent();
            editEventFrame.setVisible(false);
            eventFrame.setVisible(true);
        } else if (e.getActionCommand().equals("Return to menu")) {
            createEventFrame.setVisible(false);
            editEventFrame.setVisible(false);
            viewEventsFrame.setVisible(false);
            eventFrame.setVisible(true);
        } else if (e.getActionCommand().equals("All")) {
            eventStatus = "all";
            viewEventsFrame.getContentPane().removeAll();
            viewEventsFrame.getContentPane().revalidate();
            viewEventsFrame.getContentPane().repaint();
            viewEventsMenu();
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
            viewEventsMenu();
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
            viewEventsMenu();
            try {
                displayEvents();
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void insertUpdate(DocumentEvent e) {}

    @Override
    public void removeUpdate(DocumentEvent e) {}

    @Override
    public void changedUpdate(DocumentEvent e) {}

}
