package main.java.model;

import main.java.utils.TreasureMapUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TreasureMap {
    private int limitX;
    private int limitY;
    private Map<Position,ItemTreasureMap> mapItems;

    public TreasureMap() {
        this.limitX = 0;
        this.limitY = 0;
        this.mapItems = new HashMap<>();
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
        TreasureMapUtils.addItemTreasureMap(this, item);
    }

    /**
     * Get list of string for output result
     * @return list of different items in the map
     */
    public List<String> toListOfString() {
        return TreasureMapUtils.toListOfString(this);
    }
}
