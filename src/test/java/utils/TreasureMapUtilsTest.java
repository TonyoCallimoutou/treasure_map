package test.java.utils;

import main.java.model.*;
import main.java.utils.TreasureMapUtils;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TreasureMapUtilsTest {

    @Test
    public void testToListOfString() {

        Mountain mountain = new Mountain(new Position(2, 3));
        Treasure treasure = new Treasure(new Position(3, 2), 2);
        Treasure treasure2 = new Treasure(new Position(2, 2), 1);
        Adventurer adventurer = new Adventurer("Lara", new Position(1, 2), Orientation.SOUTH, Movement.fromString("AADADAGGA"));
        adventurer.addTreasure();


        TreasureMap treasureMap = new TreasureMap();
        treasureMap.setLimitX(3);
        treasureMap.setLimitY(4);
        treasureMap.addItemTreasureMap(adventurer);
        treasureMap.addItemTreasureMap(mountain);
        treasureMap.addItemTreasureMap(treasure);
        treasureMap.addItemTreasureMap(treasure2);

        List<String> result = TreasureMapUtils.toListOfString(treasureMap);
        for (String s : result) {
            switch (s.charAt(0)) {
                case 'C':
                    assertEquals("C - 3 - 4", s);
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

    @Test
    public void testAddItemTreasureMap() {
        Mountain mountain = new Mountain(new Position(2, 3));

        TreasureMap treasureMap = new TreasureMap();
        treasureMap.setLimitX(3);
        treasureMap.setLimitY(4);
        TreasureMapUtils.addItemTreasureMap(treasureMap, mountain);

        assertEquals(mountain, treasureMap.getMapItems().get(new Position(2, 3)));
    }
}
