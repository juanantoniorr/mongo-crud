package com.mongo.demo.controller;

import com.mongo.demo.entity.Student;
import com.mongo.demo.service.StudentService;
import com.mongo.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    @Autowired
    StudentService studentService;
    @Autowired
    TeacherService teacherService;

    @PostMapping("/create")
    public Student createStudent(@RequestBody Student student) {
        if (student.getTeacher()!=null){
        teacherService.createTeacher(student.getTeacher());
        }
        return studentService.createStudent(student);
    }

    @GetMapping("/getById/{id}")
    public Student getById(@PathVariable String id) {
        return studentService.getById(id).isPresent() ? studentService.getById(id).get() : null;
    }

    @GetMapping("/getAll")
    public List<Student> getAll() {
        return studentService.getAll();
    }

    @PutMapping("/update")
    public Student update(@RequestBody Student student) {
        return studentService.update(student);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable String id) {
        studentService.delete(id);
        return "Student deleted";
    }

    @GetMapping("/getByName/{name}")
    public List<Student> getStudentByName(@PathVariable String name) {
        return studentService.getByName(name);
    }

    @GetMapping("/getByNameAndMail")
    public Student getByNameAndMail(@RequestParam String name, @RequestParam String mail) {
        return studentService.getByNameAndMail(name, mail);
    }

    @GetMapping("/getByNameOrMail")
    public Student getByNameOrMail(@RequestParam String name, @RequestParam String mail) {
        return studentService.getByNameOrMail(name, mail);
    }

    @GetMapping("/getAllWithPagination")
    public List<Student> getAllWithPagination(@RequestParam int pageNo,
                                      @RequestParam int pageSize){
    return studentService.getAllWithPagination(pageNo,pageSize);
    }

    @GetMapping("/getAllWithSorting")
    public List<Student> getAllWithSorting(){
        return studentService.getAllWithSorting();
    }
    @GetMapping("/getByDepartmentName")
    public List<Student> getByDepartmentName(@RequestParam String departmentName){
return studentService.getByDepartmentName(departmentName);
    }

    @GetMapping("/mailLike")
    public List<Student> getByMailLike(@RequestParam String mail){
    return studentService.getByMailLike(mail);
    }
}
