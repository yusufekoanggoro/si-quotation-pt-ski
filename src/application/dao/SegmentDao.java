package application.dao;

import application.dao.interfaces.ISegmentDao;
import application.databases.Mysql;
import application.models.EmployeeModel;
import application.models.SegmentModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Statement;

public class SegmentDao implements ISegmentDao {
    
    private Connection connection = null;
    private PreparedStatement pstmt = null;
    private ResultSet resultSet = null;
    private final Mysql mysql;
    private String query;
    
    public SegmentDao() {
        this.mysql = new Mysql();
        this.connection = mysql.getConnection();
    }

    @Override
    public List<SegmentModel> findOneById(SegmentModel model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public SegmentModel findOneByUsername(SegmentModel model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<SegmentModel> findAll() {
        try {
            query = "SELECT * FROM segments";
            pstmt = connection.prepareStatement(query);
            resultSet = pstmt.executeQuery();
            
            List<SegmentModel> segments = new ArrayList<>();
            
            while (resultSet.next()) {
                SegmentModel segment = new SegmentModel();
                segment.setId(resultSet.getInt("id"));
                segment.setName(resultSet.getString("name"));
                segments.add(segment);
            }
            return segments;
	} catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        }finally{
            closeStatement();
        }
    }

    @Override
    public int create(SegmentModel model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int upsert(SegmentModel model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(SegmentModel model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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