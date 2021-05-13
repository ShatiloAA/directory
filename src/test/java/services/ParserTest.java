package services;

import org.junit.jupiter.api.Test;
import ru.directory.services.Parser;


import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;
import static services.util.UtilForTests.*;


class ParserTest {



    @Test()
    void readFileSuccessful() {
        assertNotNull(listFromFile);
    }

    @Test
    void parseSuccessful() {
        assertEquals(testList, listFromFile);
    }

    @Test
    void fileNotFound() {
        FileNotFoundException exception = assertThrows(FileNotFoundException.class, () ->
                Parser.directoryReader("blabla.txt"));
    }

    @Test
    void readEmptyFileOrDirectory() {
        String path = "resources/empty.txt";
        FileNotFoundException exception = assertThrows(FileNotFoundException.class, () ->
                Parser.directoryReader("resources/empty.txt"));
        assertEquals("File " + path + " is not found, empty or directory!", exception.getMessage());
    }

}