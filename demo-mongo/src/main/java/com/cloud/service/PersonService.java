package com.cloud.service;

import com.cloud.entity.Person;
import com.cloud.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

//@Service("personService")
public class PersonService {

    @Resource
    private PersonRepository  personRepository;

    public void save(Person person) {
        personRepository.save(person);
    }

    public void saveAll(List<Person> list) {
        personRepository.saveAll(list);
    }

    public void delete(Person person) {
        personRepository.delete(person);
    }

    public void deleteById(Long id) {
        personRepository.deleteById(id);
    }

    public void deleteAll() {
        personRepository.deleteAll();
    }
    public Page<Person> findPageByCondition(Person person, Pageable pageable) {
        Example<Person> example = getMatcher(person);
        return personRepository.findAll(example,pageable);
    }

    public Example<Person> getMatcher(Person person) {
        ExampleMatcher matcher = ExampleMatcher.matching().withIgnorePaths("word");
        if (!StringUtils.isEmpty(person.getCellNum())) {
            matcher.withMatcher("materialName", ExampleMatcher.GenericPropertyMatchers.contains()); //姓名采用“开始匹配”的方式查询
        }
        if (!ObjectUtils.isEmpty(person.getAge())) {
            matcher.withMatcher("age",ExampleMatcher.GenericPropertyMatchers.contains());
        }
        if (!StringUtils.isEmpty(person.getLastName())) {
            matcher.withMatcher("lastName",ExampleMatcher.GenericPropertyMatchers.contains());
        }
        Example<Person> example = Example.of(person, matcher);
        return example;
    }

}
