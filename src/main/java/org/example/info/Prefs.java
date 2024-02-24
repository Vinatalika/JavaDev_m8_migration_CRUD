package org.example.info;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Prefs {
    public static final String DB_FIND_MAX_PROJECT_CLIENT_PATH = "findMaxProjectsClient";
    public static final String DB_FIND_MAX_SALARY_WORKER_PATH = "findMaxSalaryWorker";
    public static final String DB_YOUNGEST_ELDEST_WORKER_PATH = "findYoungestEldestWorkers";
    public static final String INIT_DB_FILE_PATH = "initDbSql";
    public static final String FIND_LONGEST_PROJECT_FILE_PATH = "findLongestProject";
    public static final String PRINT_PROJECT_PRICES = "printProjectsPrices";
    public static final String POPULATE_DB_FILE_PATH = "populateDbSql";
    public static final String DEFAULT_PREFS_FILENAME = "prefs.json";
    private Map<String, Object> prefs = new HashMap<>();

    public Prefs() {
        this(DEFAULT_PREFS_FILENAME);
    }

    public Prefs(String filename) {
        try {
            String json = String.join("\n",
                    Files.readAllLines(Paths.get(filename)));

            TypeToken<Map<String, Object>> typeToken = new TypeToken<Map<String, Object>>() {};
            prefs = new Gson().fromJson(json, typeToken.getType());

            String contentRoot = System.getProperty("user.dir");
            prefs.forEach((key, value) -> {
                if (value instanceof String) {
                    String path = (String) value;
                    prefs.put(key, Paths.get(contentRoot, path).toAbsolutePath().toString());
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getString(String key) {
        Object value = getPref(key);

        if (value == null) {
            throw new RuntimeException("Value for key '" + key + "' is null.");
        }

        return value.toString();
    }

    public Object getPref(String key) {
        return prefs.get(key);
    }

}
