package org.example;

import org.example.info.Prefs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DatabasePopulateService {
    public void populateDb (Database database) {

        try {
            String populateDbFileName = new Prefs().getString(Prefs.POPULATE_DB_FILE_PATH);
            String sql = String.join("\n",
                    Files.readAllLines(Paths.get(populateDbFileName)));

            database.executeUpdate(sql);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}