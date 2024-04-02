package org.treasure_map.model;


import org.treasure_map.utils.TreasureMapUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TreasureMap {
    private int limitX;
    private int limitY;
    private final Map<Position,ItemTreasureMap> mapItems;
    private int nbrOfTurns;

    public TreasureMap() {
        this.limitX = 0;
        this.limitY = 0;
        this.mapItems = new HashMap<>();
        this.nbrOfTurns = 0;
    }

    public int getLimitX() {
        return limitX;
    }

    public int getLimitY() {
        return limitY;
    }

    public Map<Position, ItemTreasureMap> getMapItems() {
        return mapItems;
    }

    public ItemTreasureMap getItemTreasureMapAtPosition(Position position) {
        return mapItems.get(position);
    }

    public List<Adventurer> getAllAdventurer() {
        return TreasureMapUtils.getAllAdventurer(this);
    }

    public void setLimitX(int limitX) {
        this.limitX = limitX;
    }

    public void setLimitY(int limitY) {
        this.limitY = limitY;
    }

    public void setNbrOfTurns(int nbrOfTurns) {
        this.nbrOfTurns = Integer.max(this.nbrOfTurns, nbrOfTurns);
    }

    /**
     * Add a Mountain or Treasure to the map
     * @param item
     */
    public void addItemTreasureMap(ItemTreasureMap item) {
        TreasureMapUtils.addItemTreasureMap(this, item);
    }

    public void removeTreasure(ItemTreasureMap item) {
        mapItems.remove(item.getPosition());
    }

    public void doAction() {
        for (int i=0; i<nbrOfTurns; i++) {
            TreasureMapUtils.moveAdventurerNextMove(this);
        }
    }

    /**
     * Get list of string for output result
     * @return list of different items in the map
     */
    public List<String> toListOfString() {
        return TreasureMapUtils.toListOfString(this);
    }
}
