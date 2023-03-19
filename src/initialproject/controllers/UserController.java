package initialproject.controllers;

import initialproject.dao.InterfaceDao;
import initialproject.dao.UserDao;
import initialproject.models.User;
import initialproject.models.UserTableModel;
import initialproject.views.UserFrame;
import java.util.List;

public class UserController {
    
    private final UserFrame frame;
    private final InterfaceDao<User> userDao;
    private final List<User> users;
    
    public UserController(UserFrame frame){
        this.frame = frame;
        userDao = new UserDao();
        users = userDao.findAll();
    }
    
    public void loadTable() {
        UserTableModel userTableModel = new UserTableModel(users);
        frame.getJTable1().setModel(userTableModel);
    }
    
    public void daoClose(){
        userDao.close();
    }
}
