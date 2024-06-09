/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.dao.interfaces;

import application.models.TransactionModel;
import application.models.TransactionChartModel;
import java.util.List;

/**
 *
 * @author athal
 */
public interface ITransactionDao {
    public List<TransactionModel> findAll();

    public void closeStatement();
    
    public void closeConnection();
    
    public List<TransactionModel> search(String keyword);
    
    public int create(TransactionModel item);
    
    public int delete(int id);
    
    public int update(TransactionModel item);
    
    public TransactionModel findOneByName(TransactionModel customer);
    
    public List<TransactionChartModel> getTransactionChart();
    
    public List<TransactionChartModel> getTransactionPerStatusChart();
}
