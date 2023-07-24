package ru.netology.hibernate.entity;

import lombok.AllArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
public class PersonId implements Serializable {

    private String name;
    private String surname;
    private int age;
}