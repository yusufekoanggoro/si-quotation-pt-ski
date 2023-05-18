package application;

import application.views.CustomerView;
import application.views.EmployeeView;
import application.views.JasperView;
import application.views.LoginView;

public class Main {
    
    public static void main(String[] args) {
        try {
            Config.build();
            new GenerateUser().start();
            new EmployeeView().start();            
//            new LoginView().start();
//            loginView.start();
//            new CustomerView().start();
//            new JasperView().setVisible(true);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
