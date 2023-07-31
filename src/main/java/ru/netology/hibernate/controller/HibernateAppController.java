package ru.netology.hibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.hibernate.entity.Person;
import ru.netology.hibernate.exception.NoSuchEntityException;
import ru.netology.hibernate.service.HibernateAppService;

import javax.annotation.security.RolesAllowed;
import java.util.List;
import java.util.Optional;

@RestController
public class HibernateAppController {

    @Autowired
    HibernateAppService hibernateAppService;

    @RequestMapping("/persons/by-city")
    @Secured({"ROLE_READ"})
    public List<Person> getPersonByCity(String city) {
        var person = hibernateAppService.findByCity(city);
        if (person.isEmpty()) {
            throw new NoSuchEntityException("City doesn't exist");
        }
        return person;
    }

    @RequestMapping("/persons/by-age")
    @RolesAllowed({"ROLE_WRITE"})
    public List<Person> findByAgeLessThanOrderByAgeAsc(Integer age) {
        return hibernateAppService.findByLessThanAgeOrderByAgeAsc(age);
    }

    @RequestMapping("/persons/by-name-surname")
    @PreAuthorize("hasRole('ROLE_WRITE') or hasRole('ROLE_DELETE')")
    public Optional<Person> findByNameAndSurname(String name, String surname) {
        return hibernateAppService.findByNameAndSurname(name, surname);
    }

    @RequestMapping("/persons/find-all")
    @PreAuthorize("#username == authentication.principal.username")
    public List<Person> findAll(String username) {
        return hibernateAppService.findAll();
    }
}