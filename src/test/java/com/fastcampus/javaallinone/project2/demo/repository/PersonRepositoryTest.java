package com.fastcampus.javaallinone.project2.demo.repository;

import com.fastcampus.javaallinone.project2.demo.domain.Person;
import org.hibernate.hql.internal.ast.tree.IntoClause;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    @Test
    void crud(){

        Person person = new Person();
        person.setName("martin");
        person.setAge(10);
        person.setBloodType("A");
        //person.isBlock();

        personRepository.save(person);

        System.out.println(personRepository.findAll());

        List<Person> people = personRepository.findAll();

        assertThat(people.size()).isEqualTo(1);
        assertThat(people.get(0).getName()).isEqualTo("martin");
        assertThat(people.get(0).getAge()).isEqualTo(10);
        assertThat(people.get(0).getBloodType()).isEqualTo("A");

    }

    @Test
    void hashCodeAndEquals(){
        Person person1 = new Person("martin",10, "A");
        Person person2 = new Person("martin",10, "A");

        System.out.println(person1.equals(person2));
        System.out.println(person1.hashCode());
        System.out.println(person2.hashCode());

        Map<Person, Integer> map = new HashMap<>();
        map.put(person1, person1.getAge());

        System.out.println(map);
        System.out.println(map.get(person2)); //해시코드가 다르기에 null -> hashcode() 메서드처럼 작성하면 10 가져옴 또는 어노테이션
    }

}