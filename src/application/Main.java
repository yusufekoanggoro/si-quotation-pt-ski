package application;

import application.views.*;

public class Main {
    
    public static void main(String[] args) {
        try {
            Config.build();
            LoginFrame2 loginFrame2 = new LoginFrame2();
            loginFrame2.start();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
