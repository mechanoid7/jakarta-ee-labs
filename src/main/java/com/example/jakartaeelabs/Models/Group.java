package com.example.jakartaeelabs.Models;

import java.util.UUID;

public class Group {
    private String name;
    private final String id;

    public Group(String name) {
        this.name = name;
        this.id = UUID.randomUUID().toString();
    }

    public Group(String name, String id) {
        this.name = name;
        this.id = id;
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
