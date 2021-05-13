package services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.directory.model.City;
import ru.directory.services.Searcher;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static services.util.UtilForTests.*;

class SearcherTest {

    @Test
    void searchForTheMostPopulatedCity() {
        City cityWithMaxPop = testList.stream().max(Comparator.comparing(City::getPopulation)).get();
        int maxPopulation = cityWithMaxPop.getPopulation();
        int index = testList.indexOf(cityWithMaxPop);
        Assertions.assertEquals(index, Searcher.searchForTheMostPopulatedCity(testList));
        assertEquals(maxPopulation, testList.get(index).getPopulation());
    }

    @Test
    void findingTheNumberOfCitiesInRegions() {
        List<String> regions = testList.stream().map(City::getRegion).distinct().collect(Collectors.toList());
        Map<String, Integer> testMap = new HashMap<>();
        for (String x : regions) {
            int count = 0;
            for (City c : testList) {
                if (c.getRegion().equals(x)) {
                    count++;
                }
            }
            testMap.put(x, count);
        }
        assertEquals(testMap, Searcher.findingTheNumberOfCitiesInRegions(testList));
    }
}