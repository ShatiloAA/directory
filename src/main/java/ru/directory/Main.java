package ru.directory;

import ru.directory.model.City;
import ru.directory.services.Order;
import ru.directory.services.Parser;
import ru.directory.services.Printer;
import ru.directory.services.Searcher;

import java.util.List;

import static ru.directory.services.Printer.DEMARCATION_LINE;
import static ru.directory.services.Printer.printAll;
import static ru.directory.services.utils.PropertyManager.DEFAULT_PATH;

public class Main {


    public static void main(String[] args) throws Exception {

        List<City> cityList = Parser.directoryReader(DEFAULT_PATH);

        printAll(cityList, "First module");
        printAll(Order.orderByName(cityList), "Second module, sort by Name");
        printAll(Order.orderByDistrictThenByName(cityList), "Second module, sort by Name");
        printAll(Searcher.searchForTheMostPopulatedCity(cityList), cityList, "Third Module");
        printAll(Searcher.findingTheNumberOfCitiesInRegions(cityList), "Forty module");

    }
}
