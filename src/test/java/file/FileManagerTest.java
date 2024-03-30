package test.java.file;

import main.java.file.FileManager;
import main.java.model.*;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class FileManagerTest {

    @Test
    public void testCreateTreasureMapReadFileFromTxt() {

        String testFile = "src/test/resources/input.txt";
        TreasureMap treasureMap = FileManager.createTreasureMapReadFileFromTxt(testFile);
        assertNotNull(treasureMap);
    }

    @Test
    public void testFailedCreateTreasureMapReadFileFromTxt() {

        String testFile = "src/test/resources/fake_input.txt";
        try {
            FileManager.createTreasureMapReadFileFromTxt(testFile);
            fail("Expected exception was not thrown");
        } catch (RuntimeException e) {
            assertNotNull(e);
        }
    }

    @Test
    public void testWriteFileForSaveResult() {

        String file = "src/test/resources/result.txt";

        Path filePath = Paths.get(file);
        assertFalse(Files.exists(filePath));


        Mountain mountain = new Mountain(new Position(2, 3));
        Treasure treasure = new Treasure(new Position(3, 2), 2);
        Treasure treasure2 = new Treasure(new Position(2, 2), 1);
        Adventurer adventurer = new Adventurer("Lara", new Position(1, 2), Orientation.SOUTH, Movement.fromString("AADADAGGA"));

        TreasureMap treasureMap = new TreasureMap();
        treasureMap.setLimitX(3);
        treasureMap.setLimitY(4);
        treasureMap.addItemTreasureMap(adventurer);
        treasureMap.addItemTreasureMap(mountain);
        treasureMap.addItemTreasureMap(treasure);
        treasureMap.addItemTreasureMap(treasure2);

        FileManager.writeFileForSaveResult(treasureMap, file);

        assertTrue(Files.exists(filePath));

        try {
            Files.delete(filePath);
        } catch (IOException e) {
            fail("Error deleting file");
        }
    }

}