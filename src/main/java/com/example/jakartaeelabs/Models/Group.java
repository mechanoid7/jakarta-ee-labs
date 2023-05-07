package com.example.jakartaeelabs.Models;

import java.util.UUID;

public class Group {
    private String name;
    private final String id;

    public Group(String name) {
        this.name = name;
        this.id = UUID.randomUUID().toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }
}
