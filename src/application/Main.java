package application;

import application.databases.Mysql;
import application.views.*;

public class Main {
    
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            Config.build();
            Mysql mysql = new Mysql();
            MainFrame mainFrame = new MainFrame();
            mainFrame.start(); 
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
