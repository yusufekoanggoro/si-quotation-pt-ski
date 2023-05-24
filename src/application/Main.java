package application;

import application.views.*;

public class Main {
    
    public static void main(String[] args) {
        try {
            Config.build();
            new GenerateUser().start();
//            new EmployeeView().start();            
            new LoginView().start();
//            new MenuView().start();
//            loginView.start();
//            new CustomerView().start();
//            new JasperView().setVisible(true);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
