/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.dao;

import main.java.dao.interfaces.IItemDao;
import main.java.dao.interfaces.ITransactionDao;
import main.java.databases.Mysql;
import main.java.models.ItemModel;
import main.java.models.TransactionChartModel;
import main.java.models.TransactionModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author athal
 */
public class TransactionDao implements ITransactionDao {
    
    private Connection connection = null;
    private PreparedStatement pstmt = null;
    private ResultSet resultSet = null;
    private String query;
    
    public TransactionDao() {
        this.connection = new Mysql().getConnection();
    }

    @Override
    public List<TransactionModel> findAll() {
       try {
            query = "SELECT transactions.id, transactions.quote_number, customers.name as customer, items.name as item"
                    + ", transactions.Qty, transactions.Total, transactions.status "
                    + ", employees.name as sender_name, transactions.custom_date "
                    + "FROM transactions "
                    + "INNER JOIN employees ON transactions.employee_id = employees.id "
                    + "INNER JOIN customers ON transactions.customer_id = customers.id "
                    + "INNER JOIN items ON transactions.item_id = items.id";

            pstmt = connection.prepareStatement(query);
            resultSet = pstmt.executeQuery();
            
            List<TransactionModel> transaction = new ArrayList<>();

            while (resultSet.next()) {
                TransactionModel transactiondtl = new TransactionModel();
                transactiondtl.setId(resultSet.getInt("id"));
                transactiondtl.setQuoteNumber(resultSet.getString("quote_number"));
                transactiondtl.setCustomer(resultSet.getString("customer"));
                transactiondtl.setItem(resultSet.getString("item"));
                transactiondtl.setStatus(resultSet.getString("status"));
                transactiondtl.setQty(resultSet.getInt("Qty"));
                transactiondtl.setTotal(resultSet.getInt("Total"));
                transactiondtl.setSenderName(resultSet.getString("sender_name"));
                transactiondtl.setCustomDate(resultSet.getTimestamp("custom_date"));
                transaction.add(transactiondtl);
            }
            return transaction;
	} catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        }finally{
            closeStatement();
        }
    }

    @Override
    public void closeStatement() {
        try {
            if(pstmt != null){
                pstmt.close();
                pstmt = null;
            }
            if(resultSet != null){
                resultSet.close();
                resultSet = null;
            }   
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void closeConnection() {
        try {
            if(connection != null){
                connection.close();
                connection = null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public List<TransactionModel> search(String keyword) {
        try {
            query = "SELECT transactions.id, customers.name as customer, items.name as item, employees.name as sender_name, transactions.custom_date"
                    + ", transactions.Qty, transactions.Total, transactions.status, transactions.quote_number "
                    + "FROM transactions "
                    + "INNER JOIN customers ON transactions.customer_id = customers.id "
                    + "INNER JOIN items ON transactions.item_id = items.id "
                    + "INNER JOIN employees ON transactions.employee_id = employees.id "
                    + "WHERE transactions.id LIKE '%" + keyword + "%' "  
                    + "OR customers.name LIKE '%" + keyword + "%' "
                    + "OR items.name LIKE '%" + keyword + "%' "
                    + "OR transactions.status LIKE '%" + keyword + "%' ";

            pstmt = connection.prepareStatement(query);
            resultSet = pstmt.executeQuery();
            
            List<TransactionModel> transaction = new ArrayList<>();

            while (resultSet.next()) {
                 TransactionModel transactiondtl = new TransactionModel();
                transactiondtl.setId(resultSet.getInt("id"));
                transactiondtl.setQuoteNumber(resultSet.getString("quote_number"));
                transactiondtl.setCustomer(resultSet.getString("customer"));
                transactiondtl.setItem(resultSet.getString("item"));
                transactiondtl.setStatus(resultSet.getString("status"));
                transactiondtl.setQty(resultSet.getInt("Qty"));
                transactiondtl.setTotal(resultSet.getInt("Total"));
                transactiondtl.setSenderName(resultSet.getString("sender_name"));
                transactiondtl.setCustomDate(resultSet.getTimestamp("custom_date"));
                transaction.add(transactiondtl);
            }
            return transaction;
	} catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        }finally{
            closeStatement();
        }
    }

    @Override
    public int create(TransactionModel item) {
        try {
              
            java.util.Date utilDate = new java.util.Date();
            java.sql.Timestamp dateNow = new java.sql.Timestamp(utilDate.getTime());
        
            query = "INSERT INTO transactions(customer_id, item_id, status, Qty, Total, created_at, updated_at, quote_number, employee_id, custom_date) "
                    + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            pstmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, Integer.parseInt(item.getCustomer()));
            pstmt.setInt(2, Integer.parseInt(item.getItem())); 
            pstmt.setString(3, item.getStatus()); 
            pstmt.setInt(4, item.getQty()); 
            pstmt.setInt(5, item.getTotal()); 
            pstmt.setTimestamp(6, dateNow);
            pstmt.setTimestamp(7, dateNow);
            pstmt.setString(8, item.getQuoteNumber());
            pstmt.setString(9, item.getEmployeeId());
            pstmt.setTimestamp(10, item.getCustomDate());
            
            return pstmt.executeUpdate();
	} catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        }finally{
            closeStatement();
        }
    }

    @Override
    public int delete(int id) {
         try {
            query = "DELETE FROM transactions WHERE id = ?";
            
            pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, id);
            
            return pstmt.executeUpdate();
	} catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        }finally{
            closeStatement();
        }
    }

    @Override
    public int update(TransactionModel item) {  
        
        try {
            java.util.Date utilDate = new java.util.Date();
            java.sql.Timestamp dateNow = new java.sql.Timestamp(utilDate.getTime());
  
            
            query = "UPDATE transactions " 
                    + "SET customer_id = ?, item_id = ?, status = ?, Qty = ?, Total = ?, updated_at = ?, employee_id = ?, custom_date = ?, quote_number = ? "
                    + "WHERE id = ?";
            
            pstmt = connection.prepareStatement(query); 
            pstmt.setInt(1, Integer.parseInt(item.getCustomer()));
            pstmt.setInt(2, Integer.parseInt(item.getItem()));
            pstmt.setString(3, item.getStatus());
            pstmt.setInt(4, item.getQty());
            pstmt.setInt(5, item.getTotal());
            pstmt.setTimestamp(6, dateNow);
            pstmt.setInt(7, Integer.parseInt(item.getEmployeeId()));
            pstmt.setTimestamp(8, item.getCustomDate());
            pstmt.setString(9, item.getQuoteNumber());
            pstmt.setInt(10, item.getId());
            
            return pstmt.executeUpdate();
	} catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        }finally{
            closeStatement();
        }
    }

    @Override
    public TransactionModel findOneByName(TransactionModel customer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TransactionChartModel> getTransactionChart() {
        try {
            query = "SELECT "
                    + "YEAR(created_at) AS year, MONTH(created_at) AS month, SUM(Total) AS total "
                    + "FROM transactions "
                    + "GROUP BY YEAR(created_at), MONTH(created_at) "
                    + "ORDER BY YEAR(created_at), MONTH(created_at)";
            
            pstmt = connection.prepareStatement(query);
            resultSet = pstmt.executeQuery();
            
            List<TransactionChartModel> transactionsChart = new ArrayList<>();

            while (resultSet.next()) {
                TransactionChartModel transactionChart = new TransactionChartModel();
                transactionChart.setYear(resultSet.getString("year"));
                transactionChart.setMonth(resultSet.getInt("month"));
                transactionChart.setTotal(resultSet.getInt("total"));
    
                transactionsChart.add(transactionChart);
            }
            return transactionsChart;
	} catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        }finally{
            closeStatement();
        }
    }

    @Override
    public List<TransactionChartModel> getTransactionPerStatusChart() {
                try {
            query = "SELECT status, COUNT(*) as count FROM transactions GROUP BY status";
            
            pstmt = connection.prepareStatement(query);
            resultSet = pstmt.executeQuery();
            
            List<TransactionChartModel> transactionsChart = new ArrayList<>();

            while (resultSet.next()) {
                TransactionChartModel transactionChart = new TransactionChartModel();
                transactionChart.setStatus(resultSet.getString("status"));
                transactionChart.setCount(resultSet.getInt("count"));
    
                transactionsChart.add(transactionChart);
            }
            return transactionsChart;
	} catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        }finally{
            closeStatement();
        }
    }

}
