package com.company;

public class Entry {
    String mood;
    int num = -1;

    public Entry(String mood) {
        this.mood = mood;
    }

    public Entry(int num) {
        this.num = num;
    }

    public void create() {
        File myEntry = new File("entries.txt");
        if (num != -1) {
            myEntry.write(String.valueOf(num));
        } else {
            myEntry.write(mood);
        }
    }

    public void respond() {
        System.out.println("lmao rip you");
    }

}
