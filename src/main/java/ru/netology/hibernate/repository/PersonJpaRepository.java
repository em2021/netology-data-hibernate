package ru.netology.hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.netology.hibernate.entity.Person;

@Repository
public interface PersonJpaRepository extends JpaRepository<Person, Integer>, PersonRepositoryCustom {

}