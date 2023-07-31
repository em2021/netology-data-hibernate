package ru.netology.hibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.hibernate.entity.Person;
import ru.netology.hibernate.exception.NoSuchEntityException;
import ru.netology.hibernate.service.HibernateAppService;

import java.util.List;
import java.util.Optional;

@RestController
public class HibernateAppController {

    @Autowired
    HibernateAppService hibernateAppService;

    @RequestMapping("/persons/by-city")
    public List<Person> getPersonByCity(String city) {
        var person = hibernateAppService.findByCity(city);
        if (person.isEmpty()) {
            throw new NoSuchEntityException("City doesn't exist");
        }
        return person;
    }

    @RequestMapping("/persons/by-age")
    public List<Person> findByAgeLessThanOrderByAgeAsc(Integer age) {
        return hibernateAppService.findByLessThanAgeOrderByAgeAsc(age);
    }

    @RequestMapping("/persons/by-name-surname")
    public Optional<Person> findByNameAndSurname(String name, String surname) {
        return hibernateAppService.findByNameAndSurname(name, surname);
    }
}