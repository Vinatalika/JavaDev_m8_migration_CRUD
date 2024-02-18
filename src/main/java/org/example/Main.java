package org.example;

import org.example.info.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Database database = Database.getINSTANCE();

        try {
            new DatabaseInitService().initDb(database);
            new DatabasePopulateService().populateDb(database);

            // Перевірка методу findLongestProject
            System.out.println("Longest Projects:");
            List<LongestProject> longestProjects = new DatabaseQueryService().findLongestProject(database);
            longestProjects.forEach(System.out::println);

            // Перевірка методу findMaxProjectsClient
            System.out.println("\nMax Project Count Clients:");
            List<MaxProjectCountClient> maxProjectCountClients = new DatabaseQueryService().findMaxProjectsClient(database);
            maxProjectCountClients.forEach(System.out::println);

            // Перевірка методу findMaxSalaryWorker
            System.out.println("\nMax Salary Workers:");
            List<MaxSalaryWorker> maxSalaryWorkers = new DatabaseQueryService().findMaxSalaryWorker(database);
            maxSalaryWorkers.forEach(System.out::println);

            // Перевірка методу findYoungestEldestWorkers
            System.out.println("\nYoungest Eldest Workers:");
            List<YoungestEldestWorkers> youngestEldestWorkers = new DatabaseQueryService().findYoungestOldestWorkers(database);
            youngestEldestWorkers.forEach(System.out::println);

            // Перевірка методу printProjectPrices
            System.out.println("\nPrint Project Prices:");
            List<PrintProjectPrices> projectPricesList = new DatabaseQueryService().printProjectPrices(database);
            projectPricesList.forEach(System.out::println);


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            database.closeConnection();
        }
    }
}
