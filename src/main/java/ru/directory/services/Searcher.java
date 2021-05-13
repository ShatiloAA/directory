package ru.directory.services;

import ru.directory.model.City;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Searcher {

    public static int searchForTheMostPopulatedCity(List<City> cities) {
        City[] arrayCities = cities.toArray(new City[cities.size()]);
        //City city = cities.stream().max(Comparator.comparingInt(City::getPopulation)).get();
        int index = 0;
        int max = 0;
        int population;
        for (int i = 0; i < arrayCities.length; i++) {
            population = arrayCities[i].getPopulation();
            if (population > max) {
                max = population;
                index = i;
            }
        }
        return index;
    }

    public static Map<String, Integer> findingTheNumberOfCitiesInRegions(List<City> cities) {
        Map<String, Integer> regionsAndCities = new HashMap<>();
        //cities.forEach(c -> regionsAndCities.merge(c.getRegion(), 1, Integer::sum ));
        List<String> keys = cities.stream().map(City::getRegion).distinct().collect(Collectors.toList());
        for (String x : keys) {
            int count = cities.stream().filter(a -> a.getRegion().equals(x)).mapToInt(a -> 1).sum();
            regionsAndCities.put(x, count);
        }
        return regionsAndCities;
    }
}
