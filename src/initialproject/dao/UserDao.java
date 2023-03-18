package initialproject.dao;

import initialproject.databases.Mysql;
import initialproject.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Timestamp;
import java.sql.Statement;
import java.util.Date;

public class UserDao implements InterfaceDao<User> {
    private Connection connection = null;
    private PreparedStatement pstmt = null;
    private ResultSet resultSet = null;

    private final List<User> users = new ArrayList<>();
    
    private String query;
    
    public UserDao() {
        Mysql mysql = new Mysql();
        connection = mysql.getConnection();
    }

    @Override
    public List<User> findAll() {
        try {
            query = "SELECT * FROM users";
            pstmt = connection.prepareStatement(query);
            resultSet = pstmt.executeQuery();
            
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setAge(resultSet.getInt("age"));
                users.add(user);
            }  
            
            return users;
	} catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public int create(User u) {
        try {
            query = "INSERT INTO users(name, age, created_at, updated_at) VALUES(?, ?, ?, ?)";
            pstmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, u.getName());
            pstmt.setInt(2, u.getAge());
            pstmt.setTimestamp(3, new Timestamp(new Date().getTime()));
            pstmt.setTimestamp(4, new Timestamp(new Date().getTime()));
            
            int result = pstmt.executeUpdate();
            resultSet = pstmt.getGeneratedKeys();
            
            if (resultSet.next()) {
                u.setId(resultSet.getInt(1));
            }
            return result;
	} catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public int update(User u) {
        try {
            query = "UPDATE users SET name=?, age=? WHERE id=?";
            pstmt = connection.prepareStatement(query);
            pstmt.setString(1, u.getName());
            pstmt.setInt(2, u.getAge());
            return pstmt.executeUpdate();
	} catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(User u) {
        try {
            query = "DELETE FROM users WHERE id=?";
            pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, u.getId());
            pstmt.executeUpdate();
	} catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public User findOne(User u) {
        try {
            query = "SELECT * FROM users WHERE id=?";
            System.out.println(u.getId());
            pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, u.getId());
            resultSet = pstmt.executeQuery();
            
            while (resultSet.next()) {
                u.setId(resultSet.getInt("id"));
                u.setName(resultSet.getString("name"));
                u.setAge(resultSet.getInt("age"));
                users.add(u);
            }  
            
            return users.get(0);
	} catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    
    @Override
    public void close() {
        try {
            if(connection != null){
                connection.close();
            }
            if(pstmt != null){
                pstmt.close();
            }
            if(resultSet != null){
                resultSet.close();
            }   
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
