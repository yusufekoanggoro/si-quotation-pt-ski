package main.java.dao.interfaces;
  
import main.java.models.ItemModel;
import java.util.List;

public interface IItemDao {
    
    public List<ItemModel> findAll();

    public void closeStatement();
    
    public void closeConnection();
    
    public List<ItemModel> search(String keyword);
    
    public int create(ItemModel item);
    
    public int delete(int id);
    
    public int update(ItemModel item);
    
    public ItemModel findOneByName(ItemModel customer);

    
}
