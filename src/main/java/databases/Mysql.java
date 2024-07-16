package main.java.databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Mysql {
    
    private Connection connection;
    private final String DRIVER;
    private final String URL;
    private final String USERNAME;
    private final String PASSWORD;
    private final String MAX_POOL;
    private Properties properties;

    public Mysql(){
        try {
            this.connection = null;
            this.DRIVER = "com.mysql.cj.jdbc.Driver";
            this.URL = "jdbc:mysql://localhost:3306/quotations_management";
            this.USERNAME = "root";
            this.PASSWORD = "";
            this.MAX_POOL = "250";

            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, getProperties());
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }  
    }
    
    private Properties getProperties() {
        if (properties == null) {
            properties = new Properties();
            properties.setProperty("user", USERNAME);
            properties.setProperty("password", PASSWORD);
            properties.setProperty("MaxPooledStatements", MAX_POOL);
        }
        return properties;
    }
    
    public Connection getConnection(){
        return connection;
    }
  
}
