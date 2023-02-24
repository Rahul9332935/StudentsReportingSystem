package com.rahul.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rahul.exceptions.MarksExceptions;
import com.rahul.model.Marks;
import com.rahul.model.Semester;
import com.rahul.model.Student;
import com.rahul.model.Subject;
import com.rahul.repo.MarksRepository;



@Service
public class MarksServiceImpl implements MarksService {

	 @Autowired
	  private MarksRepository marksRepository;
	
	@Override
	public Marks saveMarks(Marks marks) {
		
		return marksRepository.save(marks);
	}

	@Override
	public List<Marks> getMarksByStudentAndSemester(Student student, Semester semester) throws MarksExceptions {
		List<Marks> marks= marksRepository.findByStudentAndSemester(student, semester);
		
		if(marks.isEmpty()) {
			throw new MarksExceptions( "No data found");
		}
		
		return marks;
	}

	@Override
	public Double getAverageMarksBySubjectAndSemester(Subject subject, Semester semester) {
		
		return marksRepository.findAverageMarksBySubjectAndSemester(subject, semester);
	}

	@Override
	public List<Object[]> getTop2ConsistentStudents() throws MarksExceptions {
		List<Object[]> objects= marksRepository.findTop2ConsistentStudents();
		
		if(objects.isEmpty()) {
			throw new MarksExceptions( "No data found");
		}
		
		
		return objects;
	}
	@Override
	public List<Marks> getMarksBySemester(Semester semester) {
        return marksRepository.findBySemester(semester);
    }
	
	public List<Marks> getMarksBySubject(Subject subject) {
        return marksRepository.findBySubject(subject);
    }

}
