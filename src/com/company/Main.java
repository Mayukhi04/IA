package com.company;
import javax.swing.*;

public class Main {

    public static void main(String[] args) {
         System.out.println("Starting...");

         JFrame frame = new JFrame("Demo Frame");
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         MainMenu menu = new MainMenu(300, 150);
         frame.add(menu);
         frame.pack();
         frame.setVisible(true);
         System.out.println("Finished.");

         //MenuExample m = new MenuExample();
         //m.menu();

    }

}
