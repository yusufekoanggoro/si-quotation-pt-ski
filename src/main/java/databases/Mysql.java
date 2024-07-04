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
            this.DRIVER = System.getProperty("MYSQL_DRIVER");
            this.URL = System.getProperty("MYSQL_URL");
            this.USERNAME = System.getProperty("MYSQL_USERNAME");
            this.PASSWORD = System.getProperty("MYSQL_PASSWORD");
            this.MAX_POOL = System.getProperty("MYSQL_MAX_POOL");

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
