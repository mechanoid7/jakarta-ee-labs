package com.example.jakartaeelabs.Models;

import java.util.List;
import java.util.UUID;

public class Group {
    private String name;
    private List<Student> students;
    private final String id;


    public Group(String name, List<Student> students) {
        this.name = name;
        this.students = students;
        this.id = UUID.randomUUID().toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
