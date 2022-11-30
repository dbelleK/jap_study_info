package com.fastcampus.javaallinone.project2.demo.service;

import com.fastcampus.javaallinone.project2.demo.domain.Block;
import com.fastcampus.javaallinone.project2.demo.domain.Person;
import com.fastcampus.javaallinone.project2.demo.repository.BlockRepository;
import com.fastcampus.javaallinone.project2.demo.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonServiceTest {

    @Autowired
    private PersonService personService;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private BlockRepository blockRepository;

    @Test
    void getPeopleExcludeBlocks(){
        givenPeople();
       // givenBlocks();

        List<Person> result = personService.getPeopleExcludeBlocks();

        //martin이라는 이름 제거하고 출력, (martin만 제거)
        //System.out.println(result);
        result.forEach(System.out::println);
    }

    @Test
    void getPeopleByName(){
        givenPeople();

        List<Person> result = personService.getPeopleByName("martin");
        result.forEach(System.out::println);
    }

    @Test
    void casecadeTest(){

        givenPeople();

        List<Person> result = personRepository.findAll();
        result.forEach(System.out::println);

        Person person = result.get(3);
        person.getBlock().setStartDate(LocalDate.now());
        person.getBlock().setEndDate(LocalDate.now());

        personRepository.save(person);
        personRepository.findAll().forEach(System.out::println);

/*        personRepository.delete(person);
        personRepository.findAll().forEach(System.out::println);
        blockRepository.findAll().forEach(System.out::println);*/

        person.setBlock(null);
        personRepository.save(person);
        personRepository.findAll().forEach(System.out::println);
        blockRepository.findAll().forEach(System.out::println);
    }

    @Test
    void getPerson(){

        givenPeople();
        Person person = personService.getPerson(3L);
        System.out.println(person);

    }

    private void givenPeople() {

        givenPerson("martin",1,"A");
        givenPerson("david",9,"B");
        givenPerson("dennis",7,"O");
        givenBlockPerson("martin",11,"AB");
    }

/*    private void givenBlocks() {

        givenBlock("martin");
    }*/


    private void givenPerson(String name, int age, String bloodType) {
        personRepository.save(new Person(name,age,bloodType));
    }

    private void givenBlockPerson(String name, int age, String bloodType){
        Person blockPerson = new Person(name, age, bloodType);
        //blockPerson.setBlock(givenBlock(name));
        blockPerson.setBlock(new Block(name));

        personRepository.save(blockPerson);
    }

/*    private Block givenBlock(String name) {
        return blockRepository.save(new Block(name));
    }*/

}