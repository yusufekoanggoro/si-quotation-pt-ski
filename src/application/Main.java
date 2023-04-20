package application;

import application.frames.LoginFrame2;
import application.frames.ResponsiveGUI;

public class Main {
    
    public static void main(String[] args) {
        try {
            Config.build();
            
            GenerateUser generateUser = new GenerateUser();
            generateUser.start();
            
            LoginFrame2 loginFrame2 = new LoginFrame2();
            loginFrame2.start();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
