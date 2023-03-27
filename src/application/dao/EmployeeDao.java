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
import java.sql.Statement;

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
            query = "INSERT INTO employees(name, gender, place_of_birth, date_of_birth, address, " +
                    "religion, status, phone_number, join_date, username, password, created_at, updated_at, role_id) " +
                    "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) " +
                    "ON DUPLICATE KEY UPDATE name=VALUES(name), gender=VALUES(gender), place_of_birth=VALUES(place_of_birth), " +
                    "date_of_birth=VALUES(date_of_birth), address=VALUES(address), religion=VALUES(religion), status=VALUES(status), " +
                    "phone_number=VALUES(phone_number), join_date=VALUES(join_date), username=VALUES(username), password=VALUES(password), " +
                    "created_at=VALUES(created_at), updated_at=VALUES(updated_at), role_id=VALUES(role_id)";
            pstmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, employee.getName());
            pstmt.setString(2, employee.getGender());
            pstmt.setString(3, employee.getPlaceOfBirth());
            pstmt.setDate(4, employee.getDateOfBirth());
            pstmt.setString(5, employee.getAddress());
            pstmt.setString(6, employee.getReligion());
            pstmt.setString(7, employee.getStatus());
            pstmt.setString(8, employee.getPhoneNumber());
            pstmt.setDate(9, employee.getJoinDate());
            pstmt.setString(10, employee.getUsername());
            pstmt.setString(11, employee.getPassword());
            pstmt.setDate(12, employee.getCreatedAt());
            pstmt.setDate(13, employee.getUpdatedAt());
            pstmt.setInt(14, employee.getRoleId());
            
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
    public EmployeeModel findOneByUsername(EmployeeModel employee) {
        try {
            query = "SELECT * FROM employees WHERE username=?";
            System.out.println(employee.getUsername());
            pstmt = connection.prepareStatement(query);
            pstmt.setString(1, employee.getUsername());
            resultSet = pstmt.executeQuery();
            
            if(resultSet.next()){
                employee.setId(resultSet.getInt("id"));
                employee.setName(resultSet.getString("name"));
                employee.setGender(resultSet.getString("gender"));
                employee.setPassword(resultSet.getString("password"));
                return employee;
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