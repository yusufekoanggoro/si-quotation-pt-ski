package application.dao.interfaces;

import java.util.List;

public interface IEmployeeDao<T> {
    
    public List<T> findOne(T t);
    
    public T findOneByUsername(T t);
    
    public List<T> findAll();
    
    public int create(T t);
    
    public int update(T t);
    
    public void delete(T t);

    public void closeStatement();
    
    public void closeConnection();
    
}