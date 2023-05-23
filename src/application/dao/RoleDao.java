package application.dao;

import application.dao.interfaces.IRoleDao;
import application.databases.Mysql;
import application.models.RoleModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Statement;

public class RoleDao implements IRoleDao {
    
    private Connection connection = null;
    private PreparedStatement pstmt = null;
    private ResultSet resultSet = null;
    private String query;
    
    public RoleDao() {
        this.connection = new Mysql().getConnection();
    }

    @Override
    public RoleModel findOneById(RoleModel role) {
        try {
            query = "SELECT * FROM roles " 
                    + "WHERE id=?";
            
            pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, role.getId());
            
            resultSet = pstmt.executeQuery();
            if(resultSet.next()){
                role.setId(resultSet.getInt("id"));
                role.setName(resultSet.getString("name"));
                role.setPeriode(resultSet.getString("periode"));
                return role;
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
    public RoleModel findOneByUsername(RoleModel role) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public RoleModel findOneByName(RoleModel role) {
        try {
            query = "SELECT * FROM roles " 
                    + "WHERE name=?";
            
            pstmt = connection.prepareStatement(query);
            pstmt.setString(1, role.getName());
            
            resultSet = pstmt.executeQuery();
            if(resultSet.next()){
                role.setId(resultSet.getInt("id"));
                role.setName(resultSet.getString("name"));
                role.setPeriode(resultSet.getString("periode"));
                return role;
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
    public List<RoleModel> findAll() {
        try {
            query = "SELECT * FROM roles";
            pstmt = connection.prepareStatement(query);
            resultSet = pstmt.executeQuery();
            
            List<RoleModel> roles = new ArrayList<>();

            while (resultSet.next()) {
                RoleModel role = new RoleModel();
                role.setId(resultSet.getInt("id"));
                role.setName(resultSet.getString("name"));
                role.setPeriode(resultSet.getString("periode"));
                roles.add(role);
            }
            return roles;
	} catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        }finally{
            closeStatement();
        }
    }

    @Override
    public int create(RoleModel customer) {
        try {
            
            java.util.Date utilDate = new java.util.Date();
            java.sql.Timestamp dateNow = new java.sql.Timestamp(utilDate.getTime());
        
            query = "INSERT INTO roles(name, periode, created_at, updated_at) "
                    + "VALUES(?, ?, ?, ?)";
            
            pstmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, customer.getName());
            pstmt.setString(2, customer.getPeriode());
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
    public int upsert(RoleModel role) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(RoleModel role) {
        try {
            java.util.Date utilDate = new java.util.Date();
            java.sql.Timestamp dateNow = new java.sql.Timestamp(utilDate.getTime());
  
            query = "UPDATE roles " 
                    + "SET name = ?, periode = ?, updated_at = ? "
                    + "WHERE id = ?";

            pstmt = connection.prepareStatement(query);
            pstmt.setString(1, role.getName());
            pstmt.setString(2, role.getPeriode());
            pstmt.setTimestamp(3, dateNow);
            pstmt.setInt(4, role.getId());
            
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
            query = "DELETE FROM roles WHERE id = ?";
            
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
    public List<RoleModel> search(String keyword) {
            try {
            query = "SELECT * "
                    + "FROM roles "
                    + "WHERE name LIKE '%" + keyword + "%' "
                    + "OR periode LIKE '%" + keyword + "%' ";
            
            pstmt = connection.prepareStatement(query);
            resultSet = pstmt.executeQuery();
            
            List<RoleModel> roles = new ArrayList<>();

            while (resultSet.next()) {
                RoleModel role = new RoleModel();
                role.setId(resultSet.getInt("id"));
                role.setName(resultSet.getString("name"));
                role.setPeriode(resultSet.getString("periode"));
                roles.add(role);
            }
            return roles;
	} catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        }finally{
            closeStatement();
        }
    }
    
}