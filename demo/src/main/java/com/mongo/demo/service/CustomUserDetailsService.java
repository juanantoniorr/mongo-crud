package com.mongo.demo.service;

import com.mongo.demo.entity.Student;
import com.mongo.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
   private  StudentRepository studentRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<Student> studentList = studentRepository.findByName(username);
        Student student = null;
        if (!studentList.isEmpty()){
            student = studentList.get(0);
        } else {
            throw new UsernameNotFoundException("User not found");
        }
        return new User(student.getName(), student.getPassword(), new ArrayList<>());
    }
}
