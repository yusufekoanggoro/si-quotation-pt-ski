package application;

import application.views.CustomerView;
import application.views.LoginView;

public class Main {
    
    public static void main(String[] args) {
        try {
            Config.build();
            new GenerateUser().start();
            
            new LoginView().start();
//            loginView.start();
//            new CustomerView().start();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
