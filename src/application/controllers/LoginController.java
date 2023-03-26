package application.controllers;

import application.views.*;
import application.dao.*;
import application.models.EmployeeModel;
import application.dao.interfaces.IEmployeeDao;
import java.util.List;

public class LoginController {
    
    private final IEmployeeDao<EmployeeModel> employeeDao;
    
    public LoginController() {
          this.employeeDao = new EmployeeDao();
    }
    
    public boolean validateLogin(String username, String password){
        EmployeeModel employee = new EmployeeModel();
        employee.setUsername(username);
        List<EmployeeModel> findOneByUsername = employeeDao.findOneByUsername(employee);
        return findOneByUsername.size() == 1;
    }
}
