package main.java.model;

public class Treasure extends ItemTreasureMap {
    private int quantity;

    public Treasure(Position position, int quantity) {
        super(position);
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void removeOne() {
        quantity--;
    }

    @Override
    public String toString() {
        return "T - " + getPosition().getX() + " - " + getPosition().getY() + " - " + quantity;
    }
}
