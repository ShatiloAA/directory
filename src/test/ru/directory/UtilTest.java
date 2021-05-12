package ru.directory;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UtilTest {


    private static final String PATH = "directory.txt";

    private static final City CITY1 = new City("Адыгейск", "Адыгея", "Южный", 12248, 1973);
    private static final City CITY2 = new City("Майкоп", "Адыгея", "Южный", 144246, 1857);
    private static final City CITY3 = new City("Горно-Алтайск", "Алтай", "Сибирский", 56928, 1830);

    List<City> testList = new ArrayList<>() {{
        add(CITY1);
        add(CITY2);
        add(CITY3);
    }};
    List<City> listFromFile;

    {
        try {
            listFromFile = Util.directoryReader(PATH);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test()
    void readFile() {
        assertEquals(testList, listFromFile);
    }

    @Test
    void dontReadFile() {
        FileNotFoundException exception = assertThrows(FileNotFoundException.class, () ->
                Util.directoryReader("blabla.txt"));
    }

    @Test
    void readEmptyFileOrDirectory() {
        String path = "empty.txt";
        FileNotFoundException exception = assertThrows(FileNotFoundException.class, () ->
                Util.directoryReader("empty.txt"));
        assertEquals("File " + path + " is not found, empty or directory!", exception.getMessage());
    }

    @Test
    void firstCaseOrdering() {
        List<City> orderedList = new ArrayList<>(testList);
        Collections.sort(orderedList, (o1, o2) -> o1.getName().compareTo(o2.getName()));
        assertEquals(orderedList, Util.ordering(testList, 1));
    }

    @Test
    void secondCaseOrdering() {
        List<City> orderedList = new ArrayList<>(testList);
        Collections.sort(orderedList, (o1, o2) -> {
            boolean compare = o1.getDistrict().compareTo(o2.getDistrict()) == 0;
            return o1.getDistrict().compareTo(o2.getDistrict()) == 0 ?
                    o1.getName().compareTo(o2.getName()) :
                    o1.getDistrict().compareTo(o2.getDistrict());
        });
        assertEquals(orderedList, Util.ordering(testList, 2));
    }

    @Test
    void searchForTheMostPopulatedCity() {
        City cityWithMaxPop = testList.stream().max(Comparator.comparing(City::getPopulation)).get();
        int maxPopulation = cityWithMaxPop.getPopulation();
        int index = testList.indexOf(cityWithMaxPop);
        assertEquals(index, Util.searchForTheMostPopulatedCity(testList));
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
        assertEquals(testMap, Util.findingTheNumberOfCitiesInRegions(testList));
    }
}