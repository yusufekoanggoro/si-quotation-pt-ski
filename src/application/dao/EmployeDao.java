package application.dao;

import application.databases.Mysql;
import application.models.EmployeModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Timestamp;
import java.sql.Statement;
import java.util.Date;

public class EmployeDao implements InterfaceDao<EmployeModel> {
    private Connection connection = null;
    private PreparedStatement pstmt = null;
    private ResultSet resultSet = null;

    private final List<EmployeModel> employes = new ArrayList<>();
    
    private String query;
    
    public EmployeDao() {
        Mysql mysql = new Mysql();
        mysql.connect();
        connection = mysql.getConnection();
    }

    @Override
    public List<EmployeModel> findAll() {
        try {
            query = "SELECT * FROM employes";
            pstmt = connection.prepareStatement(query);
            resultSet = pstmt.executeQuery();
            
            while (resultSet.next()) {
                EmployeModel employe = new EmployeModel();
                employe.setId(resultSet.getInt("id"));
                employe.setName(resultSet.getString("name"));
                employe.setGender(resultSet.getString("geder"));
                employes.add(employe);
            }  
            
            return employes;
	} catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        }finally{
            closeStatement();
        }
    }

    @Override
    public int create(EmployeModel employe) {
        try {
            query = "INSERT INTO employes(name, gender, created_at, updated_at) VALUES(?, ?, ?, ?)";
            pstmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, employe.getName());
            pstmt.setString(2, employe.getGender());
            pstmt.setTimestamp(3, new Timestamp(new Date().getTime()));
            pstmt.setTimestamp(4, new Timestamp(new Date().getTime()));
            
            int result = pstmt.executeUpdate();
            resultSet = pstmt.getGeneratedKeys();
            
            if (resultSet.next()) {
                employe.setId(resultSet.getInt(1));
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
    public int update(EmployeModel employe) {
        try {
            query = "UPDATE employes SET name=?, gender=? WHERE id=?";
            pstmt = connection.prepareStatement(query);
            pstmt.setString(1, employe.getName());
            pstmt.setString(2, employe.getGender());
            return pstmt.executeUpdate();
	} catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        }finally{
            closeStatement();
        }
    }

    @Override
    public void delete(EmployeModel employe) {
        try {
            query = "DELETE FROM users WHERE id=?";
            pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, employe.getId());
            pstmt.executeUpdate();
	} catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        }finally{
            closeStatement();
        }
    }

    @Override
    public EmployeModel findOne(EmployeModel employe) {
        try {
            query = "SELECT * FROM employes WHERE id=?";
            System.out.println(employe.getId());
            pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, employe.getId());
            resultSet = pstmt.executeQuery();
            
            while (resultSet.next()) {
                employe.setId(resultSet.getInt("id"));
                employe.setName(resultSet.getString("name"));
                employe.setGender(resultSet.getString("gender"));
                employes.add(employe);
            }  
            
            return employes.get(0);
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
}