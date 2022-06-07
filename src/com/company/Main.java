package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Wacky cool title");
        System.out.println("----------------");
        System.out.println("Hello user!");
        System.out.println("How has your day been?");

        Scanner input = new Scanner(System.in);
        Entry myEntry;
        String initialEntry = input.nextLine();
        try {
            myEntry = new Entry(Integer.parseInt(initialEntry));
        } catch(Exception e) {
            myEntry = new Entry(initialEntry);
        }
        myEntry.respond();

        System.out.println("What would you like to do today?");
        System.out.println("1. Write an entry");
        System.out.println("2. View events");

        int menuChoice = Integer.parseInt(input.nextLine());
        System.out.println();

        switch(menuChoice) {
            case 1:
                entryMenu();
            case 2:
                eventMenu();
            default:
                System.out.println("Invalid input");
                main(null);
        }
    }

    public static void entryMenu() {
        System.out.println("Entries");
        System.out.println("-------");
        System.out.println("1. Create new entry");
        System.out.println("2. View previous entries");
        System.out.println("3. Return to main menu");

        Scanner input = new Scanner(System.in);
        int menuChoice = Integer.parseInt(input.nextLine());

        switch (menuChoice) {
            case 1:
                System.out.println("Create new entry");
                System.out.println("----------------");

                System.out.println("Event title:");
                String eventTitle = input.nextLine();
                System.out.println("Date:");
                String eventDate = input.nextLine();
                System.out.println("Time:");
                String eventTime = input.nextLine();
                System.out.println("Additional details:");
                String eventDetails = input.nextLine();

                Event myEvent = new Event(eventTitle, eventDate, eventTime, eventDetails);
                myEvent.create();

                System.out.println("Event has been created");
                System.out.println("Press any key to return to menu");
                input.nextLine();
                main(null);
            case 2:
                File entries = new File("entries.txt");
                entries.readFile();
                System.out.println();
                System.out.println("Press any key to return to menu");
                input.nextLine();
                main(null);
            case 3:
                main(null);
            default:
                System.out.println("Invalid input");
                main(null);
        }
    }

    public static void eventMenu() {
        System.out.println("Events");
        System.out.println("------");
        System.out.println("1. Create new event");
        System.out.println("2. View all events");
        System.out.println("3. Upcoming");
        System.out.println("4. Past");
        System.out.println("5. Return to main menu");

        Scanner input = new Scanner(System.in);
        int menuChoice = Integer.parseInt(input.nextLine());

        switch (menuChoice) {
            case 1:
                System.out.println("Create new event");
                System.out.println("----------------");

                System.out.println("Event title:");
                String eventTitle = input.nextLine();
                System.out.println("Date:");
                String eventDate = input.nextLine();
                System.out.println("Time:");
                String eventTime = input.nextLine();
                System.out.println("Additional details:");
                String eventDetails = input.nextLine();

                Event myEvent = new Event(eventTitle, eventDate, eventTime, eventDetails);
                myEvent.create();

                System.out.println("Event has been created");
                System.out.println("Press any key to return to menu");
                input.nextLine();
                main(null);
            case 2:
                File events = new File("events.txt");
                events.readFile();
                System.out.println();
                System.out.println("Press any key to return to menu");
                input.nextLine();
                main(null);
            case 3:
                System.out.println("This also works");
            case 4:
                main(null);
            default:
                System.out.println("Invalid input");
                main(null);
        }

    }

}
