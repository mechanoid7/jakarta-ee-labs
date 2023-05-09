package com.example.jakartaeelabs.Models;

import java.util.UUID;

public class Group {
    private String name;
    private final Integer id;

    public Group(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }
}
