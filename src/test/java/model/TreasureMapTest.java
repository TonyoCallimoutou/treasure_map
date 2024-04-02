package test.java.model;

import main.java.enums.Movement;
import main.java.enums.Orientation;
import main.java.model.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TreasureMapTest {

    @Test
    public void testMoveOneAdventurer() {
        Adventurer adventurer = new Adventurer("Lara", new Position(1, 2), Orientation.SOUTH, Movement.fromString("AAD"));
        TreasureMap treasureMap = new TreasureMap();
        treasureMap.setLimitX(4);
        treasureMap.setLimitY(5);
        treasureMap.addItemTreasureMap(adventurer);
        treasureMap.setNbrOfTurns(3);

        treasureMap.doAction();

        assertEquals(1, treasureMap.getAllAdventurer().size());
        adventurer = treasureMap.getAllAdventurer().get(0);

        assertEquals(new Position(1, 4), adventurer.getPosition());
        assertEquals(Orientation.WEST, adventurer.getOrientation());
    }

    @Test
    public void testMoveTwoAdventurer() {
        Adventurer adventurer1 = new Adventurer("Lara", new Position(1, 3), Orientation.SOUTH, Movement.fromString("AD"));
        Adventurer adventurer2 = new Adventurer("Lucas", new Position(1, 2), Orientation.SOUTH, Movement.fromString("GAA"));
        TreasureMap treasureMap = new TreasureMap();
        treasureMap.setLimitX(4);
        treasureMap.setLimitY(5);
        treasureMap.addItemTreasureMap(adventurer1);
        treasureMap.addItemTreasureMap(adventurer2);
        treasureMap.setNbrOfTurns(3);

        treasureMap.doAction();

        adventurer1 = treasureMap.getAllAdventurer().get(0);
        adventurer2 = treasureMap.getAllAdventurer().get(1);

        assertEquals(new Position(1, 4), adventurer1.getPosition());
        assertEquals(Orientation.WEST, adventurer1.getOrientation());
        assertEquals(new Position(3, 2), adventurer2.getPosition());
        assertEquals(Orientation.EAST, adventurer2.getOrientation());
    }
}
