package ru.netology.hibernate.repository;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import ru.netology.hibernate.entity.Person;
import ru.netology.hibernate.exception.NoSuchCityException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class HibernateAppRepository {

    @PersistenceContext
    EntityManager entityManager;
    String sql = read("script.sql");

    @SuppressWarnings("unchecked")
    public List<Person> getPersonsByCity(String city) {
        List<Person> people = entityManager
                .createNativeQuery(sql)
                .setParameter("city", city)
                .getResultList();
        if (people.isEmpty()) {
            throw new NoSuchCityException("City doesn't exist");
        }
        return people;
    }

    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}