package com.fastcampus.javaallinone.project2.demo.repository;

import com.fastcampus.javaallinone.project2.demo.domain.Block;
import com.fastcampus.javaallinone.project2.demo.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlockRepository extends JpaRepository<Block,Long> {
}
