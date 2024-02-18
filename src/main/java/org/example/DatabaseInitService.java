package org.example;

import org.example.info.Prefs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DatabaseInitService {
    public void initDb(Database database) {

        try {
            String initDbFileName = new Prefs().getString(Prefs.INIT_DB_FILE_PATH);
            String sql = String.join("\n",
                    Files.readAllLines(Paths.get(initDbFileName)));

            database.executeUpdate(sql);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
