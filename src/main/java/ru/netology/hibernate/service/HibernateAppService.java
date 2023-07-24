package ru.netology.hibernate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.netology.hibernate.entity.Person;
import ru.netology.hibernate.repository.HibernateAppRepository;

import java.util.List;

@Service
public class HibernateAppService {

    @Autowired
    HibernateAppRepository hibernateAppRepository;

    public List<Person> getPersonsByCity(String city) {
        return hibernateAppRepository.getPersonsByCity(city);
    }
}