package com.rahul.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rahul.model.Marks;
import com.rahul.model.Semester;
import com.rahul.model.Student;
import com.rahul.model.Subject;

@Repository
public interface MarksRepository extends JpaRepository<Marks, Integer> {
	
	
	 List<Marks> findBySemester(Semester semester);
	
	 List<Marks> findBySubject(Subject subject);
	
    // Query method to retrieve Marks by Student and Semester
    List<Marks> findByStudentAndSemester(Student student, Semester semester);
    
    // Query method to retrieve average marks of a Subject in a Semester
    @Query("SELECT AVG(m.marks) FROM Marks m WHERE m.subject = :subject AND m.semester = :semester")
    Double findAverageMarksBySubjectAndSemester(@Param("subject") Subject subject, @Param("semester") Semester semester);
    
    // Query method to retrieve top 2 consistent students with the highest average marks across all Semesters
    @Query(value = "SELECT m.student_id, s.name, AVG(m.marks) as average_marks FROM marks m INNER JOIN students s ON m.student_id = s.id GROUP BY m.student_id, s.name ORDER BY average_marks DESC LIMIT 2", nativeQuery = true)
    List<Object[]> findTop2ConsistentStudents();
}
