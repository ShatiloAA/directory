package ru.directory.services;

import ru.directory.model.City;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Order {

    public static List<City> orderByName(List<City> cities) {
        return cities.stream().sorted(Comparator.comparing(City::getName, String::compareToIgnoreCase))
                .collect(Collectors.toList());
    }

    public static List<City> orderByDistrictThenByName(List<City> cities) {
        return cities.stream().sorted(Comparator.comparing(City::getDistrict).thenComparing(City::getName))
                .collect(Collectors.toList());
    }
}
