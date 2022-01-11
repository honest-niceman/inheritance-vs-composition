package com.example.inheritancevscomposition.business;

import com.example.inheritancevscomposition.embeddables.BaseEntityAddress;
import com.example.inheritancevscomposition.interfaces.EntityWithAddressFields;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Business {
    public List<String> getCountries(List<EntityWithAddressFields> addressableEntities) {
        if (addressableEntities == null || addressableEntities.isEmpty()) {
            return Collections.emptyList();
        }
        return addressableEntities.stream()
                .map(EntityWithAddressFields::getBaseEntityAddress)
                .map(BaseEntityAddress::getCountry)
                .distinct()
                .collect(Collectors.toList());
    }
}
