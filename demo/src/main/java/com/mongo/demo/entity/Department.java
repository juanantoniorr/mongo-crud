package com.mongo.demo.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
//No need to annotate this class as is a subdocument
public class Department {
    @Field(name = "department_name")
    String departmentName;
    String location;
}
