package com.fastcampus.javaallinone.project2.demo.domain;

import com.fastcampus.javaallinone.project2.demo.dto.Birthday;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
//@Getter
//@Setter
//@ToString
@NoArgsConstructor // 생성자 생성
@AllArgsConstructor
@RequiredArgsConstructor
//@EqualsAndHashCode
@Data //위 주석 포함
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private int age;

    private String hobby;

    @NonNull
    private String bloodType;

    private String address;

    //@Valid
    @Embedded
    private Birthday birthday;

    private String job;

    @ToString.Exclude
    private String phoneNumber;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private Block block;



}
