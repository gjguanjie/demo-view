package com.cloud.repository;

import com.cloud.entity.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

//@Repository("personRepository")
public interface PersonRepository extends MongoRepository<Person,Long> {

}
