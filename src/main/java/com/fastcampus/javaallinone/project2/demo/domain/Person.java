package com.fastcampus.javaallinone.project2.demo.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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

    private String birthday;

    private String job;

    @ToString.Exclude
    private String phoneNumber;

    //hascode는 다르지만 문자열이 같아면 true 반환
/*    public boolean equals(Object object){
        if(object == null){
            return false;
        }
        Person person = (Person) object;

        if(!person.getName().equals(this.getName())){
            return false;
        }
        if(person.getAge() != this.getAge()){
            return false;
        }
        return true;
    }

    public int hashCode(){
        return (name+age).hashCode();
    }*/


}
