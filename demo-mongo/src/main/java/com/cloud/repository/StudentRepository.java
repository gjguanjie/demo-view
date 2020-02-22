package com.cloud.repository;

import com.cloud.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student,Long> {
}
