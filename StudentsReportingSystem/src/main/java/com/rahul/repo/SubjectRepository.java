package com.rahul.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rahul.model.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {
}
