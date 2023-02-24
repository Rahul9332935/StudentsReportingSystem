package com.rahul.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rahul.exceptions.SemestersExceptions;
import com.rahul.model.Semester;
import com.rahul.repo.SemesterRepository;


@Service
public class SemesterServiceImpl implements SemesterService {

	@Autowired
    private SemesterRepository semesterRepository;
	
	
	@Override
	public Semester saveSemester(Semester semester) {
		
		return semesterRepository.save(semester);
	}

	@Override
	public List<Semester> getAllSemesters() throws SemestersExceptions {
		List<Semester> semesters= semesterRepository.findAll();
		if(semesters.isEmpty()) {
			throw new SemestersExceptions("Not data found"); 
		}
		return semesters;
	}

	@Override
	public Semester getSemesterById(Integer id) throws SemestersExceptions {
		Optional<Semester> op= semesterRepository.findById(id);
		if(op.isEmpty()) {
			throw new SemestersExceptions("wrong id");
		}
		return op.get();
	}

	
	
	
}
