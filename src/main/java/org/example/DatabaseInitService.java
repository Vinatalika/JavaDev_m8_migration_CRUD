package org.example;

import org.example.info.Prefs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseInitService {

    public void initDb(Database database) {
        try {
            String initDbFileName = new Prefs().getString(Prefs.INIT_DB_FILE_PATH);
            String sql = String.join("\n", Files.readAllLines(Paths.get(initDbFileName)));

            // Використання PreparedStatement
            try (PreparedStatement preparedStatement = database.getConnection().prepareStatement(sql)) {
                preparedStatement.executeUpdate();
            }

        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
