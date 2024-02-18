package org.example;

import org.example.info.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {
    private List<MaxProjectCountClient> processMaxProjectsClientResultSet(ResultSet resultSet) throws SQLException {
        List<MaxProjectCountClient> result = new ArrayList<>();

        while (resultSet.next()) {
            MaxProjectCountClient client = new MaxProjectCountClient();
            client.setId(resultSet.getInt("ID"));
            client.setName(resultSet.getString("NAME"));
            client.setProjectCount(resultSet.getInt("project_count")); // Use the correct alias here
            result.add(client);
        }
        return result;
    }

    public List<LongestProject> findLongestProject(Database database) {
        try {
            String sqlFilePath = new Prefs().getString(Prefs.FIND_LONGEST_PROJECT_FILE_PATH);
            String sql = new String(Files.readAllBytes(Paths.get(sqlFilePath)));
            ResultSet resultSet = database.executeQuery(sql);
            return processLongestProjectResultSet(resultSet);
        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<MaxSalaryWorker> findMaxSalaryWorker(Database database) {
        try {
            String sqlFilePath = new Prefs().getString(Prefs.DB_FIND_MAX_SALARY_WORKER_PATH);
            String sql = new String(Files.readAllBytes(Paths.get(sqlFilePath)));
            ResultSet resultSet = database.executeQuery(sql);
            return processMaxSalaryWorkerResultSet(resultSet);
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<YoungestEldestWorkers> findYoungestOldestWorkers(Database database) {
        try {
            String sqlFilePath = new Prefs().getString(Prefs.DB_YOUNGEST_ELDEST_WORKER_PATH);
            String sql = new String(Files.readAllBytes(Paths.get(sqlFilePath)));
            ResultSet resultSet = database.executeQuery(sql);
            return processYoungestEldestWorkersResultSet(resultSet);
        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<PrintProjectPrices> printProjectPrices(Database database) {
        try {
            String sqlFilePath = new Prefs().getString(Prefs.PRINT_PROJECT_PRICES);
            String sql = new String(Files.readAllBytes(Paths.get(sqlFilePath)));
            ResultSet resultSet = database.executeQuery(sql);
            return processPrintProjectPricesResultSet(resultSet);
        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public List<MaxProjectCountClient> findMaxProjectsClient(Database database) {
        try {
            String sqlFilePath = new Prefs().getString(Prefs.DB_FIND_MAX_PROJECT_CLIENT_PATH);
            String sql = new String(Files.readAllBytes(Paths.get(sqlFilePath)));
            System.out.println("Executing SQL statement: " + sql);
            ResultSet resultSet = database.executeQuery(sql);
            return processMaxProjectsClientResultSet(resultSet);
        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private List<LongestProject> processLongestProjectResultSet(ResultSet resultSet) throws SQLException {
        List<LongestProject> result = new ArrayList<>();
        while (resultSet.next()) {
            LongestProject project = new LongestProject();
            project.setId(resultSet.getInt("id"));
            project.setDurationInMonths(resultSet.getInt("duration_in_months"));
            result.add(project);
        }
        return result;
    }

    private List<MaxSalaryWorker> processMaxSalaryWorkerResultSet(ResultSet resultSet) throws SQLException {
        List<MaxSalaryWorker> result = new ArrayList<>();
        while (resultSet.next()) {
            MaxSalaryWorker worker = new MaxSalaryWorker();
            worker.setName(resultSet.getString("name"));
            worker.setSalary(resultSet.getInt("salary"));
            result.add(worker);
        }
        return result;
    }

    private List<YoungestEldestWorkers> processYoungestEldestWorkersResultSet(ResultSet resultSet) throws SQLException {
        List<YoungestEldestWorkers> result = new ArrayList<>();
        while (resultSet.next()) {
            YoungestEldestWorkers worker = new YoungestEldestWorkers();
            worker.setName(resultSet.getString("NAME"));
            worker.setBirthday(resultSet.getDate("BIRTHDAY"));
            result.add(worker);
        }
        return result;
    }

    private List<PrintProjectPrices> processPrintProjectPricesResultSet(ResultSet resultSet) throws SQLException {
        List<PrintProjectPrices> result = new ArrayList<>();
        while (resultSet.next()) {
            PrintProjectPrices projectPrices = new PrintProjectPrices();
            projectPrices.setProjectId(resultSet.getInt("PROJECT_ID"));
            projectPrices.setClientName(resultSet.getString("CLIENT_NAME"));
            projectPrices.setProjectCost(resultSet.getInt("PROJECT_COST"));
            result.add(projectPrices);
        }
        return result;
    }
}
