package services.util;

import ru.directory.model.City;
import ru.directory.services.Parser;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static ru.directory.services.utils.PropertyManager.DEFAULT_PATH;

public class UtilForTests extends Exception {

    public static final City CITY1 = new City("Адыгейск", "Адыгея", "Южный", 12248, 1973);
    public static final City CITY2 = new City("Майкоп", "Адыгея", "Южный", 144246, 1857);
    public static final City CITY3 = new City("Горно-Алтайск", "Алтай", "Сибирский", 56928, 1830);

    public static List<City> testList = new ArrayList<>() {{
        add(CITY1);
        add(CITY2);
        add(CITY3);
    }};

    public static List<City> listFromFile;

    static {
        try {
            listFromFile = Parser.directoryReader(DEFAULT_PATH);
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
    }
}
