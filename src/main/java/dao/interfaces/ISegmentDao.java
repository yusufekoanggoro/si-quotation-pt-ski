package main.java.dao.interfaces;

import main.java.models.SegmentModel;
import java.util.List;

public interface ISegmentDao {
    
    public List<SegmentModel> findOneById(SegmentModel model);
    
    public SegmentModel findOneByUsername(SegmentModel model);
    
    public List<SegmentModel> findAll();
    
    public int create(SegmentModel model);
    
    public int upsert(SegmentModel model);
    
    public int update(SegmentModel model);
    
    public int delete(int id);

    public void closeStatement();
    
    public void closeConnection();
    
}