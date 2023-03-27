package application.controllers;

import application.Password;
import application.dao.*;
import application.models.EmployeeModel;
import application.dao.interfaces.IEmployeeDao;

public class LoginController {
    
    private final IEmployeeDao<EmployeeModel> employeeDao;
    
    public LoginController() {
          this.employeeDao = new EmployeeDao();
    }
    
    public boolean validateLogin(String username, String password){
        EmployeeModel employee = new EmployeeModel();
        employee.setUsername(username);
        EmployeeModel findOneByUsername = employeeDao.findOneByUsername(employee);
        if(findOneByUsername == null) return false;

        String inputUser = Password.getSecurePassword(password);
        String passwordDb = findOneByUsername.getPassword();
        
        return inputUser.equals(passwordDb);
    }
    
    public void daoCloseConnection() {
        employeeDao.closeConnection();
    }
}
