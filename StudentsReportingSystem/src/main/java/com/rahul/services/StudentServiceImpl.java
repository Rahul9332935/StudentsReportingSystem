package com.rahul.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rahul.exceptions.StudentsExceptions;
import com.rahul.model.Student;
import com.rahul.repo.StudentRepository;
@Service
public class StudentServiceImpl  implements StudentService{

	@Autowired
	 private StudentRepository studentRepository;
	
	
	@Override
	public Student saveStudent(Student student) {
		
		return  studentRepository.save(student);
	}

	@Override
	public List<Student> getAllStudents() throws StudentsExceptions {
		List<Student> students= studentRepository.findAll();
		
		if(students.isEmpty()) {
			throw new StudentsExceptions("No data available");
		}
		return students;
	}

	@Override
	public Student getStudentById(Integer id) throws StudentsExceptions {
		Optional<Student> student= studentRepository.findById(id);
		if(student.isEmpty()) {
			throw new StudentsExceptions("wrong student id");
		}
		return student.get();
	}

}
