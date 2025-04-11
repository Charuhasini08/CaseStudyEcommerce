package util;

import java.sql.*;

public class DBConnUtil {
    private static Connection conn = null;

    public static Connection getConnection(String fileName) {
        if (conn == null) {
            try {
                String url = DBPropertyUtil.getPropertyString(fileName);
                conn = DriverManager.getConnection(url);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }
}
