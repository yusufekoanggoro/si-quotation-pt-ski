package application.usecases;

import application.Password;
import application.dao.*;
import application.models.EmployeeModel;
import application.dao.interfaces.IEmployeeDao;

public class LoginUsecase {
    
    private final IEmployeeDao employeeDao;
    
    public LoginUsecase() {
        this.employeeDao = new EmployeeDao();
    }
    
    public boolean usernameAndPasswordValidation(String username, String password){
        EmployeeModel employee = new EmployeeModel();
        employee.setUsername(username);
        
        EmployeeModel findOneEmployeeByUsername = employeeDao.findOneByUsername(employee);
        if(findOneEmployeeByUsername == null) return false;

        String userPasswordInput = Password.getSecurePassword(password);
        String passwordDb = employee.getPassword();
        
        return userPasswordInput.equals(passwordDb);
    }
    
    public void daoCloseConnection() {
        employeeDao.closeConnection();
    }
}
