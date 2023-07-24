package ru.netology.hibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.hibernate.entity.Person;
import ru.netology.hibernate.service.HibernateAppService;

import java.util.List;

@RestController
public class HibernateAppController {

    @Autowired
    HibernateAppService hibernateAppService;

    @RequestMapping("/persons/by-city")
    public List<Person> getPersonsByCity(String city) {
        return hibernateAppService.getPersonsByCity(city);
    }
}