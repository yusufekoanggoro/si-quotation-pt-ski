package application.dao.interfaces;

import application.models.CustomerModel;
import application.models.SegmentMarketModel;
import java.util.List;

public interface ICustomerDao {
    
    public CustomerModel findOneById(CustomerModel customer);
    
    public CustomerModel findOneByUsername(CustomerModel customer);
    
    public List<CustomerModel> findAll();
    
    public int create(CustomerModel customer);
    
    public int upsert(CustomerModel customer);
    
    public int update(CustomerModel customer);
    
    public List<CustomerModel> search(String keyword);
    
    public int delete(int id);
    
    public CustomerModel findOneByName(CustomerModel customer);

    public void closeStatement();
    
    public void closeConnection();
    
    public List<SegmentMarketModel> getSegmentMarket();
    
}