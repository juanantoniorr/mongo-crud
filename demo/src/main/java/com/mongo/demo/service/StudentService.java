package com.mongo.demo.service;

import com.mongo.demo.entity.Student;
import com.mongo.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService  {
    @Autowired
    StudentRepository studentRepository;
    public Student createStudent(Student student){
        return  studentRepository.save(student);
    }

    public Optional<Student> getById(String id){
        return  studentRepository.findById(id);
    }
    public List<Student> getAll(){
        return studentRepository.findAll();
    }
    public Student update(Student student){
        return studentRepository.save(student);
    }

    public void delete(String id){
        studentRepository.deleteById(id);
    }

    public List<Student> getByName(String name){
        return studentRepository.findByName(name);
    }

    public Student getByNameAndMail(String name, String email){
        return studentRepository.findByNameAndMail(name,email);
    }
    public Student getByNameOrMail(String name, String email){
        return studentRepository.findByNameOrMail(name,email);
    }
}
