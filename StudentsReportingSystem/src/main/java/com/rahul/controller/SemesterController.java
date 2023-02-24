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

import com.rahul.exceptions.SemestersExceptions;
import com.rahul.model.Semester;
import com.rahul.services.SemesterService;

@RestController
public class SemesterController {
	
	
	 @Autowired
	  private SemesterService semesterService;
	
	// Endpoint to add a new Semester
    @PostMapping("/semesters")
    public ResponseEntity<Semester> addSemester(@RequestBody Semester semester) {
        
        return new ResponseEntity<Semester>(semesterService.saveSemester(semester), HttpStatus.ACCEPTED);
    }
    
    @GetMapping("/semesters")
    public ResponseEntity<List<Semester>> getAllSemesters() throws SemestersExceptions {
    	List<Semester> semesters = semesterService.getAllSemesters();
    	    return new ResponseEntity<List<Semester>>(semesters, HttpStatus.OK);
    	
    }
    
 // Endpoint to get a Semester by id
    @GetMapping("/semesters/{id}")
    public ResponseEntity<Semester> getSemesterById(@PathVariable Integer id) throws SemestersExceptions {
        Semester semester = semesterService.getSemesterById(id);
        return new ResponseEntity<Semester>(semester, HttpStatus.OK);
    }
    
    

}
