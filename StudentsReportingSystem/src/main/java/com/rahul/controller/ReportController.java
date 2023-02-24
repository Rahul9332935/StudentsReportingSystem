package com.rahul.controller;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rahul.exceptions.MarksExceptions;
import com.rahul.exceptions.SemestersExceptions;
import com.rahul.exceptions.SubjectsExceptions;
import com.rahul.model.Marks;
import com.rahul.model.Semester;
import com.rahul.model.Subject;
import com.rahul.services.MarksService;
import com.rahul.services.SemesterService;
import com.rahul.services.SubjectService;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/api")
public class ReportController {

	
    
    @Autowired
    private SemesterService semesterService;
    
    @Autowired
    private SubjectService subjectService;
	 @Autowired
	 private MarksService marksService;
	
	@PostMapping("/marks")
	public ResponseEntity<Marks> addMarks(@RequestBody Marks marks) {
	    
	    return new ResponseEntity<Marks>(marksService.saveMarks(marks), HttpStatus.ACCEPTED);
	}

	// End point to get average percentage of whole class in recent semester
	@GetMapping("/reports/averagePercentage")
	public ResponseEntity<Double> getAveragePercentage() throws SemestersExceptions {
	    // get the latest semester
	    List<Semester> semesters = semesterService.getAllSemesters();
	    Semester latestSemester = semesters.stream()
	        .max(Comparator.comparing(Semester::getId))
	        .orElseThrow(() -> new EntityNotFoundException("No semesters found"));
	    
	    // calculate the average percentage
	    List<Marks> marks = marksService.getMarksBySemester(latestSemester);
	    double totalMarks =0;
	    for(Marks a: marks) {
	    	totalMarks=totalMarks+a.getMarks();
	    }
	    
	    Double totalPossibleMarks = marks.size() * 300.0; // assuming 100 marks per subject
	    Double percentage = (totalMarks / totalPossibleMarks) * 100;
	    return ResponseEntity.ok(percentage);
	}

	// End point to get average marks of students in a subject
	@GetMapping("/reports/averageMarks/{subjectId}")
	public ResponseEntity<Double> getAverageMarksBySubject(@PathVariable Integer subjectId) throws SubjectsExceptions {
	    Subject subject = subjectService.getSubjectById(subjectId);
	    
	    // calculate the average marks
	    List<Marks> marks = marksService.getMarksBySubject(subject);
	    Double averageMarks = 0.0;
	    
	    if(marks.size()>0) {
	    	for(Marks m: marks) {
	    		averageMarks =averageMarks+m.getMarks();
	    	}
	    }
	    averageMarks=averageMarks/marks.size();
	    return new ResponseEntity<Double>(averageMarks, HttpStatus.OK);
	}

	// End point to get top 2 consistent students across all semesters
	@GetMapping("/reports/top2ConsistentStudents")
	public ResponseEntity<List<Object[]>> getTop2ConsistentStudents() throws MarksExceptions {
	    List<Object[]> top2Students = marksService.getTop2ConsistentStudents();
	    return ResponseEntity.ok(top2Students);
	}
}
