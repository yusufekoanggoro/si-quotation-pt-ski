package application;

import application.views.LoginView;

public class Main {
    
    public static void main(String[] args) {
        try {
            Config.build();
            new GenerateUser().start();
            
            LoginView loginView = new LoginView();
            loginView.start();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
