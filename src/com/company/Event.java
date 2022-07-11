package com.company;

import java.io.FileNotFoundException;

public class Event {
    String[] eventDetails;
    File eventFile = new File("events.txt");

    public Event() {

    }

    public void create(String[] d) {
        eventDetails = d;

        for (int i = 0; i < 4; i++) {
            if (eventDetails[i].equals("")) {
                File.write("#");
            } else {
                File.write(eventDetails[i]);
            }
        }
    }

    public void updateEvent(String name, String[] d) throws FileNotFoundException {
        eventDetails = d;
        File.update(name, d);
    }

    public void deleteEvent(String name) throws FileNotFoundException {
        System.out.println(name);
        File.delete(name);
    }
}
