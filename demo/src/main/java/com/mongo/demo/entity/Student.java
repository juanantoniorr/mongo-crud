package com.mongo.demo.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Getter
@Setter
@Document
public class Student {
    @Id
    private String id;
    private String name;
    private String password;
    private String mail;
    private Department department;
    private List<Subject> subjects;
    @DBRef(lazy = true)
    private Teacher teacher;
}
