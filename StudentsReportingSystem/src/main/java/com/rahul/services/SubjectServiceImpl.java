package com.rahul.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rahul.exceptions.SubjectsExceptions;
import com.rahul.model.Subject;
import com.rahul.repo.SubjectRepository;

@Service
public class SubjectServiceImpl  implements SubjectService{

	
	 @Autowired
	    private SubjectRepository subjectRepository;
	
	@Override
	public Subject saveSubject(Subject subject) {
		
		return subjectRepository.save(subject);
	}

	@Override
	public List<Subject> getAllSubjects() throws SubjectsExceptions {
		List<Subject> subjects= subjectRepository.findAll();
		
		if(subjects.isEmpty()) {
			throw new SubjectsExceptions("data is not available");
		}
		return subjects;
	}

	@Override
	public Subject getSubjectById(Integer id) throws SubjectsExceptions {
		
		return subjectRepository.findById(id).orElseThrow(() -> new SubjectsExceptions("Subject not found with id: " + id));
	}

}
