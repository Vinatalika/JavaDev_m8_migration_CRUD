package org.example;

import lombok.Getter;
import java.sql.*;

public class Database {
    @Getter
    private static final Database INSTANCE = new Database();
    @Getter
    private Connection connection;

    private Database() {
        try {
            connection = DriverManager.getConnection("jdbc:h2:./test", "sa", "");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String getConnectionUrl() {
        return "jdbc:h2:./test";
    }

    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
