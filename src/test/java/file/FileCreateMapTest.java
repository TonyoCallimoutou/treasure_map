package test.java.file;

import main.java.file.FileCreateMap;
import main.java.model.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FileCreateMapTest {

    private TreasureMap treasureMap;

    @Before
    public void setUp(){
        treasureMap = new TreasureMap();
    }

    @Test
    public void TestInitializeTreasureMap() {
        FileCreateMap.createTreasureMap("C - 3 - 4", treasureMap);
        assertEquals(3, treasureMap.getLimitX());
        assertEquals(4, treasureMap.getLimitY());
    }

    @Test
    public void TestSuccessAddMountain() {
        FileCreateMap.createTreasureMap("C - 3 - 4", treasureMap);
        FileCreateMap.createTreasureMap("M - 1 - 2", treasureMap);
        ItemTreasureMap itemMountain = treasureMap.getItemTreasureMap(new Position(1, 2));
        assertTrue(itemMountain instanceof Mountain);
    }

    @Test
    public void TestSuccessAddTreasure() {
        FileCreateMap.createTreasureMap("C - 3 - 4", treasureMap);
        FileCreateMap.createTreasureMap("T - 1 - 2 - 2", treasureMap);
        ItemTreasureMap itemTreasure = treasureMap.getItemTreasureMap(new Position(1, 2));
        assertTrue(itemTreasure instanceof Treasure);
        assertEquals(2, ((Treasure) itemTreasure).getQuantity());
    }

    @Test
    public void TestSuccessAddAdventurer() {
        FileCreateMap.createTreasureMap("C - 3 - 4", treasureMap);
        FileCreateMap.createTreasureMap("A - Lara - 1 - 2 - S - AADADAGGA", treasureMap);
        FileCreateMap.createTreasureMap("A - Lucas - 2 - 4 - N - AAGAADADA", treasureMap);
        Adventurer adventurer1 = treasureMap.getListAdventurer().get(0);
        Adventurer adventurer2 = treasureMap.getListAdventurer().get(1);

        assertEquals("Lara", adventurer1.getName());
        assertEquals(1, adventurer1.getPosition().getX());
        assertEquals(2, adventurer1.getPosition().getY());
        assertEquals('S', adventurer1.getOrientation().getLetter());
        assertEquals("AADADAGGA", adventurer1.getStringMovements());

        assertEquals("Lucas", adventurer2.getName());
        assertEquals(2, adventurer2.getPosition().getX());
        assertEquals(4, adventurer2.getPosition().getY());
        assertEquals('N', adventurer2.getOrientation().getLetter());
        assertEquals("AAGAADADA", adventurer2.getStringMovements());
    }

    @Test
    public void TestFailedAddUnknownItem() {
        FileCreateMap.createTreasureMap("C - 3 - 4", treasureMap);
        try {
            FileCreateMap.createTreasureMap("X - 1 - 2", treasureMap);
            fail("Expected exception was not thrown");
        } catch (RuntimeException e) {
            assertEquals("Format incorrect of first charactere : X", e.getMessage());
        }
    }


    @Test
    public void TestFailedAddMountainInExistingPosition() {
        FileCreateMap.createTreasureMap("C - 3 - 4", treasureMap);
        FileCreateMap.createTreasureMap("M - 1 - 2", treasureMap);
        try {
            FileCreateMap.createTreasureMap("M - 1 - 2", treasureMap);
            fail("Expected exception was not thrown");
        } catch (RuntimeException e) {
            assertEquals("An item already exists at position (x=1, y=2)", e.getMessage());
        }
    }

    @Test
    public void TestFailedAddTreasureInExistingPosition() {
        FileCreateMap.createTreasureMap("C - 3 - 4", treasureMap);
        FileCreateMap.createTreasureMap("M - 1 - 2", treasureMap);

        try {
            FileCreateMap.createTreasureMap("T - 1 - 2 - 2", treasureMap);
            fail("Expected exception was not thrown");
        } catch (RuntimeException e) {
            assertEquals("An item already exists at position (x=1, y=2)", e.getMessage());
        }
    }

    @Test
    public void TestFailedAddAdventurerInExistingPosition() {
        FileCreateMap.createTreasureMap("C - 3 - 4", treasureMap);
        FileCreateMap.createTreasureMap("M - 1 - 2", treasureMap);

        try {
            FileCreateMap.createTreasureMap("A - Lara - 1 - 2 - S - AADADAGGA", treasureMap);
            fail("Expected exception was not thrown");
        } catch (RuntimeException e) {
            assertEquals("An item already exists at position (x=1, y=2)", e.getMessage());
        }
    }

    @Test
    public void TestFailedAddMountainOutOfLimitInXMap() {
        FileCreateMap.createTreasureMap("C - 3 - 4", treasureMap);

        try {
            FileCreateMap.createTreasureMap("M - 4 - 3", treasureMap);
            fail("Expected exception was not thrown");
        } catch (RuntimeException e) {
            assertEquals("Position (x=4, y=3) is out of bounds", e.getMessage());
        }
    }

    @Test
    public void TestFailedAddTreasureOutOfLimitInYMap() {
        FileCreateMap.createTreasureMap("C - 3 - 4", treasureMap);

        try {
            FileCreateMap.createTreasureMap("T - 2 - 5 - 1", treasureMap);
            fail("Expected exception was not thrown");
        } catch (RuntimeException e) {
            assertEquals("Position (x=2, y=5) is out of bounds", e.getMessage());
        }
    }
}
