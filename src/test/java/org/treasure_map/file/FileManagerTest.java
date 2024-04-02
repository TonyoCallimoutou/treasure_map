package org.treasure_map.file;

import org.treasure_map.enums.Movement;
import org.treasure_map.enums.Orientation;
import org.junit.Test;
import org.treasure_map.model.*;

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
    public void testFailedInexistingFileFromTxt() {

        String testFile = "src/test/resources/fake_input.txt";
        try {
            FileManager.createTreasureMapReadFileFromTxt(testFile);
            fail("Expected exception was not thrown");
        } catch (RuntimeException e) {
            assertNotNull(e);
        }
    }

    @Test
    public void testFailedCreateTreasureMapReadFileFromTxtBlank() {

        String testFile = "src/test/resources/input_blank.txt";
        try {
            FileManager.createTreasureMapReadFileFromTxt(testFile);
            fail("Expected exception was not thrown");
        } catch (RuntimeException e) {
            assertEquals("The file is empty", e.getMessage());
        }
    }

    @Test
    public void testFailedCreateTreasureMapReadFileFromTxtMultiMap() {

        String testFile = "src/test/resources/input_with_multi_map.txt";
        try {
            FileManager.createTreasureMapReadFileFromTxt(testFile);
            fail("Expected exception was not thrown");
        } catch (RuntimeException e) {
            assertEquals("The map is already initialized", e.getMessage());
        }
    }

    @Test
    public void testCreateTreasureMapReadFileFromTxtWithSpace() {
        String testFile = "src/test/resources/input_with_space.txt";
        TreasureMap treasureMap = FileManager.createTreasureMapReadFileFromTxt(testFile);
        assertNotNull(treasureMap);
    }

    @Test
    public void testFailedCreateTreasureMapReadFileFromTxtChangeSeparator() {
        String testFile = "src/test/resources/input_change_separator.txt";
        try {
            FileManager.createTreasureMapReadFileFromTxt(testFile);
            fail("Expected exception was not thrown");
        } catch (RuntimeException e) {
            assertEquals("Format incorrect for treasure map", e.getMessage());
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
        treasureMap.setLimitX(4);
        treasureMap.setLimitY(5);
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

    @Test
    public void testFailedInexistingFolderWriteFileForSaveResult() {

        String file = "src/test/resources/folder/result.txt";

        Path filePath = Paths.get(file);
        assertFalse(Files.exists(filePath));


        Mountain mountain = new Mountain(new Position(2, 3));
        Treasure treasure = new Treasure(new Position(3, 2), 2);
        Treasure treasure2 = new Treasure(new Position(2, 2), 1);
        Adventurer adventurer = new Adventurer("Lara", new Position(1, 2), Orientation.SOUTH, Movement.fromString("AADADAGGA"));

        TreasureMap treasureMap = new TreasureMap();
        treasureMap.setLimitX(4);
        treasureMap.setLimitY(5);
        treasureMap.addItemTreasureMap(adventurer);
        treasureMap.addItemTreasureMap(mountain);
        treasureMap.addItemTreasureMap(treasure);
        treasureMap.addItemTreasureMap(treasure2);

        try {
            FileManager.writeFileForSaveResult(treasureMap, file);
            fail("Expected exception was not thrown");
        } catch (RuntimeException e) {
            assertNotNull(e);
        }
    }

}