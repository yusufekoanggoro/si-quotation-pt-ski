package application.dao;

import application.dao.interfaces.ICustomerDao;
import application.databases.Mysql;
import application.models.CustomerModel;
import application.models.SegmentMarketModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Statement;

public class CustomerDao implements ICustomerDao {
    
    private Connection connection = null;
    private PreparedStatement pstmt = null;
    private ResultSet resultSet = null;
    private String query;
    
    public CustomerDao() {
        this.connection = new Mysql().getConnection();
    }

    @Override
    public CustomerModel findOneById(CustomerModel customer) {
        try {
            query = "SELECT customers.*, segments.name AS segment_name FROM customers " 
                    + "INNER JOIN segments "
                    + "ON customers.segment_id = segments.id " 
                    + "WHERE customers.id = ?";
            
            pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, customer.getId());
            
            resultSet = pstmt.executeQuery();
            if(resultSet.next()){
                customer.setId(resultSet.getInt("id"));
                customer.setName(resultSet.getString("name"));
                customer.setSegmentId(resultSet.getInt("segment_id"));
                customer.setSegmentName(resultSet.getString("segment_name"));
                customer.setPersonInCharge(resultSet.getString("person_in_charge"));
                customer.setPhoneNumber(resultSet.getString("phone_number"));
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

    @Override
    public CustomerModel findOneByUsername(CustomerModel customer) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public CustomerModel findOneByName(CustomerModel customer) {
        try {
            query = "SELECT customers.*, segments.name AS segment_name FROM customers " 
                    + "INNER JOIN segments " 
                    + "ON customers.segment_id = segments.id " 
                    + "WHERE customers.name = ?";
            
            pstmt = connection.prepareStatement(query);
            pstmt.setString(1, customer.getName());
            
            resultSet = pstmt.executeQuery();
            if(resultSet.next()){
                customer.setId(resultSet.getInt("id"));
                customer.setName(resultSet.getString("name"));
                customer.setSegmentId(resultSet.getInt("segment_id"));
                customer.setSegmentName(resultSet.getString("segment_name"));
                customer.setPersonInCharge(resultSet.getString("person_in_charge"));
                customer.setPhoneNumber(resultSet.getString("phone_number"));
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

    @Override
    public List<CustomerModel> findAll() {
        try {
            query = "SELECT customers.*, segments.name AS segment_name FROM customers " 
                    + "INNER JOIN segments " 
                    + "ON customers.segment_id = segments.id;";
            pstmt = connection.prepareStatement(query);
            resultSet = pstmt.executeQuery();
            
            List<CustomerModel> customers = new ArrayList<>();

            while (resultSet.next()) {
                CustomerModel customer = new CustomerModel();
                customer.setId(resultSet.getInt("id"));
                customer.setName(resultSet.getString("name"));
                customer.setSegmentId(resultSet.getInt("segment_id"));
                customer.setSegmentName(resultSet.getString("segment_name"));
                customer.setPersonInCharge(resultSet.getString("person_in_charge"));
                customer.setPhoneNumber(resultSet.getString("phone_number"));
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
    public int create(CustomerModel customer) {
        try {
            
            java.util.Date utilDate = new java.util.Date();
            java.sql.Timestamp dateNow = new java.sql.Timestamp(utilDate.getTime());
        
            query = "INSERT INTO customers(name, segment_id, person_in_charge, phone_number, created_at, updated_at) "
                    + "VALUES(?, ?, ?, ?, ?, ?)";
            
            pstmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, customer.getName());
            pstmt.setInt(2, customer.getSegmentId());
            pstmt.setString(3, customer.getPersonInCharge());
            pstmt.setString(4, customer.getPhoneNumber());
            pstmt.setTimestamp(5, dateNow);
            pstmt.setTimestamp(6, dateNow);
            
            return pstmt.executeUpdate();
	} catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        }finally{
            closeStatement();
        }
    }

    @Override
    public int upsert(CustomerModel customer) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(CustomerModel customer) {
        try {
            java.util.Date utilDate = new java.util.Date();
            java.sql.Timestamp dateNow = new java.sql.Timestamp(utilDate.getTime());
  
            query = "UPDATE customers " 
                    + "SET name = ?, segment_id = ?, person_in_charge = ?, phone_number = ?, updated_at = ? "
                    + "WHERE id = ?";

            pstmt = connection.prepareStatement(query);
            pstmt.setString(1, customer.getName());
            pstmt.setInt(2, customer.getSegmentId());
            pstmt.setString(3, customer.getPersonInCharge());
            pstmt.setString(4, customer.getPhoneNumber());
            pstmt.setTimestamp(5, dateNow);
            pstmt.setInt(6, customer.getId());
            
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
            query = "DELETE FROM customers WHERE id = ?";
            
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
    public List<CustomerModel> search(String keyword) {
        try {
            query = "SELECT customers.*, segments.name AS segment_name "
                    + "FROM customers "
                    + "INNER JOIN segments "
                    + "ON customers.segment_id = segments.id "
                    + "WHERE customers.name LIKE '%" + keyword + "%' "
                    + "OR segments.name LIKE '%" + keyword + "%' "
                    + "OR customers.person_in_charge LIKE '%" + keyword + "%' "
                    + "OR customers.phone_number LIKE '%" + keyword + "%' ";
            
            pstmt = connection.prepareStatement(query);
            resultSet = pstmt.executeQuery();
            
            List<CustomerModel> customers = new ArrayList<>();

            while (resultSet.next()) {
                CustomerModel customer = new CustomerModel();
                customer.setId(resultSet.getInt("id"));
                customer.setName(resultSet.getString("name"));
                customer.setSegmentId(resultSet.getInt("segment_id"));
                customer.setSegmentName(resultSet.getString("segment_name"));
                customer.setPersonInCharge(resultSet.getString("person_in_charge"));
                customer.setPhoneNumber(resultSet.getString("phone_number"));
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
    public List<SegmentMarketModel> getSegmentMarket() {
            try {
            query = "SELECT "
                    + "s.name AS segment_name, COUNT(c.id) AS customer_count, ROUND((COUNT(c.id) / (SELECT COUNT(*) FROM customers) * 100), 2) AS percentage "
                    + "FROM customers c "
                    + "INNER JOIN segments s ON c.segment_id = s.id "
                    + "GROUP BY s.name "
                    + "ORDER BY percentage DESC";
            
            pstmt = connection.prepareStatement(query);
            resultSet = pstmt.executeQuery();
            
            List<SegmentMarketModel> segmentsMarket = new ArrayList<>();

            while (resultSet.next()) {
                SegmentMarketModel segmentMarket = new SegmentMarketModel();
                segmentMarket.setSegmentName(resultSet.getString("segment_name"));
                segmentMarket.setCustomerCount(resultSet.getInt("customer_count"));
                segmentMarket.setPercentage(resultSet.getDouble("percentage"));
    
                segmentsMarket.add(segmentMarket);
            }
            return segmentsMarket;
	} catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        }finally{
            closeStatement();
        }
    }
    
}