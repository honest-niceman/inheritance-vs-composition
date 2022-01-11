package com.example.inheritancevscomposition.business;

import com.example.inheritancevscomposition.embeddables.BaseEntityAddress;
import com.example.inheritancevscomposition.entities.Author;
import com.example.inheritancevscomposition.interfaces.EntityWithAddressFields;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BusinessTest {
    @Test
    void getCountriesTest() {
        List<EntityWithAddressFields> authors = new ArrayList<>();


        Author author = new Author();
        author.setFirstName("Petr");
        author.setLastName("Ivanov");

        BaseEntityAddress baseEntityAddress = new BaseEntityAddress();
        baseEntityAddress.setCountry("Russia");

        author.setBaseEntityAddress(baseEntityAddress);

        Author author1 = new Author();
        author1.setFirstName("John");
        author1.setLastName("Doe");

        BaseEntityAddress baseEntityAddress1 = new BaseEntityAddress();
        baseEntityAddress1.setCountry("USA");

        author1.setBaseEntityAddress(baseEntityAddress1);

        Author author2 = new Author();
        author2.setFirstName("Wan");
        author2.setLastName("Li");

        BaseEntityAddress baseEntityAddress2 = new BaseEntityAddress();
        baseEntityAddress2.setCountry("China");

        author2.setBaseEntityAddress(baseEntityAddress2);

        authors.add(author);
        authors.add(author1);
        authors.add(author2);

        List<String> countries = new Business().getCountries(authors);

        assertNotNull(countries);
        assertFalse(countries.isEmpty());
    }
}