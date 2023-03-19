package initialproject;

import initialproject.dao.InterfaceDao;
import initialproject.dao.UserDao;
import initialproject.models.User;
import initialproject.views.UserFrame;


public class Main {
    private final InterfaceDao<User> userDao;
    
    public Main(){
        userDao = new UserDao();
        UserFrame userFrame = new UserFrame();
        userFrame.start();
    }
    
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            Main programm = new Main();
            programm.runExampleUsageDao();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public void runExampleUsageDao ()
    {
        try{
            User user = new User();
            user.setName("EKo");
            user.setAge(12);
            System.out.print("Create User to DB ");
            System.out.println(userDao.create(user));

            // findOne user by id
            User findOneUser = new User();
            findOneUser.setId(1);
            System.out.print("Find One User to DB ");
            System.out.println(userDao.findOne(findOneUser).getName());
            
            // findAll user 
            System.out.print("Find All User to DB ");           
            userDao.findAll().forEach(value -> System.out.println(value.getName()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            userDao.closeStatement();
            userDao.closeConnection();
        }
    }
}
