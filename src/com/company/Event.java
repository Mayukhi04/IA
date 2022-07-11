package com.company;

public class Event {
    String[] eventDetails;

    public Event(String[] d) {
        eventDetails = d;
    }


    public void create() {
        File eventFile = new File("events.txt");

        for (int i = 0; i < 4; i++) {
            if (eventDetails[i].equals("")) {
                File.write("#");
            } else {
                File.write(eventDetails[i]);
            }
        }
    }
}
