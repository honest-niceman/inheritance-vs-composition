package com.example.inheritancevscomposition.business;

import com.example.inheritancevscomposition.entities.Author;
import com.example.inheritancevscomposition.mappedsupperclasses.BaseEntityAuditAddress;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BusinessTest {
    @Test
    void getCountriesTest() {
        List<BaseEntityAuditAddress> authors = new ArrayList<>();

        Author author = new Author();
        author.setFirstName("Petr");
        author.setLastName("Ivanov");
        author.setCountry("Russia");

        Author author1 = new Author();
        author1.setFirstName("John");
        author1.setLastName("Doe");
        author1.setCountry("USA");

        Author author2 = new Author();
        author2.setFirstName("Wan");
        author2.setLastName("Li");
        author2.setCountry("China");

        authors.add(author);
        authors.add(author1);
        authors.add(author2);

        List<String> countries = new Business().getCountries(authors);

        assertNotNull(countries);
        assertFalse(countries.isEmpty());
    }
}