package com.company;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EntryMenu extends JPanel implements ActionListener, DocumentListener {
    // canvas for other GUI widgets
    JFrame entryFrame = new JFrame("Entry Menu");
    JFrame createEntryFrame = new JFrame("Create Entry");
    JFrame viewEntriesFrame = new JFrame("View Entries");

    public EntryMenu() {
        entryFrame.setPreferredSize(new Dimension(300, 250));
        setLayout(null);
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

    public void createEntry() {
        createEntryFrame.setPreferredSize(new Dimension(400, 300));
        setLayout(null);
        createEntryFrame.pack();
        createEntryFrame.setVisible(true);
        createEntryFrame.setLayout(null);

        JLabel heading = new JLabel("Write an entry");
        JLabel underline = new JLabel("--------------------");
        heading.setBounds(0, 0, 200, 40);
        underline.setBounds(0, 5, 200, 40);
        createEntryFrame.add(heading);
        createEntryFrame.add(underline);

        JLabel label1 = new JLabel("Mood: ");
        label1.setBounds(0,40, 50, 40);
        createEntryFrame.add(label1);
        JTextField mood = new JTextField();
        mood.setBounds(40,45, 200, 30);
        mood.getDocument().addDocumentListener(this);
        createEntryFrame.add(mood);

        JLabel label2 = new JLabel("Entry: ");
        label2.setBounds(0,85, 50, 40);
        createEntryFrame.add(label2);
        JTextField entry = new JTextField();
        entry.setBounds(40,90, 200, 150);
        entry.getDocument().addDocumentListener(this);
        createEntryFrame.add(entry);

        JButton create = new JButton ("Create entry");
        create.setBounds(250, 95, 125, 30);
        create.addActionListener(this);
        createEntryFrame.add(create);

        JButton cancel = new JButton ("Cancel");
        cancel.setBounds(250,135, 125, 30);
        cancel.addActionListener(this);
        createEntryFrame.add(cancel);

    }

    public void viewEntries() {
        viewEntriesFrame.setPreferredSize(new Dimension(500, 350));
        setLayout(null);
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
        time.setBounds(50, 25, 200, 40);
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

    @Override
    public void actionPerformed(ActionEvent e) {
        entryFrame.setVisible(false);
        if (e.getActionCommand().equals("Write a new entry")) {
            System.out.println("New entry!");
            createEntry();
        } else if (e.getActionCommand().equals("View previous entries")) {
            System.out.println("View entries!");
            viewEntries();
        } else if (e.getActionCommand().equals("Main menu")) {
            System.out.println("Main menu!");
        } else if (e.getActionCommand().equals("Create entry")) {
            System.out.println("Create entry!");
            createEntryFrame.setVisible(false);
            entryFrame.setVisible(true);
        } else if (e.getActionCommand().equals("Cancel")) {
            System.out.println("Cancel!");
            createEntryFrame.setVisible(false);
            entryFrame.setVisible(true);
        } else if (e.getActionCommand().equals("Return to menu")) {
            System.out.println("Return to menu!");
            viewEntriesFrame.setVisible(false);
            entryFrame.setVisible(true);
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

