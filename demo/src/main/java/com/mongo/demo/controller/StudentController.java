package com.mongo.demo.controller;

import com.mongo.demo.entity.Student;
import com.mongo.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping("/create")
    public Student createStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }

    @GetMapping("/getById/{id}")
    public Student getById(@PathVariable String id){
        return studentService.getById(id).isPresent() ? studentService.getById(id).get():null ;
    }
    @GetMapping("/getAll")
    public List<Student> getAll(){
        return studentService.getAll();
    }
    @PutMapping("/update")
    public Student update(@RequestBody Student student){
        return studentService.update(student);
    }
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable String id){
        studentService.delete(id);
        return "Student deleted";
    }


}