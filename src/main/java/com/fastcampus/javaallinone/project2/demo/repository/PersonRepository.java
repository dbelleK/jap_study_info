package com.fastcampus.javaallinone.project2.demo.repository;

import com.fastcampus.javaallinone.project2.demo.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Long> {


}
