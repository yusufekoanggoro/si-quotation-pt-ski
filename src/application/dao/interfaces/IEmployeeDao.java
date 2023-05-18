package application.dao.interfaces;

import application.models.EmployeeModel;
import java.util.List;

public interface IEmployeeDao {
    
//    public List<EmployeeModel> findOneById(EmployeeModel employee);
    
    public EmployeeModel findOneById(EmployeeModel employee);
    
    public EmployeeModel findOneByUsername(EmployeeModel employee);
    
    public List<EmployeeModel> search(String keyword);
    
    public EmployeeModel findOneByName(EmployeeModel employee);
    
    public List<EmployeeModel> findAll();
    
    public int create(EmployeeModel employee);
    
    public int upsert(EmployeeModel employee);
    
    public int update(EmployeeModel employee);
    
    public int delete(int id);

    public void closeStatement();
    
    public void closeConnection();
    
}