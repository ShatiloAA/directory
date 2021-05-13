package services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.directory.model.City;
import ru.directory.services.Order;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static services.util.UtilForTests.testList;


class OrderTest {

    @Test
    void firstCaseOrdering() {
        List<City> orderedList = new ArrayList<>(testList);
        Collections.sort(orderedList, (o1, o2) -> o1.getName().compareTo(o2.getName()));
        Assertions.assertEquals(orderedList, Order.orderByName(testList));
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
        assertEquals(orderedList, Order.orderByDistrictThenByName(testList));
    }

}