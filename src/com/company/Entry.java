package com.company;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Entry {
    String[] entryDetails;

    public Entry() {

    }

    public void create(String[] d) {
        File eventFile = new File("entries.txt");
        entryDetails = d;

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
        String currentDate = formatter.format(date);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
        LocalDateTime now = LocalDateTime.now();
        String currentTime = dtf.format(now);

        entryDetails[0] = currentDate;
        entryDetails[1] = currentTime;

        for (int i = 0; i < 4; i++) {
            if (entryDetails[i].equals("")) {
                File.write("#");
            } else {
                File.write(entryDetails[i]);
            }
        }
    }

    public void delete(String entryName) {

    }

    public void respond(int num) {
        System.out.println("");
    }

    public void respond(String mood) {
        System.out.println("");
    }

}
