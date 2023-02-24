package com.rahul.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rahul.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}

