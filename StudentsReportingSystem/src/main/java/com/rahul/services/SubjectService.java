package com.rahul.services;

import java.util.List;

import com.rahul.exceptions.SubjectsExceptions;
import com.rahul.model.Subject;

public interface SubjectService {
	
	public Subject saveSubject(Subject subject);
	
	public List<Subject> getAllSubjects() throws SubjectsExceptions;
	
	 public Subject getSubjectById(Integer id) throws SubjectsExceptions;

}
