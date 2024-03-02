package org.example;

import org.example.client.Client;
import org.example.client.ClientService;
import org.example.info.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Database database = Database.getINSTANCE();

        try {
            new DatabaseInitService().initDb(database.getConnectionUrl());

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


            // Перевірка сервісу для CRUD операцій
            System.out.println("=========================");
            System.out.println("\nClient CRUD Operations:");

            // Додавання нового клієнта з іменем name
            ClientService clientService = new ClientService(database.getConnection());
            long clientId = clientService.create("New Client Name");
            System.out.println("New Client ID: " + clientId);

            // Повернення назви клієнта з ідентифікатором id
            String clientName = clientService.getById(clientId);
            System.out.println("Client Name for ID " + clientId + ": " + clientName);

            // Встановлення нового ім'я name для клієнта з ідентифікатором id
            clientService.setName(clientId, "Updated Name");
            String updatedClientName = clientService.getById(clientId);
            System.out.println("Updated Client Name for ID " + clientId + ": " + updatedClientName);

            //  Видалення клієнта з ідентифікатором id
            clientService.deleteById(clientId);

            // Повернення всіх клієнтів
            List<Client> allClients = clientService.listAll();
            System.out.println("All Clients:");
            allClients.forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            database.closeConnection();
        }
    }
}

