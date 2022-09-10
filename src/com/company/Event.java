package com.company;
import java.io.FileNotFoundException;

public class Event {
    String[] eventDetails;
    File eventFile = new File("events.txt");

    public Event() {}

    //creates an event
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

    public void validate(String name) {

    }

    //updates an event
    public void updateEvent(String name, String[] d) throws FileNotFoundException {
        eventDetails = d;
        File.update(name, d);
    }

    //deletes an event
    public void deleteEvent(String name) throws FileNotFoundException {
        File.delete(name);
    }

}
