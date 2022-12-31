package com.mongo.demo.service;

import com.mongo.demo.entity.Teacher;
import com.mongo.demo.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {
    @Autowired
    TeacherRepository teacherRepository;

    public Teacher createTeacher(Teacher teacher){
        return teacherRepository.save(teacher);
    }
}
