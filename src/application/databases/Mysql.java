package application.databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Mysql {
    
    private static final String DRIVER = System.getProperty("MYSQL_DRIVER");
    private static final String URL = System.getProperty("MYSQL_URL");
    private static final String USERNAME = System.getProperty("MYSQL_USERNAME");
    private static final String PASSWORD = System.getProperty("MYSQL_PASSWORD");;
    private static final String MAX_POOL = System.getProperty("MYSQL_MAX_POOL");
    
    private static Connection connection = null;
    private Properties properties;
    
    public void connect(){
        try {
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
