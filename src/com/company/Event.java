package com.company;

public class Event {
    String title;
    String date;
    String time;
    String details;

    public Event(String title, String date, String time, String details) {
        this.title = title;
        this.date = date;
        this.time = time;
        this.details = details;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getDetails() {
        return details;
    }

    public void create() {
        File myEvent = new File("events.txt");
        myEvent.write(title);
        myEvent.write(date);
        myEvent.write(time);
        myEvent.write(details);
    }

<<<<<<< HEAD
}
=======
}
>>>>>>> origin/master
