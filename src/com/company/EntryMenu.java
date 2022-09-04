package com.company;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

public class EntryMenu extends JPanel implements ActionListener, DocumentListener {
    JFrame entryFrame = new JFrame("Entry Menu");
    JFrame writeEntryFrame = new JFrame("Create Entry");
    JFrame viewEntriesFrame = new JFrame("View Entries");

    File entryFile = new File("entries.txt");
    JTextField mood = new JTextField();
    JTextField entry = new JTextField();

    //Entry menu GUI
    public EntryMenu() {
        entryFrame.setPreferredSize(new Dimension(300, 230));
        entryFrame.pack();
        entryFrame.setVisible(true);
        entryFrame.setLayout(null);

        JLabel heading = new JLabel("Entry menu");
        JLabel underline = new JLabel("-----------------");
        heading.setBounds(0, 0, 200, 40);
        underline.setBounds(0, 5, 200, 40);
        entryFrame.add(heading);
        entryFrame.add(underline);

        JButton button1 = new JButton("Write a new entry");
        button1.setBounds(0, 40, 200, 40);
        button1.addActionListener(this);
        entryFrame.add(button1);

        JButton button2 = new JButton("View previous entries");
        button2.setBounds(0, 90, 200, 40);
        button2.addActionListener(this);
        entryFrame.add(button2);

        JButton button3 = new JButton("Main menu");
        button3.setBounds(0, 140, 200, 40);
        button3.addActionListener(this);
        entryFrame.add(button3);

    }

    //write entry menu GUI
    public void writeEntryMenu() {
        writeEntryFrame.setPreferredSize(new Dimension(400, 300));
        writeEntryFrame.pack();
        writeEntryFrame.setVisible(true);
        writeEntryFrame.setLayout(null);

        JLabel heading = new JLabel("Write an entry");
        JLabel underline = new JLabel("--------------------");
        heading.setBounds(0, 0, 200, 40);
        underline.setBounds(0, 5, 200, 40);
        writeEntryFrame.add(heading);
        writeEntryFrame.add(underline);

        JLabel label1 = new JLabel("Mood: ");
        label1.setBounds(0,40, 50, 40);
        writeEntryFrame.add(label1);
        mood.setBounds(40,45, 200, 30);
        mood.getDocument().addDocumentListener(this);
        writeEntryFrame.add(mood);

        JLabel label2 = new JLabel("Entry: ");
        label2.setBounds(0,85, 50, 40);
        writeEntryFrame.add(label2);
        entry.setBounds(40,90, 200, 150);
        entry.getDocument().addDocumentListener(this);
        writeEntryFrame.add(entry);

        JButton create = new JButton ("Create entry");
        create.setBounds(250, 95, 125, 30);
        create.addActionListener(this);
        writeEntryFrame.add(create);

        JButton cancel = new JButton ("Cancel");
        cancel.setBounds(250,135, 125, 30);
        cancel.addActionListener(this);
        writeEntryFrame.add(cancel);

    }

    //creates entry
    public void createEntry() {
        String[] entryDetails = new String[4];
        entryDetails[2] = mood.getText();
        entryDetails[3] = entry.getText();

        Entry e = new Entry();
        e.create(entryDetails);
    }

    //view entries menu GUI
    public void viewEntriesMenu() {
        viewEntriesFrame.setPreferredSize(new Dimension(500, 350));
        viewEntriesFrame.pack();
        viewEntriesFrame.setVisible(true);
        viewEntriesFrame.setLayout(null);

        JLabel heading = new JLabel("View Entries");
        JLabel underline = new JLabel("------------------");
        heading.setBounds(0, 0, 200, 40);
        underline.setBounds(0, 5, 200, 40);
        viewEntriesFrame.add(heading);
        viewEntriesFrame.add(underline);

        JLabel date = new JLabel("Date");
        date.setBounds(0, 25, 200, 40);
        viewEntriesFrame.add(date);

        JLabel time = new JLabel("Time");
        time.setBounds(60, 25, 200, 40);
        viewEntriesFrame.add(time);

        JLabel mood = new JLabel("Overall mood");
        mood.setBounds(110, 25, 200, 40);
        viewEntriesFrame.add(mood);

        JLabel entry = new JLabel("Entry");
        entry.setBounds(210, 25, 200, 40);
        viewEntriesFrame.add(entry);

        JButton returnToMenu = new JButton("Return to menu");
        returnToMenu.setBounds(0, 250, 125, 40);
        returnToMenu.addActionListener(this);
        viewEntriesFrame.add(returnToMenu);

    }

    //displays all written entries
    public void displayEntries() {
        entryFile.readFile();

        int yCounter = 45;
        int length = entryFile.Length();
        int entryCounter = 0;

        for (int i = 0; i < (length / 4); i++) {
            JLabel date = new JLabel(entryFile.readFileLine(entryCounter));
            date.setBounds(0, yCounter, 200, 40);
            viewEntriesFrame.add(date);

            JLabel time = new JLabel(entryFile.readFileLine(entryCounter + 1));
            time.setBounds(60, yCounter, 200, 40);
            viewEntriesFrame.add(time);

            JLabel mood = new JLabel(entryFile.readFileLine(entryCounter + 2));
            mood.setBounds(110, yCounter, 1000, 40);
            viewEntriesFrame.add(mood);

            JLabel entry = new JLabel(entryFile.readFileLine(entryCounter + 3));
            entry.setBounds(210, yCounter, 1000, 40);
            viewEntriesFrame.add(entry);

            yCounter = yCounter + 20;

            if (entryCounter + 4 != length) {
                entryCounter = entryCounter + 4;
            }
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        entryFrame.setVisible(false);
        if (e.getActionCommand().equals("Write a new entry")) {
            writeEntryMenu();
        } else if (e.getActionCommand().equals("View previous entries")) {
            viewEntriesMenu();
            displayEntries();
        } else if (e.getActionCommand().equals("Main menu")) {
            entryFrame.dispose();
            try {
                MainMenu menu = new MainMenu();
            } catch (ParseException ex) {
                throw new RuntimeException(ex);
            }
        } else if (e.getActionCommand().equals("Create entry")) {
            createEntry();
            writeEntryFrame.setVisible(false);
            entryFrame.setVisible(true);
        } else if (e.getActionCommand().equals("Cancel")) {
            writeEntryFrame.setVisible(false);
            entryFrame.setVisible(true);
        } else if (e.getActionCommand().equals("Return to menu")) {
            viewEntriesFrame.setVisible(false);
            entryFrame.setVisible(true);
        }
    }

    @Override
    public void insertUpdate(DocumentEvent e) {}

    @Override
    public void removeUpdate(DocumentEvent e) {}

    @Override
    public void changedUpdate(DocumentEvent e) {}

}

