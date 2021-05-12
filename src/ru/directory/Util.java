package ru.directory;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class Util {

    public final static String DEMARCATION_LINE = "=======================";

    public static List<City> directoryReader(String path) throws FileNotFoundException {
        List<City> cities = new ArrayList<>();
        File file = new File(path);
        if (file.length() > 0 && !file.isDirectory()) {
            try (Scanner scanner = new Scanner(file);) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] values = line.substring(line.indexOf(";") + 1, line.length()).split(";");
                    cities.add(new City(values[0], values[1], values[2], Integer.parseInt(values[3]), Integer.parseInt(values[4])));
                }
            }
        } else throw new FileNotFoundException("File " + file.getPath() + " is not found, empty or directory!");

        return cities;
    }

    public static List<City> ordering(List<City> cities, int typeOfOrdering) {
        switch (typeOfOrdering) {
            case 1:
                return cities.stream().sorted(Comparator.comparing(City::getName, String::compareToIgnoreCase)).collect(Collectors.toList());
            case 2:
                return cities.stream().sorted(Comparator.comparing(City::getDistrict).thenComparing(City::getName)).collect(Collectors.toList());
        }
        return cities;
    }

    public static int searchForTheMostPopulatedCity(List<City> cities) {
        City[] arrayCities = cities.toArray(new City[cities.size()]);
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
        List<String> keys = cities.stream().map(City::getRegion).distinct().collect(Collectors.toList());
        for (String x : keys) {
            int count = cities.stream().filter(a -> a.getRegion().equals(x)).mapToInt(a -> 1).sum();
            regionsAndCities.put(x, count);
        }
        return regionsAndCities;
    }
}
