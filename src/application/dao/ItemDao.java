package application.dao;

import application.dao.interfaces.IItemDao;
import application.databases.Mysql;
import application.models.ItemModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Statement;

public class ItemDao implements IItemDao {
    
    private Connection connection = null;
    private PreparedStatement pstmt = null;
    private ResultSet resultSet = null;
    private String query;
    
    public ItemDao() {
        this.connection = new Mysql().getConnection();
    }

    @Override
    public List<ItemModel> findAll() {
       try {
            query = "SELECT id, name, price_per_unit "
                    + "FROM items ";
            
            pstmt = connection.prepareStatement(query);
            resultSet = pstmt.executeQuery();
            
            List<ItemModel> customers = new ArrayList<>();

            while (resultSet.next()) {
                ItemModel customer = new ItemModel();
                customer.setId(resultSet.getInt("id"));
                customer.setName(resultSet.getString("name"));
                customer.setPrice(resultSet.getInt("price_per_unit"));
                customers.add(customer);
            }
            return customers;
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
    public List<ItemModel> search(String keyword) { 
        try {
            query = "SELECT id, name, price_per_unit "
                    + "FROM items "
                    + "WHERE name LIKE '%" + keyword + "%' "
                    + "OR price_per_unit LIKE '%" + keyword + "%' "
                    + "OR id LIKE '%" + keyword + "%' ";
            
            pstmt = connection.prepareStatement(query);
            resultSet = pstmt.executeQuery();
            
            List<ItemModel> customers = new ArrayList<>();

            while (resultSet.next()) {
                ItemModel customer = new ItemModel();
                customer.setId(resultSet.getInt("id"));
                customer.setName(resultSet.getString("name"));
                customer.setPrice(resultSet.getInt("price_per_unit"));
                customers.add(customer);
            }
            return customers;
	} catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        }finally{
            closeStatement();
        }
    }

    @Override
    public int create(ItemModel item) {
         try {
            
            java.util.Date utilDate = new java.util.Date();
            java.sql.Timestamp dateNow = new java.sql.Timestamp(utilDate.getTime());
        
            query = "INSERT INTO items( name, price_per_unit, created_at, updated_at) "
                    + "VALUES( ?, ?, ?, ?)";
            
            pstmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, item.getName());
            pstmt.setInt(2, item.getPrice()); 
            pstmt.setTimestamp(3, dateNow);
            pstmt.setTimestamp(4, dateNow);
            
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
            query = "DELETE FROM items WHERE id = ?";
            
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
    public int update(ItemModel item) {
          try {
            java.util.Date utilDate = new java.util.Date();
            java.sql.Timestamp dateNow = new java.sql.Timestamp(utilDate.getTime());
  
            query = "UPDATE items " 
                    + "SET name = ?, price_per_unit = ?, updated_at = ?"
                    + "WHERE id = ?";

            pstmt = connection.prepareStatement(query);
            pstmt.setString(1, item.getName());
            pstmt.setInt(2, item.getPrice());
            pstmt.setTimestamp(3, dateNow);
            pstmt.setInt(4, item.getId());
            
            return pstmt.executeUpdate();
	} catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        }finally{
            closeStatement();
        }
    }

    @Override
    public ItemModel findOneByName(ItemModel customer) { 
        try {
            query = "SELECT id, name, price_per_unit " 
                    + "FROM items "
                    + "WHERE name = ? ";
            
            pstmt = connection.prepareStatement(query);
            pstmt.setString(1, customer.getName());
            
            resultSet = pstmt.executeQuery();
            if(resultSet.next()){
                customer.setId(resultSet.getInt("id"));
                customer.setName(resultSet.getString("name"));
                customer.setPrice(resultSet.getInt("price_per_unit")); 
                return customer;
            }
            return null;
	} catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        }finally{
            closeStatement();
        }
    }

    
}
