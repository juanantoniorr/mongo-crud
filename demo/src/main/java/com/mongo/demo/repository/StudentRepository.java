package com.mongo.demo.repository;

import com.mongo.demo.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends MongoRepository<Student,String>{
    List<Student> findByName(String name);
    Student findByNameAndMail(String name, String mail);
    Student findByNameOrMail(String name, String mail);
    //Find subdocuments
    List<Student> findByDepartmentDepartmentName(String departmentName);
    List<Student> findByMailIsLike(String mail);

}

