package initialproject.databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class db {
    
    private static final String DRIVER = "org.mariadb.jdbc.Driver";
    private static final String SERVER = System.getProperty("SERVER");
    private static final String PORT = System.getProperty("PORT");
    private static final String DATABASE = System.getProperty("DATABASE");    
    private static final String URL = "jdbc:mysql://"+SERVER+":"+PORT+"/"+DATABASE ;
    private static final String USERNAME = System.getProperty("USERNAME");
    private static final String PASSWORD = System.getProperty("PASSWORD");
    
    
    public static Connection buatKoneksi() {
        Connection conn = null;
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);   
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Koneksi gagal");
            e.printStackTrace();
    
        }
        return conn;
    }
}
