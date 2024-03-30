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

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
