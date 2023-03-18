package initialproject.dao;

import initialproject.models.User;
import java.util.List;

public interface InterfaceDao<T> {
    
    public User findOne(T t);
    
    public List<T> findAll();
    
    public int create(T t);
    
    public int update(T t);
    
    public void delete(T t);

    public void close();
    
}