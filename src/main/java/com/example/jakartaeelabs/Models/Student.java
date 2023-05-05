package com.example.jakartaeelabs.Models;

import java.util.UUID;

public class Student {
    private String group;
    private String firstName;
    private String lastName;
    private final String id;

    public Student(String group, String firstName, String lastName) {
        this.group = group;
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}