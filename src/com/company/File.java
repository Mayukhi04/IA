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

    //read the entire file
    public void readFile() {
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
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

    //read a specific line from a file
    public String readFileLine(int line) {
        return fileContents.get(line);
    }

    public int Length() {
        return counter;
    }

    //write to the file
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

    //grab the character at position "start" in the file
    public static void randomRead(String filename, int start) {
        try (RandomAccessFile rf = new RandomAccessFile(filename,"rws")) {
            rf.seek(start);
            char letter = (char)rf.read();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
