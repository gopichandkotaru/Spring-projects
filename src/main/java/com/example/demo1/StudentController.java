package com.example.demo1;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class StudentController {


    @Autowired
    private StudentRepository studentRepo;

    @GetMapping("/getAllStudents")
    public ResponseEntity<List<Student>> getAllStudents() {
        try {
            List<Student> studentsList = new ArrayList<>();
            studentRepo.findAll().forEach(studentsList::add);
            System.out.println("Student list" + studentsList);

            if (studentsList.isEmpty()) {
                return new ResponseEntity<>(studentsList, HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(studentsList,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    
    @PostMapping("/createStudent")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
    	//student.setFirstName("naresh");
    	//student.setLastName("naresh");
    	//student.setEmail("n@gmail.com");
    	Student studentObj = studentRepo.save(student);


        return new ResponseEntity<>(studentObj, HttpStatus.OK);
    }
    
}