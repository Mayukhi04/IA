package com.company;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.io.IOException;
import java.util.ArrayList;

class File {
    public static String fileName;
    public ArrayList<String> fileContents;
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
