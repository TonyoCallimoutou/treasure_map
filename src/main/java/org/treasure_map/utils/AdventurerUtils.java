package org.treasure_map.utils;

import org.treasure_map.enums.Movement;
import org.treasure_map.model.*;

import java.util.List;

public class AdventurerUtils {

    public static String getStringMovements(List<Movement> movements) {
        StringBuilder strMovements = new StringBuilder();
        for (Movement movement : movements) {
            strMovements.append(movement.getLetter());
        }
        return strMovements.toString();
    }

    public static void moveAdventurer(Adventurer adventurer, Movement movement, TreasureMap treasureMap) {
        switch (movement) {
            case TURN_LEFT:
                adventurer.setOrientation(adventurer.getOrientation().turnLeft());

                System.out.println(adventurer.getName() + " turn to " + adventurer.getOrientation());
                break;
            case TURN_RIGHT:
                adventurer.setOrientation(adventurer.getOrientation().turnRight());

                System.out.println(adventurer.getName() + " turn to " + adventurer.getOrientation());
                break;
            case MOVE_FORWARD:
                moveForward(adventurer, treasureMap);
                break;
        }
    }

    public static void moveForward(Adventurer adventurer, TreasureMap treasureMap) {
        Position newPosition = new Position(adventurer.getPosition().getX(), adventurer.getPosition().getY());
        switch (adventurer.getOrientation()) {
            case NORTH:
                newPosition.setY(newPosition.getY() - 1);
                break;
            case EAST:
                newPosition.setX(newPosition.getX() + 1);
                break;
            case SOUTH:
                newPosition.setY(newPosition.getY() + 1);
                break;
            case WEST:
                newPosition.setX(newPosition.getX() - 1);
                break;
        }
        if (PositionUtils.isPositionInBound(newPosition, treasureMap.getLimitX(), treasureMap.getLimitY())) {
            ItemTreasureMap item = treasureMap.getItemTreasureMapAtPosition(newPosition);
            if (item == null || item instanceof Treasure) {
                adventurer.setPosition(newPosition);
                System.out.println(adventurer.getName() + " move at position (" + adventurer.getPosition().toString() + ")");
            }
            if (item instanceof Treasure) {
                adventurer.addTreasure();
                ((Treasure) item).removeOne();
                if (((Treasure) item).getQuantity() == 0) {
                    treasureMap.removeTreasure(item);
                }
                System.out.println(adventurer.getName() + " collect one more treasure and have " + adventurer.getTreasures() + " treasures now");
            }
            else if (item instanceof Mountain) {
                System.out.println(adventurer.getName() + " is blocked by a mountain ");
            }
            else if (item instanceof Adventurer) {
                System.out.println(adventurer.getName() + " is blocked by " + ((Adventurer) item).getName());
            }
        }

    }
}
