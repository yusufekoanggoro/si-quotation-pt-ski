package application.dao;

import application.dao.interfaces.IEmployeeDao;
import application.databases.Mysql;
import application.models.EmployeeModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Timestamp;
import java.sql.Statement;
import java.util.Date;

public class EmployeeDao implements IEmployeeDao<EmployeeModel> {
    private Connection connection = null;
    private PreparedStatement pstmt = null;
    private ResultSet resultSet = null;
    private final Mysql mysql;

    private String query;
    
    public EmployeeDao() {
        this.mysql = new Mysql();
        connection = mysql.getConnection();
    }

    @Override
    public List<EmployeeModel> findAll() {
        try {
            query = "SELECT * FROM employees";
            pstmt = connection.prepareStatement(query);
            resultSet = pstmt.executeQuery();
            
            List<EmployeeModel> employees = new ArrayList<>();
            
            while (resultSet.next()) {
                EmployeeModel employee = new EmployeeModel();
                employee.setId(resultSet.getInt("id"));
                employee.setName(resultSet.getString("name"));
                employee.setGender(resultSet.getString("geder"));
                employees.add(employee);
            }  
            
            return employees;
	} catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        }finally{
            closeStatement();
        }
    }

    @Override
    public int create(EmployeeModel employee) {
        try {
            query = "INSERT INTO employees(name, gender, created_at, updated_at) VALUES(?, ?, ?, ?)";
            pstmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, employee.getName());
            pstmt.setString(2, employee.getGender());
            pstmt.setTimestamp(3, new Timestamp(new Date().getTime()));
            pstmt.setTimestamp(4, new Timestamp(new Date().getTime()));
            
            int result = pstmt.executeUpdate();
            resultSet = pstmt.getGeneratedKeys();
            
            if (resultSet.next()) {
                employee.setId(resultSet.getInt(1));
            }
            return result;
	} catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        }finally{
            closeStatement();
        }
    }

    @Override
    public int update(EmployeeModel employee) {
        try {
            query = "UPDATE employees SET name=?, gender=? WHERE id=?";
            pstmt = connection.prepareStatement(query);
            pstmt.setString(1, employee.getName());
            pstmt.setString(2, employee.getGender());
            return pstmt.executeUpdate();
	} catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        }finally{
            closeStatement();
        }
    }

    @Override
    public void delete(EmployeeModel employee) {
        try {
            query = "DELETE FROM users WHERE id=?";
            pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, employee.getId());
            pstmt.executeUpdate();
	} catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        }finally{
            closeStatement();
        }
    }

    @Override
    public List<EmployeeModel> findOne(EmployeeModel employee) {
        try {
            query = "SELECT * FROM employees WHERE id=?";
            System.out.println(employee.getId());
            pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, employee.getId());
            resultSet = pstmt.executeQuery();
            
            List<EmployeeModel> employees = new ArrayList<>();
            
            while (resultSet.next()) {
                employee.setId(resultSet.getInt("id"));
                employee.setName(resultSet.getString("name"));
                employee.setGender(resultSet.getString("gender"));
                employees.add(employee);
            }  
            
            return employees;
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
    public List<EmployeeModel> findOneByUsername(EmployeeModel employee) {
        try {
            query = "SELECT * FROM employees WHERE username=?";
            System.out.println(employee.getUsername());
            pstmt = connection.prepareStatement(query);
            pstmt.setString(1, employee.getUsername());
            resultSet = pstmt.executeQuery();
            
            List<EmployeeModel> employees = new ArrayList<>();
            
            while (resultSet.next()) {
                employee.setId(resultSet.getInt("id"));
                employee.setName(resultSet.getString("name"));
                employee.setGender(resultSet.getString("gender"));
                employees.add(employee);
            }  
            return employees;
	} catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        }finally{
            closeStatement();
        }
    }
}