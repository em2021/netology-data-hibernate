package ru.netology.jdbc.repository;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import ru.netology.jdbc.exception.NoSuchCustomerException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class JdbcRepository {

    @PersistenceContext
    EntityManager entityManager;
    private String sql = read("script.sql");

    @SuppressWarnings("unchecked")
    public List<String> getProductName(String name) throws SQLException {
        List<String> productNamesList = entityManager
                .createNativeQuery(sql)
                .setParameter("name", name)
                .getResultList();
        if (productNamesList.isEmpty()) {
            throw new NoSuchCustomerException("Customer doesn't exist.");
        }
        return productNamesList;
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