package ru.directory.services;

import ru.directory.model.City;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class Printer {

    public static final String DEMARCATION_LINE = "---------------------------------";

    public static void printAll(List<City> cities, String message){
        System.out.println("\n" +message);
        System.out.println(DEMARCATION_LINE);
        printList(cities);
        System.out.println(DEMARCATION_LINE);
    }

    public static void printAll(Map<String,Integer> map, String message){
        System.out.println("\n" +message);
        System.out.println(DEMARCATION_LINE);
        printMap(map);
        System.out.println(DEMARCATION_LINE);
    }

    public static void printAll(int index, List<City> cities, String message){
        System.out.println("\n" +message);
        System.out.println(DEMARCATION_LINE);
        printIndexAndPop(index, cities);
        System.out.println(DEMARCATION_LINE);
    }

    public static void printList(List<City> cities) {
        System.out.println(DEMARCATION_LINE);
        cities.stream().forEach(System.out::println);
        System.out.println(DEMARCATION_LINE);
    }

    public static void printIndexAndPop (int index, List<City> cities) {
        System.out.printf("[%d] - %d%n", index, cities.get(index).getPopulation());
    }

    public static void printMap(Map<String,Integer> map) {
        map.forEach((k, v) -> {
            System.out.printf("%s - %d%n", k, v);
        });
    }
}
