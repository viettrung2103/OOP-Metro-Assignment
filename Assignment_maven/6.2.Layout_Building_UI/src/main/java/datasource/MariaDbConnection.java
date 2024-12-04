package datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MariaDbConnection {

    private static Connection conn = null;

    public static Connection getConnection() {
        // if there is no connection, connect to database
        if (conn == null) {
            try {
                conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/currency_converter?user=metrouser&password=password");
            } catch (SQLException e) {
                System.out.println("Connection failed");
                e.printStackTrace();
            }
            return conn;
        } else {
            return conn;
        }
    }

    public static void terminate() {
        try {
            getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
