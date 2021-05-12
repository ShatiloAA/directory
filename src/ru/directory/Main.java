package ru.directory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws Exception {
        // write your code here


        List<City> cityList = Util.directoryReader("directory.txt");
        System.out.println("First module");
        System.out.println(Util.DEMARCATION_LINE);
        cityList.stream().forEach(System.out::println);
        System.out.println(Util.DEMARCATION_LINE);

        System.out.println("\nSecond Module");
        System.out.println(Util.DEMARCATION_LINE);
        System.out.println("First Case");
        List<City> orderedListByFirstCase = Util.ordering(cityList, 1);
        orderedListByFirstCase.stream().forEach(System.out::println);
        System.out.println("\nSecond Case");
        List<City> orderedListBySecondCase = Util.ordering(cityList, 2);
        orderedListBySecondCase.stream().forEach(System.out::println);
        System.out.println(Util.DEMARCATION_LINE);

        System.out.println("\nThird Module");
        System.out.println(Util.DEMARCATION_LINE);
        //System.out.println(Util.searchForTheMostPopulatedCity(cityList));
        int index = Util.searchForTheMostPopulatedCity(cityList);
        int population = cityList.get(index).getPopulation();
        System.out.printf("[%d] - %d%n", index, population);
        System.out.println(Util.DEMARCATION_LINE);

        System.out.println("\nForty Module");
        System.out.println(Util.DEMARCATION_LINE);
        Util.findingTheNumberOfCitiesInRegions(cityList).forEach((k, v) -> {
            System.out.printf("%s - %d%n", k, v);
        });
        System.out.println(Util.DEMARCATION_LINE);

    }
}
