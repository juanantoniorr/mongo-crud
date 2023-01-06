package com.mongo.demo.auth;

import com.mongo.demo.details.CustomUserDetails;
import com.mongo.demo.entity.Student;
import com.mongo.demo.repository.StudentRepository;
import com.mongo.demo.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthenticationService {

    @Autowired
    private  StudentRepository studentRepository;

    @Autowired
    private  JwtService jwtService;

    @Autowired
    private  AuthenticationManager authenticationManager;

    @Autowired
    PasswordEncoder passwordEncoder;

    public AuthenticationResponse register(RegisterRequest registerRequest){
    var student = Student.builder()
            .name(registerRequest.getFirstName())
            .mail(registerRequest.getMail())
            .password(passwordEncoder.encode(registerRequest.getPassword()))
            .build();
    studentRepository.save(student);
    var jwt = jwtService.generateToken(new CustomUserDetails(student));
    return AuthenticationResponse.builder()
            .token(jwt)
            .build();
    }


    public AuthenticationResponse authenticate(AuthenticationRequest request){
        authenticationManager.authenticate(
              new UsernamePasswordAuthenticationToken(
                      request.getUser(),
                      request.getPassword()
              )

        );
        //After is correctly authenticated lets create a jwt
        List<Student> students = studentRepository.findByName(request.getUser());
        Student student = null;
        if (!students.isEmpty()){
            student = students.get(0);
        }
        return new AuthenticationResponse(jwtService.generateToken(new CustomUserDetails(student)));
    }
}
