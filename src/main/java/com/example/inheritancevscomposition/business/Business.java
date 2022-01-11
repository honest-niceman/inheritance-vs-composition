package com.example.inheritancevscomposition.business;

import com.example.inheritancevscomposition.mappedsupperclasses.BaseEntityAuditAddress;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Business {
    public List<String> getCountries(List<BaseEntityAuditAddress> addressableEntities) {
        if (addressableEntities == null || addressableEntities.isEmpty()) {
            return Collections.emptyList();
        }
        return addressableEntities.stream()
                .map(BaseEntityAuditAddress::getCountry)
                .distinct()
                .collect(Collectors.toList());
    }
}
