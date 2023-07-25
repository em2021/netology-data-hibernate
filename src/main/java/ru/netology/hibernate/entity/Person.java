package ru.netology.hibernate.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@IdClass(PersonId.class)
@Table(name = "persons", schema = "hibernate")
public class Person {

    @Id
    @Column(nullable = false, length = 255)
    private String name;
    @Id
    @Column(nullable = false)
    private String surname;
    @Id
    @Column(nullable = false)
    private int age;
    @Column(nullable = false)
    private String phonenumber;
    @Column(name = "city_of_living")
    private String city;
}