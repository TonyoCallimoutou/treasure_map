package main.java.model;

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

    public boolean isTreasure() {
        return this instanceof Treasure;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setId(int id) {
        this.id = id;
    }

}
