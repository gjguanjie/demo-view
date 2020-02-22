package com.cloud.repository;

import com.cloud.entity.Person;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface PersonRepository extends MongoRepository<Person,Long> {

}
