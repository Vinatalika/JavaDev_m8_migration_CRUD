package org.example;

import org.example.info.Prefs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabasePopulateService {

    public void populateDb(Database database) {
        try {
            String populateDbFileName = new Prefs().getString(Prefs.POPULATE_DB_FILE_PATH);
            String sql = String.join("\n", Files.readAllLines(Paths.get(populateDbFileName)));

            // Використання PreparedStatement
            try (PreparedStatement preparedStatement = database.getConnection().prepareStatement(sql)) {
                preparedStatement.executeUpdate();
            }

        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
