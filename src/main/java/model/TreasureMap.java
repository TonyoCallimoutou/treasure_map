package main.java.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TreasureMap {
    private Integer limitX;
    private Integer limitY;
    private Map<Position,ItemTreasureMap> mapItems;
    private final List<Adventurer> listAdventurer;

    public TreasureMap() {
        this.limitX = 0;
        this.limitY = 0;
        this.mapItems = new HashMap<>();
        this.listAdventurer = new ArrayList<>();
    }

    public Integer getLimitX() {
        return limitX;
    }

    public Integer getLimitY() {
        return limitY;
    }

    public Map<Position,ItemTreasureMap> getMapItems() {
        return mapItems;
    }

    public List<Adventurer> getListAdventurer() {
        return listAdventurer;
    }

    public void setLimitX(Integer limitX) {
        this.limitX = limitX;
    }

    public void setLimitY(Integer limitY) {
        this.limitY = limitY;
    }

    public void addItemTreasureMap(ItemTreasureMap item) {
        if (!mapItems.containsKey(item.getPosition())) {
            mapItems.put(item.getPosition(), item);
        } else {
            throw new IllegalArgumentException("An item already exists at position (" + item.getPosition().toString() + ")");
        }
    }

    public void addAdventurer(Adventurer adventurer) {
        listAdventurer.add(adventurer);
    }

    public List<String> toListOfString() {
        List<String> result = new ArrayList<>();
        result.add("C - " + limitX + " - " + limitY);
        List<Mountain> listMountain = new ArrayList<>();
        List<Treasure> listTreasure = new ArrayList<>();
        for (ItemTreasureMap item : mapItems.values()) {
            if (item instanceof Mountain) {
                listMountain.add((Mountain) item);
            } else if (item instanceof Treasure) {
                listTreasure.add((Treasure) item);
            }
        }
        for (Mountain mountain : listMountain) {
            result.add("M - " + mountain.getPosition().getX() + " - " + mountain.getPosition().getY());
        }
        for (Treasure treasure : listTreasure) {
            result.add("T - " + treasure.getPosition().getX() + " - " + treasure.getPosition().getY() + " - " + treasure.getQuantity());
        }
        for (Adventurer adventurer : listAdventurer) {
            result.add("A - " + adventurer.getName() + " - " + adventurer.getPosition().getX() + " - " + adventurer.getPosition().getY() + " - " + adventurer.getOrientation() + " - " + adventurer.getMovements());
        }

        return result;
    }
}
