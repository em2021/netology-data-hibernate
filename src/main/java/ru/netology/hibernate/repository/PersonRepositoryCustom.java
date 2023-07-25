package ru.netology.hibernate.repository;

import ru.netology.hibernate.entity.Person;

import java.util.List;
import java.util.Optional;

public interface PersonRepositoryCustom {
    Optional<List<Person>> findByCity(String city);

    Optional<List<Person>> findByAgeLessThanOrderByAgeDesc(Integer age);

    Optional<Person> findByNameAndSurname(String name, String surname);
}