package com.company;
import java.io.*;
import java.util.ArrayList;

class File {
    public static String fileName;
    public static ArrayList<String> fileContents;
    int counter = 0;

    public File(String fileName) {
        this.fileName = fileName;
        fileContents = new ArrayList<>();
        readFile();
    }

    //read entire file
    public void readFile() {
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            fileContents.clear();

            counter = 0;
            fileContents.add(br.readLine());

            while (fileContents.get(counter) != null) {
                fileContents.add(br.readLine());
                counter++;
            }

            br.close();
            fr.close();
        }
        catch (IOException exception) {
            System.out.println("Something went wrong");
        }
    }

    //read a specific line from file
    public String readFileLine(int line) {
        return fileContents.get(line);
    }

    //write to file
    public static void write(String text) {
        try (
                FileWriter fw = new FileWriter(fileName, true);
                PrintWriter pw = new PrintWriter(fw);
        ) {
            pw.println(text);
            pw.flush();
        }
        catch (IOException exception) {
            System.out.println("Something went wrong");
        }
    }

    //returns length of file
    public int Length() {
        return counter;
    }

    //overwrites part of file
    public static void update(String text, String[] details) throws FileNotFoundException {
        int index = 0;

        for (int i = 2; i < fileContents.size() - 1; i = i + 4) {
            if (fileContents.get(i).equals(text)) {
                index = i;
                break;
            }
        }

        int indexCounter = -2;

        for (int i = 0; i < 4; i++) {
            if (!details[i].equals("")) {
                fileContents.set((index + indexCounter), details[i]);
            }
            indexCounter++;
        }

        PrintWriter writer = new PrintWriter(fileName);
        writer.print("");
        writer.close();

        for (int i = 0; i < fileContents.size() - 1; i++) {
            write(fileContents.get(i));
        }

    }

    //deletes one entry/event from either file
    public static void delete(String text) throws FileNotFoundException {
        for (int i = 0; i < fileContents.size() - 1; i = i + 4) {
            if (fileContents.get(i + 2).equals(text)) {
                for (int x = 0; x < 4; x++) {
                    fileContents.remove(i);
                }
                break;
            }
        }

        PrintWriter writer = new PrintWriter(fileName);
        writer.print("");
        writer.close();

        for (int i = 0; i < fileContents.size() - 1; i++) {
            write(fileContents.get(i));
        }

    }

}
