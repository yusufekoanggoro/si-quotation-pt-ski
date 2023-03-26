package application.dao;

import java.util.List;

public interface InterfaceDao<T> {
    
    public T findOne(T t);
    
    public List<T> findAll();
    
    public int create(T t);
    
    public int update(T t);
    
    public void delete(T t);

    public void closeStatement();
    
    public void closeConnection();
    
}