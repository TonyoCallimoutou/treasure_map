package main.java.utils;

import main.java.model.*;

import java.util.ArrayList;
import java.util.List;

public class TreasureMapUtils {

    /**
     * Get list of string for output result
     * @return list of different items in the map
     */
    public static List<String> toListOfString(TreasureMap treasureMap) {
        java.util.List<java.lang.String> result = new ArrayList<>();
        result.add("C - " + treasureMap.getLimitX() + " - " + treasureMap.getLimitY());
        for (ItemTreasureMap item : treasureMap.getMapItems().values()) {
            switch (item.getClass().getSimpleName()) {
                case "Mountain":
                    result.add("M - " + item.getPosition().getX() + " - " + item.getPosition().getY());
                    break;
                case "Treasure":
                    result.add("T - " + item.getPosition().getX() + " - " + item.getPosition().getY() + " - " + ((Treasure) item).getQuantity());
                    break;
                case "Adventurer":
                    result.add("A - " + ((Adventurer) item).getName() + " - " + ((Adventurer) item).getPosition().getX() + " - " + ((Adventurer) item).getPosition().getY() + " - " + ((Adventurer) item).getOrientation().getLetter() + " - " + ((Adventurer) item).getTreasures());
                    break;
            }
        }

        return result;
    }

    /**
     * Add a Mountain or Treasure to the map
     * @param item
     */
    public static void addItemTreasureMap(TreasureMap treasureMap, ItemTreasureMap item) {
        if (treasureMap.getLimitX() == 0 || treasureMap.getLimitY() == 0) {
            throw new IllegalArgumentException("The map must be initialized before adding items");
        }
        if (!treasureMap.getMapItems().containsKey(item.getPosition())) {
            if (PositionUtils.isPositionInBound(item.getPosition(), treasureMap.getLimitX(), treasureMap.getLimitY())) {
                treasureMap.getMapItems().put(item.getPosition(), item);
            }
        } else {
            throw new IllegalArgumentException("An item already exists at position (" + item.getPosition().toString() + ")");
        }
    }
}
