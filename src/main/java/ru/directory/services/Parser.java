package ru.directory.services;

import ru.directory.model.City;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class Parser {

    public static List<City> directoryReader(String path) throws FileNotFoundException {
        List<City> cities = new ArrayList<>();
        File file = new File(path);
        if (file.length() > 0 && !file.isDirectory()) {
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] values = line.substring(line.indexOf(";") + 1, line.length()).split(";");
                    cities.add(new City(values[0], values[1], values[2], Integer.parseInt(values[3]), Integer.parseInt(values[4])));
                }
            }
        } else throw new FileNotFoundException("File " + file.getPath() + " is not found, empty or directory!");

        return cities;
    }
}
