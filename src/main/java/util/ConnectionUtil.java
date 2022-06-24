package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Cannot load JDBC driver for MySQL, " + e);
        }
    }

    public static Connection getConnection() {
        try {
            Properties properties = new Properties();
            properties.put("user", "root");
            properties.put("password", "3900");
            return DriverManager
                    .getConnection("jdbc:mysql://localhost:3307/taxi_service", properties);
        } catch (SQLException e) {
            throw new RuntimeException("Cannot create connection to MySQL, " + e);
        }
    }
}