package main.java.model;

public class Treasure extends ItemTreasureMap {
    private Integer quantity;

    public Treasure(Position position, Integer quantity) {
        super(position);
        this.quantity = quantity;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
