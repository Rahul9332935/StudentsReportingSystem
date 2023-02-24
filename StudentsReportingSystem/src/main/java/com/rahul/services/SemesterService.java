package com.rahul.services;

import java.util.List;

import com.rahul.exceptions.SemestersExceptions;
import com.rahul.model.Semester;

public interface SemesterService {

	
	public Semester saveSemester(Semester semester);
	
	public List<Semester> getAllSemesters() throws SemestersExceptions;
	
	public Semester getSemesterById(Integer id) throws SemestersExceptions;
	
}
