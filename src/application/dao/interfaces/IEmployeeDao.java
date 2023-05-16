package application.dao.interfaces;

import application.models.EmployeeModel;
import java.util.List;

public interface IEmployeeDao {
    
    public List<EmployeeModel> findOneById(EmployeeModel employee);
    
    public EmployeeModel findOneByUsername(EmployeeModel employee);
    
    public List<EmployeeModel> findAll();
    
    public int create(EmployeeModel employee);
    
    public int upsert(EmployeeModel employee);
    
    public int update(EmployeeModel employee);
    
    public void delete(EmployeeModel employee);

    public void closeStatement();
    
    public void closeConnection();
    
}