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

import com.rahul.exceptions.SubjectsExceptions;
import com.rahul.model.Subject;
import com.rahul.services.SubjectService;

@RestController
public class SubjectController {
	
	@Autowired
    private SubjectService subjectService;

	// End point to add a new Subject
	
	@PostMapping("/subjects")
	public ResponseEntity<Subject> addSubject(@RequestBody Subject subject) {
	    
	    return new ResponseEntity<Subject>(subjectService.saveSubject(subject), HttpStatus.ACCEPTED);
	}

	// End point to get all Subjects
	@GetMapping("/subjects")
	public ResponseEntity<List<Subject>> getAllSubjects() throws SubjectsExceptions {
	    List<Subject> subjects = subjectService.getAllSubjects();
	    return new ResponseEntity<List<Subject>>(subjects, HttpStatus.OK);
	}

	// End point to get a Subject by id
	@GetMapping("/subjects/{id}")
	public ResponseEntity<Subject> getSubjectById(@PathVariable Integer id) throws SubjectsExceptions {
	    Subject subject = subjectService.getSubjectById(id);
	    return new ResponseEntity<Subject>(subject, HttpStatus.OK);
	}

}
