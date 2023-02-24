package com.rahul.services;

import java.util.List;

import com.rahul.exceptions.StudentsExceptions;
import com.rahul.model.Student;

public interface StudentService  {
	
	public Student saveStudent(Student student);
	
	public List<Student> getAllStudents() throws StudentsExceptions;
	
	public Student getStudentById(Integer id) throws StudentsExceptions;

}
