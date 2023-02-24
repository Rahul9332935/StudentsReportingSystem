package com.rahul.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rahul.exceptions.StudentsExceptions;

import com.rahul.model.Student;
import com.rahul.services.StudentService;
@RestController

public class StudentController {
	
	@Autowired
    private StudentService studentService;
    
	// Endpoint to add a new Student
    @PostMapping("/students")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        
        return new ResponseEntity<Student>(studentService.saveStudent(student), HttpStatus.OK);
    }
    
    // Endpoint to get all Students
    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents() throws StudentsExceptions {
        List<Student> students = studentService.getAllStudents();
        return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
    }
    
    // Endpoint to get a Student by id
    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Integer id) throws StudentsExceptions {
        Student student = studentService.getStudentById(id);
        return new ResponseEntity<Student>(student, HttpStatus.OK);
    }
    
    
}
