package org.example.client;


import lombok.Data;

@Data
public class Client {
    private String name;
    private long id;

    public Client(long id, String name) {
        this.id = id;
        this.name = name;
    }
}
