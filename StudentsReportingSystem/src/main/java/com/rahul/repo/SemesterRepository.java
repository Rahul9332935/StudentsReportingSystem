package com.rahul.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rahul.model.Semester;

@Repository
public interface SemesterRepository extends JpaRepository<Semester, Integer> {
}

