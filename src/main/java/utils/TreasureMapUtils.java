package main.java.utils;

import main.java.model.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TreasureMapUtils {

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
                item.setId(treasureMap.getMapItems().size());
                treasureMap.getMapItems().put(item.getPosition(), item);
            }
        } else {
            throw new IllegalArgumentException("An item already exists at position (" + item.getPosition().toString() + ")");
        }
    }

    /**
     * Move an adventurer on the map
     * @param treasureMap
     */
    public static void moveAdventurerNextMove(TreasureMap treasureMap) {
        for (Adventurer adventurer : treasureMap.getAllAdventurer()) {
            if (!adventurer.getMovements().isEmpty()) {
                Movement movement = adventurer.getMovements().remove(0);
                AdventurerUtils.moveAdventurer(adventurer, movement, treasureMap);
            }
        }
    }

    public static List<Adventurer> getAllAdventurer(TreasureMap treasureMap) {
        List<Adventurer> adventurers = new ArrayList<>();
        for (ItemTreasureMap item : treasureMap.getMapItems().values()) {
            if (item instanceof Adventurer) {
                adventurers.add((Adventurer) item);
            }
        }
        adventurers.sort(Comparator.comparing(Adventurer::getId));
        return adventurers;
    }

    /**
     * Get list of string for output result
     * @return list of different items in the map
     */
    public static List<String> toListOfString(TreasureMap treasureMap) {
        List<String> result = new ArrayList<>();
        result.add("C - " + treasureMap.getLimitX() + " - " + treasureMap.getLimitY());

        List<ItemTreasureMap> items = new ArrayList<>(treasureMap.getMapItems().values());
        items.sort(Comparator.comparingInt(ItemTreasureMap::getId));
        for (ItemTreasureMap item : items) {
            result.add(item.toString());
        }

        return result;
    }
}
