package ru.netology.hibernate.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.netology.hibernate.entity.Person;

import java.util.List;
import java.util.Optional;

public interface PersonRepositoryCustom {
    @Query(("select p from Person p where p.city = :city"))
    Optional<List<Person>> findByCity(@Param("city") String city);

    @Query(("select p from Person p where p.age < :age"))
    Optional<List<Person>> findByAgeLessThanOrderByAgeAsc(@Param("age") Integer age, Sort sort);

    @Query(("select p from Person p where p.name = :name and p.surname = :surname"))
    Optional<Person> findByNameAndSurname(@Param("name") String name, @Param("surname") String surname);
}