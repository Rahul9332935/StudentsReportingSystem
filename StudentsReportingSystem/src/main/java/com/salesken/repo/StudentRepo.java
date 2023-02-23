package com.salesken.repo;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.salesken.model.Student;

@Repository
public interface StudentRepo extends ElasticsearchRepository<Student, Integer> {

}
