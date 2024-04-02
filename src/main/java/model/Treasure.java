package main.java.model;

import main.java.constants.FileConst;
import main.java.enums.LetterItem;

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
        return LetterItem.TREASURE.getLetter() + FileConst.SEPARATOR + getPosition().getX() + FileConst.SEPARATOR + getPosition().getY() + FileConst.SEPARATOR + quantity;
    }
}
