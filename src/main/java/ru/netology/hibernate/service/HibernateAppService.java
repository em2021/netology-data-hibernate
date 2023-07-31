package ru.netology.hibernate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.netology.hibernate.entity.Person;
import ru.netology.hibernate.exception.NoSuchEntityException;
import ru.netology.hibernate.repository.PersonJpaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class HibernateAppService {

    @Autowired
    PersonJpaRepository personJpaRepository;

    public List<Person> findByCity(String city) {
        var people = personJpaRepository.findByCity(city);
        if (people.isEmpty() || people.get().isEmpty()) {
            throw new NoSuchEntityException("No people from \"" + city + "\" city");
        }
        return people.get();
    }

    public List<Person> findByLessThanAgeOrderByAgeAsc(Integer age) {
        var people = personJpaRepository
                .findByAgeLessThanOrderByAgeAsc(age, Sort.by(Sort.Direction.ASC, "age"));
        if (people.isEmpty() || people.get().isEmpty()) {
            throw new NoSuchEntityException("No people under age " + age);
        }
        return people.get();
    }

    public Optional<Person> findByNameAndSurname(String name, String surname) {
        var personOpt = personJpaRepository.findByNameAndSurname(name, surname);
        if (personOpt.isEmpty()) {
            throw new NoSuchEntityException("No people matching the name \"" + name
                    + "\" and surname \"" + surname + "\"");
        }
        return personOpt;
    }

    public List<Person> findAll() {
        var people = personJpaRepository.findAll();
        if (people.isEmpty()) {
            throw new NoSuchEntityException("Database is empty");
        }
        return people;
    }
}