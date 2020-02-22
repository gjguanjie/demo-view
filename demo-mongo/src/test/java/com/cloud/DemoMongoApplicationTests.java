package com.cloud;

import com.cloud.entity.Person;
import com.cloud.repository.PersonRepository;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoMongoApplicationTests {

    @Resource
    private PersonRepository personRepository;

    @Resource
    private MongoTemplate mongoTemplate;

    @Test
    public void save() {
        Person person = new Person();
        person.setId(1L);
        person.setAge(1);
        person.setCellNum("123456789011");
        person.setLastName("123");
        person.setWord("11");
        Person person1 = new Person();
        person1.setId(2L);
        person1.setAge(1);
        person1.setCellNum("123456789011");
        person1.setLastName("123");
        person1.setWord("11");
        personRepository.save(person);
        personRepository.save(person1);
    }

    @Test
    public void find() {
        Person person = new Person();
        person.setCellNum("123456789011");
        person.setLastName("123");
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("cell_num", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("last_name", ExampleMatcher.GenericPropertyMatchers.contains());
        Example<Person> example = Example.of(person,matcher);
        Pageable pageable = PageRequest.of(0,10);
        Page<Person> page = personRepository.findAll(example,pageable);
        System.out.println(page.getNumber());
    }

}
