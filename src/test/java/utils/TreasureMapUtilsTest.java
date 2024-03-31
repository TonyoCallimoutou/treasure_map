package test.java.utils;

import main.java.model.*;
import main.java.utils.TreasureMapUtils;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TreasureMapUtilsTest {


    @Test
    public void testAddItemTreasureMap() {
        Mountain mountain = new Mountain(new Position(2, 3));

        TreasureMap treasureMap = new TreasureMap();
        treasureMap.setLimitX(3);
        treasureMap.setLimitY(4);
        TreasureMapUtils.addItemTreasureMap(treasureMap, mountain);

        assertEquals(mountain, treasureMap.getMapItems().get(new Position(2, 3)));
    }

    @Test
    public void testMoveAdventurerNextMove() {
        Adventurer adventurer = new Adventurer("Lara", new Position(1, 2), Orientation.SOUTH, Movement.fromString("AADGAD"));
        TreasureMap treasureMap = new TreasureMap();
        treasureMap.setLimitX(4);
        treasureMap.setLimitY(5);
        treasureMap.addItemTreasureMap(adventurer);
        treasureMap.setNbrOfTurns(3);

        adventurer = treasureMap.getAllAdventurer().get(0);

        assertEquals(new Position(1, 2), adventurer.getPosition());
        assertEquals(6, adventurer.getMovements().size());

        TreasureMapUtils.moveAdventurerNextMove(treasureMap);

        assertEquals(new Position(1, 3), adventurer.getPosition());
        assertEquals(Orientation.SOUTH, adventurer.getOrientation());
        assertEquals(5, adventurer.getMovements().size());
    }

    @Test
    public void testGetAllAdventurer() {
        Adventurer adventurer1 = new Adventurer("Lara", new Position(1, 3), Orientation.SOUTH, Movement.fromString("AD"));
        Adventurer adventurer2 = new Adventurer("Lucas", new Position(1, 2), Orientation.SOUTH, Movement.fromString("GAA"));
        TreasureMap treasureMap = new TreasureMap();
        treasureMap.setLimitX(4);
        treasureMap.setLimitY(5);
        treasureMap.addItemTreasureMap(adventurer1);
        treasureMap.addItemTreasureMap(adventurer2);

        List<Adventurer> adventurers = TreasureMapUtils.getAllAdventurer(treasureMap);

        assertEquals(2, adventurers.size());
        assertEquals(adventurer1, adventurers.get(0));
        assertEquals(adventurer2, adventurers.get(1));
    }

    @Test
    public void testToListOfString() {

        Mountain mountain = new Mountain(new Position(2, 3));
        Treasure treasure = new Treasure(new Position(3, 2), 2);
        Treasure treasure2 = new Treasure(new Position(2, 2), 1);
        Adventurer adventurer = new Adventurer("Lara", new Position(1, 2), Orientation.SOUTH, Movement.fromString("AADADAGGA"));
        adventurer.addTreasure();


        TreasureMap treasureMap = new TreasureMap();
        treasureMap.setLimitX(4);
        treasureMap.setLimitY(5);
        treasureMap.addItemTreasureMap(adventurer);
        treasureMap.addItemTreasureMap(mountain);
        treasureMap.addItemTreasureMap(treasure);
        treasureMap.addItemTreasureMap(treasure2);

        List<String> result = TreasureMapUtils.toListOfString(treasureMap);
        for (String s : result) {
            switch (s.charAt(0)) {
                case 'C':
                    assertEquals("C - 4 - 5", s);
                    break;
                case 'M':
                    assertEquals("M - 2 - 3", s);
                    break;
                case 'T':
                    if (s.contains("T - 3 - 2 - 2")) {
                        assertEquals("T - 3 - 2 - 2", s);
                    } else {
                        assertEquals("T - 2 - 2 - 1", s);
                    }
                    break;
                case 'A':
                    assertEquals("A - Lara - 1 - 2 - S - 1", s);
                    break;
                default:
                    fail("Unexpected line: " + s);
            }
        }
    }
}
