package org.treasure_map.model;

public class ItemTreasureMap {

    int id;
    private Position position;

    public ItemTreasureMap(Position position) {
        this.position = position;
    }

    public int getId() {
        return id;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setId(int id) {
        this.id = id;
    }

}
