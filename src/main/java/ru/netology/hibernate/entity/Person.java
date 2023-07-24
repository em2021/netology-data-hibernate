package ru.netology.hibernate.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "persons", schema = "hibernate")
public class Person implements Serializable {

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