package application.dao.interfaces;

import application.models.RoleModel;
import java.util.List;

public interface IRoleDao {
    
    public RoleModel findOneById(RoleModel role);
    
    public RoleModel findOneByUsername(RoleModel role);
    
    public List<RoleModel> findAll();
    
    public int create(RoleModel role);
    
    public int upsert(RoleModel role);
    
    public int update(RoleModel role);
    
    public List<RoleModel> search(String keyword);
    
    public int delete(int id);
    
    public RoleModel findOneByName(RoleModel role);

    public void closeStatement();
    
    public void closeConnection();
    
}