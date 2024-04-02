package test.java.utils;

import main.java.enums.Movement;
import main.java.enums.Orientation;
import main.java.model.*;
import main.java.utils.AdventurerUtils;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AdventurerUtilsTest {

    String movementStr = "AADADAGGA";
    int limitX = 4;
    int limitY = 5;
    int positionX = 1;
    int positionY = 2;
    Adventurer adventurer1;
    Adventurer adventurer2;
    TreasureMap treasureMap;


    @Before
    public void setUp() {
        adventurer1 = new Adventurer("Lara", new Position(positionX, positionY), Orientation.EAST, Movement.fromString(movementStr));
        adventurer2 = new Adventurer("Lucas", new Position(0, 0), Orientation.EAST, Movement.fromString(movementStr));
        treasureMap = new TreasureMap();
        treasureMap.setLimitX(limitX);
        treasureMap.setLimitY(limitY);
    }

    @Test
    public void testGetStringMovements() {
        String result = AdventurerUtils.getStringMovements(adventurer1.getMovements());
        assertEquals(movementStr, result);
    }

    @Test
    public void testMoveForwardAdventurerNorth() {
        adventurer1.setOrientation(Orientation.NORTH);
        AdventurerUtils.moveAdventurer(adventurer1, Movement.MOVE_FORWARD, treasureMap);
        assertEquals(new Position(positionX, positionY-1), adventurer1.getPosition());
    }

    @Test
    public void testMoveForwardAdventurerEast() {
        adventurer1.setOrientation(Orientation.EAST);
        AdventurerUtils.moveAdventurer(adventurer1, Movement.MOVE_FORWARD, treasureMap);
        assertEquals(new Position(positionX+1, positionY), adventurer1.getPosition());
    }

    @Test
    public void testMoveForwardAdventurerWest() {
        adventurer1.setOrientation(Orientation.WEST);
        AdventurerUtils.moveAdventurer(adventurer1, Movement.MOVE_FORWARD, treasureMap);
        assertEquals(new Position(positionX-1, positionY), adventurer1.getPosition());
    }

    @Test
    public void testMoveForwardAdventurerSouth() {
        adventurer1.setOrientation(Orientation.SOUTH);
        AdventurerUtils.moveAdventurer(adventurer1, Movement.MOVE_FORWARD, treasureMap);
        assertEquals(new Position(positionX, positionY+1), adventurer1.getPosition());
    }

    @Test
    public void testTurnLeftAdventurer() {
        AdventurerUtils.moveAdventurer(adventurer1, Movement.TURN_LEFT, treasureMap);
        assertEquals(Orientation.NORTH, adventurer1.getOrientation());

        AdventurerUtils.moveAdventurer(adventurer1, Movement.TURN_LEFT, treasureMap);
        assertEquals(Orientation.WEST, adventurer1.getOrientation());

        AdventurerUtils.moveAdventurer(adventurer1, Movement.TURN_LEFT, treasureMap);
        assertEquals(Orientation.SOUTH, adventurer1.getOrientation());

        AdventurerUtils.moveAdventurer(adventurer1, Movement.TURN_LEFT, treasureMap);
        assertEquals(Orientation.EAST, adventurer1.getOrientation());
    }

    @Test
    public void testTurnRightAdventurer() {

        AdventurerUtils.moveAdventurer(adventurer1, Movement.TURN_RIGHT, treasureMap);
        assertEquals(Orientation.SOUTH, adventurer1.getOrientation());

        AdventurerUtils.moveAdventurer(adventurer1, Movement.TURN_RIGHT, treasureMap);
        assertEquals(Orientation.WEST, adventurer1.getOrientation());

        AdventurerUtils.moveAdventurer(adventurer1, Movement.TURN_RIGHT, treasureMap);
        assertEquals(Orientation.NORTH, adventurer1.getOrientation());

        AdventurerUtils.moveAdventurer(adventurer1, Movement.TURN_RIGHT, treasureMap);
        assertEquals(Orientation.EAST, adventurer1.getOrientation());
    }

    @Test
    public void testFailedMoveForwardAdventurerCauseOutOfBound() {
        adventurer1.setPosition(new Position(limitX - 1, limitY - 1));
        adventurer1.setOrientation(Orientation.EAST);
        try {
            AdventurerUtils.moveAdventurer(adventurer1, Movement.MOVE_FORWARD, treasureMap);
            fail("Expected exception was not thrown");
        } catch (RuntimeException e) {
            assertEquals("Position (x="+limitX+", y="+limitX+") is out of bounds", e.getMessage());
        }
    }

    @Test
    public void testFailedMoveForwardAdventurerCauseOfMountain() {
        Position positionOrigin = new Position(positionX, positionY);
        Position positionMountain = new Position(positionX+1, positionY);
        adventurer1.setPosition(positionOrigin);
        treasureMap.addItemTreasureMap(new Mountain(positionMountain));

        AdventurerUtils.moveAdventurer(adventurer1, Movement.MOVE_FORWARD, treasureMap);
        assertEquals(positionOrigin, adventurer1.getPosition());
    }

    @Test
    public void testFailedMoveForwardAdventurerCauseOfAdventurer() {
        Position positionOrigin = new Position(positionX, positionY);
        Position positionAdventurer = new Position(positionX+1, positionY);
        adventurer1.setPosition(positionOrigin);
        adventurer2.setPosition(positionAdventurer);
        treasureMap.addItemTreasureMap(adventurer2);

        AdventurerUtils.moveAdventurer(adventurer1, Movement.MOVE_FORWARD, treasureMap);
        assertEquals(positionOrigin, adventurer1.getPosition());
    }

    @Test
    public void testFailedMoveForwardAdventurerCollectTreasure() {
        Position positionTreasure = new Position(positionX+1, positionY);
        int quantity = 3;
        Treasure treasure = new Treasure(positionTreasure, quantity);
        treasureMap.addItemTreasureMap(treasure);

        AdventurerUtils.moveAdventurer(adventurer1, Movement.MOVE_FORWARD, treasureMap);
        assertEquals(positionTreasure, adventurer1.getPosition());
        assertEquals(1, adventurer1.getTreasures());
        assertEquals(quantity-1, treasure.getQuantity());
    }

    @Test
    public void testFailedMoveForwardAdventurerCollectLastTreasure() {
        Position positionTreasure = new Position(positionX+1, positionY);
        Treasure treasure = new Treasure(positionTreasure, 1);
        treasureMap.addItemTreasureMap(treasure);

        AdventurerUtils.moveAdventurer(adventurer1, Movement.MOVE_FORWARD, treasureMap);
        assertEquals(0, treasure.getQuantity());
        assertNull(treasureMap.getItemTreasureMapAtPosition(positionTreasure));
    }
}
