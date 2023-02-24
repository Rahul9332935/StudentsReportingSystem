package com.rahul.services;

import java.util.List;

import com.rahul.exceptions.MarksExceptions;
import com.rahul.model.Marks;
import com.rahul.model.Semester;
import com.rahul.model.Student;
import com.rahul.model.Subject;

public interface MarksService {
	
	public Marks saveMarks(Marks marks);
	
	public List<Marks> getMarksByStudentAndSemester(Student student, Semester semester) throws MarksExceptions;
	
	public Double getAverageMarksBySubjectAndSemester(Subject subject, Semester semester);
	
	public List<Object[]> getTop2ConsistentStudents() throws MarksExceptions;
	
	public List<Marks> getMarksBySemester(Semester semester);
	
	public List<Marks> getMarksBySubject(Subject subject);

}
