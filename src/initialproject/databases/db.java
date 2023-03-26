package initialproject.databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class db {
    
    private static final String DRIVER = "org.mariadb.jdbc.Driver";
    private static final String URL = "jdbc:mysql://103.241.24.82:3306/caranyabegini_login";
    private static final String USERNAME = "caranyabegini_caranyabegini";
    private static final String PASSWORD = "jakarta1928!";

    public static Connection buatKoneksi() {
        Connection conn = null;
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Koneksi berhasil");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Koneksi gagal");
            e.printStackTrace();
        }
        return conn;
    }
}
