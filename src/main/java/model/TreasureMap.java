package main.java.model;

import main.java.utils.PositionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TreasureMap {
    private int limitX;
    private int limitY;
    private Map<Position,ItemTreasureMap> mapItems;
    private final List<Adventurer> listAdventurer;

    public TreasureMap() {
        this.limitX = 0;
        this.limitY = 0;
        this.mapItems = new HashMap<>();
        this.listAdventurer = new ArrayList<>();
    }

    public int getLimitX() {
        return limitX;
    }

    public int getLimitY() {
        return limitY;
    }

    public ItemTreasureMap getItemTreasureMap(Position position) {
        return mapItems.get(position);
    }

    public List<Adventurer> getListAdventurer() {
        return listAdventurer;
    }

    public void setLimitX(int limitX) {
        this.limitX = limitX;
    }

    public void setLimitY(int limitY) {
        this.limitY = limitY;
    }

    /**
     * Add a Mountain or Treasure to the map
     * @param item
     */
    public void addItemTreasureMap(ItemTreasureMap item) {
        if (!mapItems.containsKey(item.getPosition())) {
            if (PositionUtils.isPositionInBound(item.getPosition(), limitX, limitY)) {
                mapItems.put(item.getPosition(), item);
            }
        } else {
            throw new IllegalArgumentException("An item already exists at position (" + item.getPosition().toString() + ")");
        }
    }

    /**
     * Add an adventurer to the map
     * @param adventurer
     */
    public void addAdventurer(Adventurer adventurer) {
        if (mapItems.containsKey(adventurer.getPosition())) {
            throw new IllegalArgumentException("An item already exists at position (" + adventurer.getPosition().toString() + ")");
        }
        if (PositionUtils.isPositionInBound(adventurer.getPosition(), limitX, limitY)) {
            listAdventurer.add(adventurer);
        }
    }

    /**
     * Get list of string for output result
     * @return list of different items in the map
     */
    public List<String> toListOfString() {
        List<String> result = new ArrayList<>();
        result.add("C - " + limitX + " - " + limitY);
        for (ItemTreasureMap item : mapItems.values()) {
            if (item instanceof Mountain) {
                result.add("M - " + item.getPosition().getX() + " - " + item.getPosition().getY());
            } else if (item instanceof Treasure) {
                result.add("T - " + item.getPosition().getX() + " - " + item.getPosition().getY() + " - " + ((Treasure) item).getQuantity());
            }
        }
        for (Adventurer adventurer : listAdventurer) {
            result.add("A - " + adventurer.getName() + " - " + adventurer.getPosition().getX() + " - " + adventurer.getPosition().getY() + " - " + adventurer.getOrientation().getLetter() + " - " + adventurer.getStringMovements());
        }

        return result;
    }
}
