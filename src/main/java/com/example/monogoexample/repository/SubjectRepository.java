package com.example.monogoexample.repository;

import com.example.monogoexample.entity.Subject;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends MongoRepository<Subject,String> {
}
