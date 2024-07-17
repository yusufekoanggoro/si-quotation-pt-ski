package main.java;

import main.java.views.*;
import main.java.views.ReportView;

public class Main {
    
    public static void main(String[] args) {
        try {
//            Config.build();
//            new GenerateUser().start();
//            new EmployeeView().start();            
            new LoginView().start();
//            new MenuView().start();
//            loginView.start();
//            new CustomerView().start();
//            new ReportView().start();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
